package de.hegmanns.spring.schulung.aufgabe;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.hegmanns.spring.schulung.aufgabe.entity.CountryGroup;

@Transactional
@Repository
public class CountryGroupRepositoryImpl implements CountryGroupRepository {

	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=true)
	@Override
	public CountryGroup getByCountryName(String countryName) {
		return (CountryGroup)sessionFactory.getCurrentSession().createQuery("from CountryGroup c where c.name = :countryName").setParameter("countryName", countryName).uniqueResult();
	}

	@Override
	public void addCountry(CountryGroup countryGroup) {
		sessionFactory.getCurrentSession().saveOrUpdate(countryGroup);
	}

	@Transactional(readOnly=true)
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
