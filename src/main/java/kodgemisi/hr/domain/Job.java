package kodgemisi.hr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer jobId;
	
	@Column(nullable=false)
	private String jobTitle;
	
	@Column(nullable=false)
	private String jobDescription;
	
	@Column(nullable=false)
	private Integer numberOfPersonToHire;
	
	@Column(nullable=false)
	private String lastApplicationDate;
	
	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public Integer getNumberOfPersonToHire() {
		return numberOfPersonToHire;
	}
	public void setNumberOfPersonToHire(Integer numberOfPersonToHire) {
		this.numberOfPersonToHire = numberOfPersonToHire;
	}
	public String getLastApplicationDate() {
		return lastApplicationDate;
	}
	public void setLastApplicationDate(String lastApplicationDate) {
		this.lastApplicationDate = lastApplicationDate;
	}
}
