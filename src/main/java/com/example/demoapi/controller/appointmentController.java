//package com.example.demoapi.controller;
//
//import com.example.demoapi.model.appointment;
//import com.example.demoapi.repository.appointmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/appointment")
//public class appointmentController {
//
//    @Autowired
//    appointmentRepository appointmentRepository;
//
//    @GetMapping("/")
//    public List<appointment> getAllAppointment(){
//        return  appointmentRepository.findAll();
//    }
//
//
//}
