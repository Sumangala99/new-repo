package com.example.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bean.Admin;
import com.example.bean.Contact;
import com.example.bean.DoctorAdd;
import com.example.bean.LaborotaryReport;
import com.example.bean.Patient;
import com.example.bean.PatientAppointment;


import com.example.service.DoctorAddService;
import com.example.service.LaborotaryReportService;
import com.example.service.PatientAppointmentService;
import com.example.service.PatientService;


@RestController
@RequestMapping("/api")
public class AdminController {
	
	
	
	
	@Autowired
	private DoctorAddService doctSer;
	@Autowired
	private PatientService patSer;
	
	@Autowired
	private LaborotaryReportService pathSer;
	
	@Autowired
	private PatientAppointmentService appSer;
	
	
	
	
	
	
	
	//Doctor Section
	@GetMapping("/findDoctorById/{eid}")
	public DoctorAdd findById(@PathVariable(name="eid")int id)
	{
		return doctSer.findDoctorById(id);
	}
	@GetMapping("/findDoctorByname/{name}")
	public DoctorAdd findDoctorByName(@PathVariable(name="name")String name)
	{
		return doctSer.findDoctorByName(name);
	}
	
	
	
	@PostMapping(value="/addDoctor")
	public DoctorAdd addDoctor(@RequestBody DoctorAdd doctor)
	{
		return doctSer.addDoctor(doctor);
		
	}
	
	
	@GetMapping("/getAllDoctor")
	public List<DoctorAdd> listAllDoctor()
	{
		return doctSer.getAllDoctors();
	}
	
	
	
	@PutMapping("/updatDoctor/{id}")
	public DoctorAdd updateDoctor(@PathVariable(name="id")int id,@RequestBody DoctorAdd doctor)
	{
		
		DoctorAdd doctor1=this.doctSer.findDoctorById(id);
		if(doctor1!=null) {
		return this.doctSer.addDoctor(doctor);
		}
		return null;

	}
	
	@DeleteMapping("/deleteDoctor/{eid}")
	public boolean deleteDoctor(@PathVariable(name="eid")int id)
	{
		return this.doctSer.delete(id);
	}
	
	//Laborotary
	
	@GetMapping("/getAllLaborotary")
	public List<LaborotaryReport> listAllLaborotary()
	{
		return pathSer.getAllLaborotary();
	}
	
	@GetMapping("/LaborotaryById/{eid}")
	public LaborotaryReport findLaborotaryById(@PathVariable(name="eid")int id)
	{
		return pathSer.findLaborotaryById(id);
	}
	
	@GetMapping("/LaborotaryReportPatientNmae/{pname}")
	public LaborotaryReport findLaborotaryByPatientName(@PathVariable(name="pname")String name)
	{
		return pathSer.findReportByPatientName(name);
	}

	//PatientAppointment

	@PostMapping(value="/addAppointment")
	public PatientAppointment addAppointment(@RequestBody PatientAppointment doctor)
	{
		return appSer.addAppointment(doctor);
		
	}
	@DeleteMapping("/deleteAppointment/{eid}")
	public boolean deleteAppointment(@PathVariable(name="eid")int id)
	{
		return this.appSer.deleteAppointment(id);
	}

	
	@GetMapping("/appointmentById/{eid}")
	public PatientAppointment findAppointmentById(@PathVariable(name="eid")int id)
	{
		return appSer.findAppointmentById(id);
	}
	

	@GetMapping("/getAllAppointment")
	public List<PatientAppointment> listAllAppointment()
	{
		return appSer.getAllAppointment();
	}
	@PutMapping("/updateAppointment/{id}")
	public PatientAppointment updateAppointment(@PathVariable(name="id")int id,@RequestBody PatientAppointment appointment)
	{
		
		PatientAppointment appointment1=this.appSer.findAppointmentById(id);
		if( appointment1!=null) {
		return this.appSer.addAppointment(appointment);
		}
		return null;

	}
	
	//Patient 
	
	@PostMapping("admin/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
	return this.patSer.addPatient(patient);
	}
	@GetMapping("/amdin/getAllPatients")
	public List<Patient> getAllPatient(){
	return this.patSer.listAll();
	}
	
	
    @GetMapping("/admin/getPatientById/{id}")
	public Patient getPatientById(@PathVariable (name="id") int id) 
	{
	   return this.patSer.findPatient(id);
	}
    @DeleteMapping("/admin/deletePatient/{eid}")
	public boolean deletePatient(@PathVariable(name="eid")int id)
	{
		return this.patSer.delete(id);
	}
    
    @PutMapping("/admin/updatPatent/{id}")
	public Patient updatePatient(@PathVariable(name="id")int id,@RequestBody Patient patient)
	{
		
		Patient patient1=this.patSer.findPatient(id);
		if( patient1!=null) {
		return this.patSer.addPatient(patient);
		}
		return null;

	}
    
	
	
	
	
	
	
	
	
}
