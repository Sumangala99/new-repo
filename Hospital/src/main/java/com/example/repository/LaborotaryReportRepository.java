package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.bean.LaborotaryReport;




public interface LaborotaryReportRepository extends JpaRepository<LaborotaryReport, Integer> {
	LaborotaryReport findBypatientName(String name);
	LaborotaryReport findBydoctorName(String name);

}
