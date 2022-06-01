package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bean.DoctorAdd;

public interface DoctorAddRepository extends JpaRepository<DoctorAdd, Integer>{
	DoctorAdd findByName(String name);

}