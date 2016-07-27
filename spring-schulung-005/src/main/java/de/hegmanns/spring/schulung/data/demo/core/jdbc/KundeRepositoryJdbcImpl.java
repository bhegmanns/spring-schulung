package de.hegmanns.spring.schulung.data.demo.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hegmanns.spring.schulung.data.demo.core.Kunde;
import de.hegmanns.spring.schulung.data.demo.core.KundeRepository;

public class KundeRepositoryJdbcImpl implements KundeRepository {

	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
	   static final String DB_URL = "jdbc:derby://localhost:1527/db;user=derby;password=derby;create=true";

	   private void registerDriver() {
	         try {
	                Class.forName(JDBC_DRIVER).newInstance();
	         } catch (InstantiationException e) {
	         } catch (IllegalAccessException e) {
	         } catch (ClassNotFoundException e) {
	         }
	   }
	
	
	@Override
	public Kunde getKundeById(long id) {
		Connection conn = null;
        Kunde kunde = null;
        try {
              // register apache derby driver
              registerDriver();
              // open a connection using DB url
              conn = getConnection();
             // Creates a PreparedStatement object for sending parameterized SQL
             // statements to the database
             PreparedStatement ps = conn
                          .prepareStatement("select * from kunde where id = ?");
             // Sets the designated parameter to the given Java int value
             ps.setLong(1, id);
             // Executes the SQL query in this PreparedStatement object and
             // returns the ResultSet object
             ResultSet rs = ps.executeQuery();
             if (rs.next()) {
            	 kunde = new Kunde();
            	 kunde.setId(id);
            	 kunde.setVorname(rs.getString("vorname"));
            	 kunde.setNachname(rs.getString("nachname"));
              }
              rs.close();
              ps.close();
       } catch (SQLException e) {
              throw new RuntimeException(e);
       } finally {
              if (conn != null) {
                    try {
                          conn.close();
                    } catch (SQLException e) {
                    }
              }
       }
       return kunde;
	}

	@Override
	public void addKunde(Kunde kunde) {
		Connection conn = null;
        try {
              // register apache derby driver
              registerDriver();
              // open a connection using DB url
              conn = getConnection();
              Statement stmt = conn.createStatement();
              stmt.executeUpdate("insert into kunde values ("
                          + kunde.getId() + ",'" + kunde.getVorname() + "','" + kunde.getNachname() + "')");
              stmt.close();
        } catch (SQLException e) {
        	String message = e.getMessage();
        	//'KUNDE' already exists in Schema
        	boolean matches = message.matches(".*KUNDE.*already exists in Schema.*");
        	System.out.println(">>>>NACHRICHT>" + e.getLocalizedMessage() + "<NACHRICHT<<<<");
        	if (!matches){
        		
              throw new RuntimeException(e);
        	}else{
        		System.out.println("" + e.getMessage());
        		
        	}
        } finally {
             if (conn != null) {
                    try {
                          conn.close();
                    } catch (SQLException e) {
                    }
             }
       }
	}

	@Override
	   public void createDatabase() {
	          Connection conn = null;
	          try {
	                // register apache derby driver
	                registerDriver();
	                // open a connection using DB url
	                conn = getConnection();
	                Statement stmt = conn.createStatement();
	                stmt.executeUpdate("create table kunde (id integer, vorname char(30), nachname char(30))");
	                stmt.close();
	          } catch (SQLException e) {
	               throw new RuntimeException(e);
	          } finally {
	               if (conn != null) {
	                      try {
	                            conn.close();
	                      } catch (SQLException e) {
	                      }
	                }
	         }
	   }
	
	protected Connection getConnection(){
		try {
			return DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
