package reboot.model;


import javax.persistence.*;

@Entity
public class Guest {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String gender;
	private Long age;
	
	private String occupation;
	private String description;
	private String hobbies;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Long getAge() {
		return age;
	}
	
	public void setAge(Long age) {
		this.age = age;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getHobbies() {
		return hobbies;
	}
	
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
}