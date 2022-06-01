package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.DoctorAdd;
import com.example.bean.Patient;
import com.example.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository repo;





	public List<Patient> listAll() {
	return this.repo.findAll();
	}



	public Patient addPatient(Patient patient) {
	return repo.save(patient);
	}
	
	
	public Patient findPatient(int id) 
	{
	Optional<Patient> optional=this.repo.findById(id);
	if(optional.isPresent())
	 return optional.get();
	else
	   return null;
	}
	
	public Patient findPatientByName(String firstname) 
	{
		Patient patient=this.repo.findByfirstname(firstname);
		return patient;
	}
	

	public boolean delete(int id)
	{
		this.repo.deleteById(id);
		return true;
	}



	

}
