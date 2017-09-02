/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.dao;

import com.vortex.mavenproject1.entity.ProfileMotor;
import java.util.List;

/**
 *
 * @author sumanheuju
 */
public interface ProfileMotorDAO {
    List<ProfileMotor> getAll();
    void insert(ProfileMotor pm);
    void update(ProfileMotor pm);
    void delete(int id);
    ProfileMotor getById(int id);
}
