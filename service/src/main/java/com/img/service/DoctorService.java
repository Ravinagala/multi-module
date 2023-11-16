package com.img.service;

import com.img.entity.Doctor;
import com.img.repo.DoctorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostConstruct
    public void initDoctor(){
        doctorRepository.saveAll(Stream.of(new Doctor(1,"Ravi","Cardioligist"),
                new Doctor(2,"Praveen","ENT")).collect(Collectors.toList()));
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }
}
