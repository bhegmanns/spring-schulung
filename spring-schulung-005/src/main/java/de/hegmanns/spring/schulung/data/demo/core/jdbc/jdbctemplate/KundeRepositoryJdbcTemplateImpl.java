package de.hegmanns.spring.schulung.data.demo.core.jdbc.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import de.hegmanns.spring.schulung.data.demo.core.Kunde;
import de.hegmanns.spring.schulung.data.demo.core.KundeRepository;

@Repository
public class KundeRepositoryJdbcTemplateImpl implements KundeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Kunde getKundeById(long id) {
		String query = "select * from kunde where id = ?";
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Kunde kunde = null;
//		Kunde kunde = jdbcTemplate.queryForObject(query,
//				new Object[] { id }, new RowMapper<Kunde>() {
//					@Override
//					public Kunde mapRow(ResultSet rs, int rowNum)
//							throws SQLException {
//						Kunde kunde = new Kunde();
//						kunde.setId(rs.getLong("id"));
//						kunde.setVorname(rs.getString("vorname"));
//						kunde.setNachname(rs.getString("nachname"));
//						
//						return kunde;
//					}
//				});
		return kunde;
	}

	@Override
	public void addKunde(Kunde kunde) {
		String inserQuery = "insert into kunde (id, vorname, nachname) values (?, ?, ?) ";
		Object[] params = new Object[] { kunde.getId(),
				kunde.getVorname(), kunde.getNachname() };
		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.INTEGER };
		jdbcTemplate.update(inserQuery, params, types);
	}

	@Override
	public void createDatabase() {
		jdbcTemplate.execute("create table kunde (id integer, vorname char(30), nachname char(30))");
	}

}
