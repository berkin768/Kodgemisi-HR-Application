package kodgemisi.hr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer jobApplicationId;
	
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
	@JoinColumn(name = "jobId")
	private Job job;
	
	public Integer getJobApplicationId() {
		return jobApplicationId;
	}

	public void setJobApplicationId(Integer jobApplicationId) {
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}
