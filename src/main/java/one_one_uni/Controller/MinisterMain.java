package one_one_uni.Controller;

import java.util.Scanner;

import javax.persistence.Persistence;

import one_one_uni.dao.CountryCrud;
import one_one_uni.dao.PrimeCrud;
import one_one_uni.dto.Country;
import one_one_uni.dto.PrimeMinister;

public class MinisterMain {
	public static void main(String[] args) {
		CountryCrud crud=new CountryCrud();
		PrimeCrud crudm=new PrimeCrud();
		//crud.saveCountry(new Country("INDIA",1400000L,"PEACOCK","BENGALTIGER"));
		//crudm.savePrime(1, new PrimeMinister("MODIJI",70,"MALE","BJP"));
		
//		Country c=new Country();
//		c.setPopulation(2056000L);
//		c.setId(1);
//		crud.updateCountry(c);
//		
//		PrimeMinister m=new PrimeMinister();
//		m.setAge(70);
//		m.setId(1);
//		crudm.updatePrime(m);
		
		//crudm.deletePrime(1);//java.sql.SQLIntegrityConstraintViolationException
//		Country c=new Country("INDIA",1400000L,"PEACOCK","BENGALTIGER");
//		PrimeMinister m=new PrimeMinister("MODIJI",70,"MALE","BJP");
//		c.setMinister(m);
//		crud.saveCountryPrimeMinister(c);
		
		crud.fetchAll();
	}
}
