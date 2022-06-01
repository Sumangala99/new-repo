package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bean.PatientAppointment;



public interface PatientAppointmentRepository extends JpaRepository<PatientAppointment, Integer>{



}