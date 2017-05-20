package kodgemisi.hr.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class JobApplication {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobApplicationId;
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String phone;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String thoughts;
	
	@ManyToOne
	private Job job;
	
	public JobApplication(String name, String email, String phone, String address, String thoughts){
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.thoughts = thoughts;
	}

	public int getJobApplicationId() {
		return jobApplicationId;
	}

	public void setJobApplicationId(int jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}
}
