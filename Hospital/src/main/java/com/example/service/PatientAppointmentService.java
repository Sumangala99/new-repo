package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.DoctorAdd;
import com.example.bean.PatientAppointment;
import com.example.repository.PatientAppointmentRepository;


@Service
public class PatientAppointmentService {

	@Autowired
	private PatientAppointmentRepository dao;
	
	public PatientAppointment addAppointment(PatientAppointment appointment)
	{
		return this.dao.save(appointment);
	}
	
	public List<PatientAppointment> getAllAppointment()
	{
		return this.dao.findAll();
	}
	
	public PatientAppointment findAppointmentById(int id)
	{
		Optional<PatientAppointment> optional=this.dao.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	
	public boolean deleteAppointment(int id)
	{
		this.dao.deleteById(id);
		return true;
	}
	
}