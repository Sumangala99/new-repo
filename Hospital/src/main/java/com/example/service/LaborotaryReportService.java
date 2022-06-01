package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.LaborotaryReport;
import com.example.repository.LaborotaryReportRepository;

@Service
public class LaborotaryReportService {

	@Autowired
	private LaborotaryReportRepository dao;

	public LaborotaryReport addLaborotary(LaborotaryReport laborotary) {
		return this.dao.save(laborotary);
	}

	public List<LaborotaryReport> getAllLaborotary() {
		return this.dao.findAll();
	}

	public LaborotaryReport findLaborotaryById(int id) {
		Optional<LaborotaryReport> optional = this.dao.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public boolean deleteLaborotary(int id) {
		this.dao.deleteById(id);
		return true;
	}
	public LaborotaryReport findReportByPatientName(String name)
	{
		LaborotaryReport laborotary=this.dao.findBypatientName(name);
		return laborotary;
	}
	
	public LaborotaryReport findReportByDoctorName(String name)
	{
		LaborotaryReport laborotary=this.dao.findBydoctorName(name);
		return laborotary;
	}

}
