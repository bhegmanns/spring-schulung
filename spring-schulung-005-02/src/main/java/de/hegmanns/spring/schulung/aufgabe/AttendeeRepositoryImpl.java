package de.hegmanns.spring.schulung.aufgabe;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.hegmanns.spring.schulung.aufgabe.entity.Attendee;
import de.hegmanns.spring.schulung.aufgabe.entity.CountryGroup;

@Transactional
@Repository
public class AttendeeRepositoryImpl implements AttendeeRepository {

	private SessionFactory sessionFactory;
	
	@Override
	public void add(Attendee attendee) {
		sessionFactory.getCurrentSession().saveOrUpdate(attendee);
	}

	@Transactional(readOnly=true)
	@Override
	public Attendee getByNameAndPassword(String name, String password) {
		return (Attendee)sessionFactory.getCurrentSession().createQuery("from Attendee a where a.username=:name and a.password=:password").setParameter("name", name).setParameter("password", password).uniqueResult();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Attendee> getByCountry(String countryName) {
		return sessionFactory.getCurrentSession().createQuery("from Attendee a where a.countryGroup.name = :countryName").setParameter("countryName", countryName).list();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Attendee> getByCountry(CountryGroup countryGroup) {
		return sessionFactory.getCurrentSession().createQuery("from Attendee a where a.countryGroup = :countryGroup").setParameter("countryGroup", countryGroup).list();
	}

	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
