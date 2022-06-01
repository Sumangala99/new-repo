package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.LaborotaryReport;
import com.example.service.LaborotaryReportService;

@RestController
public class Laborotaryontroller {
	
	@Autowired
	LaborotaryReportService pathSer;
	
	@GetMapping("/LaborotaryById/{eid}")
	public LaborotaryReport findLaborotaryById(@PathVariable(name="eid")int id)
	{
		return pathSer.findLaborotaryById(id);
	}
	
	@GetMapping("/LaborotaryReportPatientName/{pname}")
	public LaborotaryReport findLaborotaryByPatientName(@PathVariable(name="pname")String name)
	{
		return pathSer.findReportByPatientName(name);
	}
	
	
	@GetMapping("/LaborotaryReportDoctorName/{dname}")
	public LaborotaryReport findLaborotaryByDoctorName(@PathVariable(name="dname")String name)
	{
		return pathSer.findReportByDoctorName(name);
	}
	
	@PostMapping("/addLaborotary")
	public LaborotaryReport addPathology(@RequestBody LaborotaryReport laborotary)
	{
		return pathSer.addLaborotary(laborotary);
		
	}
	
	
	@GetMapping("/getAllLaborotary")
	public List<LaborotaryReport> listAllLaborotary()
	{
		return pathSer.getAllLaborotary();
	}
	@PutMapping("/updatLaborotary/{id}")
	public LaborotaryReport updateLaborotary(@PathVariable(name="id")int id,@RequestBody LaborotaryReport Laborotary)
	{
		
		LaborotaryReport lab1=this.pathSer.findLaborotaryById(id);
		if(lab1!=null) {
		return this.pathSer.addLaborotary(Laborotary);
		}
		return null;

	}
	
	
	
	
	@DeleteMapping("/deleteLaborotary/{eid}")
	public boolean deletePathology(@PathVariable(name="eid")int id)
	{
		return this.pathSer.deleteLaborotary(id);
	}
	
	
	

}
