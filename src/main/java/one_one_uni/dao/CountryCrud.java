package one_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_one_uni.dto.Country;
import one_one_uni.dto.PrimeMinister;

public class CountryCrud {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("arvind");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void saveCountry(Country country) {
		et.begin();
		em.persist(country);
		et.commit();
	}
	public void saveCountryPrimeMinister(Country country) {
		et.begin();
		em.persist(country);
		et.commit();
	}
	public void updateCountry(int id,long population) {
		Country db = em.find(Country.class, id);
		if(db!=null) {
			et.begin();
			db.setPopulation(population);
			em.merge(db);
			et.commit();
		}
		else {
			System.out.println("id not found");
		}
	}
	public void fetchCountry(int id) {
		Country db = em.find(Country.class, id);
		if(db!=null) {
			System.out.println(db);
		}
		else {
			System.out.println("not found");
		}
	}
	public void fetchAll(){
		Query query = em.createQuery("select a from Country a");
		List<Country> list = query.getResultList();
		System.out.println(list);
	}
	
	public void deleteCountry(int id){
		Country db = em.find(Country.class, id);
		if(db!=null) {
			et.begin();
			em.remove(db);
			et.commit();
		}
		else {
			System.out.println("delete is not a possible");
		}
	}
		public Country fetchCountryByMinisterName(String name) {
			Query query = em.createQuery("select a from PrimeMinister a where a.name=?1");
			query.setParameter(1, name);
			List<PrimeMinister> res = query.getResultList();
			if(!res.isEmpty()) {
				PrimeMinister con=res.get(0);
				int id = con.getId();
				PrimeMinister respm = em.find(PrimeMinister.class, id);
				Query query1 = em.createQuery("select a from Country a where a.minister=?1");
				query1.setParameter(1, respm);
				List<Country> fres = query1.getResultList();
				Country co=fres.get(0);
				Country c= em.find(Country.class, co.getId());
				return c;			
			}
			return null;
		}
}
