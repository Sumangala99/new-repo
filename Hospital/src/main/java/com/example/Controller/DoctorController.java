package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.DoctorAdd;
import com.example.bean.LaborotaryReport;
import com.example.bean.Patient;
import com.example.bean.PatientAppointment;
import com.example.service.DoctorAddService;
import com.example.service.LaborotaryReportService;
import com.example.service.PatientAppointmentService;
import com.example.service.PatientService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorAddService doctSer;
	
	@Autowired
	private PatientAppointmentService appSer;
	
	@Autowired
	private PatientService patSer;
	
	@Autowired
	LaborotaryReportService labSer;
	
	@GetMapping("/getAllAppointment")
	public List<PatientAppointment> listAllAppointment()
	{
		return appSer.getAllAppointment();
	}
	
	@PutMapping("/updatMySelf/{id}")
	public DoctorAdd updateDoctor(@PathVariable(name="id")int id,@RequestBody DoctorAdd doctor)
	{
		
		DoctorAdd doctor1=this.doctSer.findDoctorById(id);
		if(doctor1!=null) {
		return this.doctSer.addDoctor(doctor);
		}
		return null;

	}
	 @GetMapping("/getPatientByName/{name}")
		public Patient getPatientById(@PathVariable (name="name") String firstname) 
		{
		   return this.patSer.findPatientByName(firstname);
		}
	
	 
	 @GetMapping("/LaborotaryReportPatientName/{pname}")
		public LaborotaryReport findLaborotaryByPatientName(@PathVariable(name="pname")String name)
		{
			return labSer.findReportByPatientName(name);
		}
	
	
	
}
