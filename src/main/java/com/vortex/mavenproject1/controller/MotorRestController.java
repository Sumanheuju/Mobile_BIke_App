/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.controller;

import com.vortex.mavenproject1.dao.ProfileMotorDAO;
import com.vortex.mavenproject1.entity.ProfileMotor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sumanheuju
 */
@RestController
@RequestMapping(value="/motorApi/")
public class MotorRestController {
//    
//    @Autowired
//    private ProfileMotorDAO profileMotorDAO;
//    
//    @CrossOrigin
//    @RequestMapping(value = "getAll", method = RequestMethod.GET)
//    public ResponseEntity<List<ProfileMotor>> listAllProfileMotors(){
//        List<ProfileMotor> profileMotors = profileMotorDAO.getAll();
//        if(profileMotors.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(profileMotors, HttpStatus.OK);
//    }
}
