package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.DoctorAdd;
import com.example.repository.DoctorAddRepository;


@Service
public class DoctorAddService {

	@Autowired
	private DoctorAddRepository dao;
	
	public DoctorAdd addDoctor(DoctorAdd doctor)
	{
		return this.dao.save(doctor);
	}
	
	public List<DoctorAdd> getAllDoctors()
	{
		return this.dao.findAll();
	}
	
	public DoctorAdd findDoctorById(int id)
	{
		Optional<DoctorAdd> optional=this.dao.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	
	
	public boolean delete(int id)
	{
		this.dao.deleteById(id);
		return true;
	}
	public DoctorAdd findDoctorByName(String name)
	{
		DoctorAdd doctor=this.dao.findByName(name);
		return doctor;
	}

	
}