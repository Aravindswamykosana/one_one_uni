package one_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_one_uni.dto.Country;
import one_one_uni.dto.PrimeMinister;

public class PrimeCrud {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("arvind");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void savePrime(int country_id,PrimeMinister minister) {
		Country db= em.find(Country.class, country_id);
		if(db!=null){
			//1st way
			
//			System.out.println(db);
//			et.begin();
//			PrimeMinister dbm = em.merge(minister);
//			et.commit();
//			
//			db.setMinister(dbm);
//			System.out.println(db);
//			et.begin();
//			em.merge(db);
//			et.commit();
			
			//2nd way
			et.begin();
			PrimeMinister dbm = em.merge(minister);
			db.setMinister(dbm);
			et.commit();
		}
		else {
			System.out.println("country is not found");
		}
	}
	public void updatePrime(int id,int age) {
		PrimeMinister db = em.find(PrimeMinister.class,id);
		if(db!=null) {
			et.begin();
			db.setAge(age);
			em.merge(db);
			et.commit();
		}
		else {
			System.out.println("id not found");
		}
	}
	public void fetchPrime(int id) {
		 PrimeMinister db = em.find(PrimeMinister.class, id);
		if(db!=null) {
			System.out.println(db);
		}
		else {
			System.out.println("not found");
		}
	}
	public void fetchAll() {
		Query query = em.createQuery("select a from PrimeMinister a");
		List<PrimeMinister> list = query.getResultList();
		System.out.println(list);
		
	}
	public void deletePrime(int id) {
		PrimeMinister db = em.find(PrimeMinister.class, id);
		System.out.println(db);
		if(db!=null) {
			Query query = em.createQuery("select a from Country a where a.minister=?1");
			query.setParameter(1,db);
			 List<Country> list = query.getResultList();
			 et.begin();
			for (Country country : list) {
				System.out.println("before updating the country minister with null:"+country);
				country.setMinister(null);
				System.out.println("after updating the country minister with null:"+country);	
			}
			em.remove(db);
			et.commit();
		}
		else {
			System.out.println("delete is not possible");
		}
	}
	public PrimeMinister fetchMinisterByCountryName(String name){
		Query query = em.createQuery("select a from Country a where name=?1");
		query.setParameter(1, name);
		List<Country> li = query.getResultList();
		if(!li.isEmpty()) {
			 Country res = li.get(0);
			 PrimeMinister mi = res.getMinister();
			 int i = mi.getId();
			  PrimeMinister cou = em.find(PrimeMinister.class, i);
			 return cou;
		}
		else
			return null;
	}
}
