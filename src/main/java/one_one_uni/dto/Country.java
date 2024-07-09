package one_one_uni.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long population;
	private String nationalBird;
	private String nationalAnimal;
	@OneToOne(cascade = CascadeType.ALL)
	private PrimeMinister minister;
	public Country(String name2, long population2, String nationalBird2, String nationalAnimal2) {
		super();
		this.name = name2;
		this.population = population2;
		this.nationalBird = nationalBird2;
		this.nationalAnimal = nationalAnimal2;
	}
	@Override
	public String toString() {
		return "\nCountry [id=" + id + ", name=" + name + ", population=" + population + ", nationalBird=" + nationalBird
				+ ", nationalAnimal=" + nationalAnimal + ", minister=" + minister + "]";
	}
	
}
