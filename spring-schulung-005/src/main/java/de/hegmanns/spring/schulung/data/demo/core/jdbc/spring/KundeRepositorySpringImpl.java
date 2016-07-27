package de.hegmanns.spring.schulung.data.demo.core.jdbc.spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.hegmanns.spring.schulung.data.demo.core.Kunde;
import de.hegmanns.spring.schulung.data.demo.core.KundeRepository;
import de.hegmanns.spring.schulung.data.demo.core.jdbc.KundeRepositoryJdbcImpl;

@Repository
public class KundeRepositorySpringImpl extends KundeRepositoryJdbcImpl implements KundeRepository {

	@Autowired
//	@Inject
	private DataSource datasource;

	@Override
	protected Connection getConnection() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	

}
