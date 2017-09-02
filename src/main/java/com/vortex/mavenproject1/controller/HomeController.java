/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.controller;

import com.vortex.mavenproject1.dao.ProfileUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sumanheuju
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    private ProfileUserDAO profileUserDAO;
    
    @RequestMapping(method = RequestMethod.GET )
    public String index(Model model){
      model.addAttribute("profileUsers", profileUserDAO.getAll());
      return "index";
    }
}
