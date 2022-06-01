package com.example.bean;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laborotary")
public class LaborotaryReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String patientName;
	private String doctorName;
	private long patientPhone;
	private String testName; 
	private double testPrice;
	
	private String testResult;
	private LocalDate date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public long getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(long patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public double getTestPrice() {
		return testPrice;
	}
	public void setTestPrice(double testPrice) {
		this.testPrice = testPrice;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "LaborotaryReport [id=" + id + ", patientName=" + patientName + ", doctorName=" + doctorName
				+ ", patientPhone=" + patientPhone + ", testName=" + testName + ", testPrice=" + testPrice
				+ ", testResult=" + testResult + ", date=" + date + "]";
	}
	public LaborotaryReport(int id, String patientName, String doctorName, long patientPhone, String testName,
			double testPrice, String testResult, LocalDate date) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.patientPhone = patientPhone;
		this.testName = testName;
		this.testPrice = testPrice;
		this.testResult = testResult;
		this.date = date;
	}
	public LaborotaryReport() {
		super();
	}
	
	
	
	
	
	
	
	

}
