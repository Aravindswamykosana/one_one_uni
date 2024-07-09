package one_one_uni.Controller;

import java.util.Scanner;

import one_one_uni.dao.CountryCrud;
import one_one_uni.dao.PrimeCrud;
import one_one_uni.dto.Country;
import one_one_uni.dto.PrimeMinister;

public class DynamicCountry {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CountryCrud crud=new CountryCrud();
		PrimeCrud crudm=new PrimeCrud();
		boolean bo=true;
		do {
			System.out.println("1:Country\n2:primeminister\n3:exit");
			System.out.println("choose the option");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				boolean b=true;
				do {
					System.out.println("welcome to Country Page");
					System.out.println("1:insert\n2:upadte\n3:delete\n4:fetch\n5:fetchAll\n6:fetchAll Country BY Name\n7:saveCountry with minister\n8:exit");
					System.out.println("choose the option");
					int opt=sc.nextInt();
					switch(opt) {
					case 1:
						System.out.println("enter the name:");
						String name=sc.next();
						System.out.println("enter the population");
						long people=sc.nextLong();
						System.out.println("enter the national bird:");
						String bird=sc.next();
						System.out.println("enter the national animal:");
						String animal=sc.next();
						Country country=new Country(name,people,bird,animal);
						crud.saveCountry(country);
						break;
					case 2:
						System.out.println("enter the population");
						long people1=sc.nextLong();
						
						System.out.println("enter the id");
						int id2=sc.nextInt();
						crud.updateCountry(id2,people1);
						break;
					case 3:
						System.out.println("enter the id:");
						int id=sc.nextInt();
						crud.deleteCountry(id);
						System.out.println("deleted success");
						break;
					case 4:
						System.out.println("enter the id:");
						int id1=sc.nextInt();
						crud.fetchCountry(id1);
						break;
					case 5:
						crud.fetchAll();
						break;
					case 6:
						System.out.println("enter the name:");
						String name1=sc.next();
						System.out.println(crud.fetchCountryByMinisterName(name1));
						break;
					case 7:
						break;
					case 8:
						b=false;
						System.out.println("TNX FOR USING....!");
						break;
						default:
							System.out.println("choose the correct option");
						
					}
				}while(b);
				break;
			case 2:
				boolean bool=true;
				do {
					System.out.println("welcome to PrimeMinister Page");
					System.out.println("1:insert\n2:update\n3:delete\n4:fetch\n5:fetchAll\n6:fetchMinister Based on Country\n7:exit");
					System.out.println("enter the option:");
					int opti=sc.nextInt();
					switch(opti) {
					case 1:
						System.out.println("enter the age");
						int age=sc.nextInt();
						System.out.println("enter the gender:");
						String gen=sc.next();
						System.out.println("enter the name:");
						String name=sc.next();
						System.out.println("enter the partyname:");
						String party=sc.next();
						System.out.println("enter the country id:");
						int id=sc.nextInt();
						PrimeMinister pm=new PrimeMinister(name,age,gen,party);
						crudm.savePrime(id, pm);
						break;
					case 2:
						System.out.println("enter the age");
						int age1=sc.nextInt();
						System.out.println("enter the id:");
						int id1=sc.nextInt();
						crudm.updatePrime(id1, age1);
						break;
					case 3:
						System.out.println("enter the id:");
						int id2=sc.nextInt();
						crudm.deletePrime(id2);
						break;
					case 4:
						System.out.println("enter the id:");
						int id3=sc.nextInt();
						crudm.fetchPrime(id3);
						break;
					case 5:
						crudm.fetchAll();
						break;
					case 6:
						System.out.println("enter the name:");
						String nam=sc.next();
						System.out.println(crudm.fetchMinisterByCountryName(nam));
						break;
					case 7:
						bool=false;
						System.out.println("TNX FOR USING....!");
						break;
						
					}
				}while(bool);
				break;
			case 3:
				bo=false;
				System.out.println("TNX FOR USING....!");
				break;
			default:
				System.out.println("choose the correct option");
			}
		}while(bo);
	}
}
