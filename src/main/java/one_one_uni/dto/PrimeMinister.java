package one_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrimeMinister {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String gender;
	private String partyName;
	public PrimeMinister(String name, int age, String gender, String partyName) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.partyName = partyName;
	}
	@Override
	public String toString() {
		return "\nPrimeMinister [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", partyName="
				+ partyName + "]";
	}
	
	
}
