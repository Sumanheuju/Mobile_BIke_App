/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.controller;

import com.vortex.mavenproject1.dao.ProfileUserDAO;
import com.vortex.mavenproject1.entity.ProfileUser;
import java.io.File;
import java.util.List;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author sumanheuju
 */
@RestController
@RequestMapping(value = "/api/")
public class CRUDRestController {

    
    @Autowired
    private ProfileUserDAO profileUserDAO;
    
    public CRUDRestController() {
    }
    
    
    @CrossOrigin
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity<List<ProfileUser>> listAllProfileUsers(){
        List<ProfileUser> profileUsers = profileUserDAO.getAll();
        if(profileUsers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(profileUsers, HttpStatus.OK);
    }
    
    @CrossOrigin
    @RequestMapping(value = "profileUser/new", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> addProfileUser(@RequestParam("name") String name,
                            @RequestParam("address") String address,
                            @RequestParam("contactNo") String contactNo,
                            @RequestParam("licenseNo") String licenseNo,
                            @RequestParam("bloodGroup") String bloodGroup,
                            @RequestParam("vehicleNo") String vehicleNo,
                            @RequestParam("email") String email,
                            @RequestParam("profilePicture") MultipartFile multipartFile,
                            UriComponentsBuilder ucb){
        
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpSession session = req.getSession();
        String rootDirectory = "/Users/sumanheuju/NetBeansProjects/mavenproject1/MavenHibernate/src/main/webapp/";
        
            ProfileUser profileUser = new ProfileUser();
            profileUser.setName(name);
            profileUser.setAddress(address);
            profileUser.setContactNo(contactNo);
            profileUser.setLicenseNo(licenseNo);
            profileUser.setBloodGroup(bloodGroup);
            profileUser.setVehicleNo(vehicleNo);
            profileUser.setEmail(email);
            
           // profileUser = saveOrUpdateImage(multipartFile, profileUser, rootDirectory);
            
            profileUserDAO.insert(profileUser);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucb.path("profileUser/{id}").buildAndExpand(profileUser.getProfileUserId()).toUri());
            return new ResponseEntity<>(HttpStatus.CREATED);
        
    }
    
    @CrossOrigin
    @RequestMapping(value = "profileUser/{profile_user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileUser> getProfileUser(@PathVariable("profile_user_id") int id){
        
        ProfileUser profileUser = profileUserDAO.getById(id);
        if(profileUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(profileUser, HttpStatus.OK);
        
    }
    
    @CrossOrigin
    @RequestMapping(value = "profileUser/edit/{profile_user_id}", method = RequestMethod.POST)
    public ResponseEntity<ProfileUser> updateProfileUser(@PathVariable("profile_user_id") int id,
            @RequestBody ProfileUser profileUser){
        
        profileUser.setProfileUserId(id);
        
        //For Image Upload
        MultipartFile profilePicture = profileUser. getProfilePicture();
        
        String rootDirectory = "/Users/sumanheuju/NetBeansProjects/mavenproject1/MavenHibernate/src/main/webapp/";
        String finalPath = rootDirectory + "resources/superapp1/www/img/profilePics/";
        File userImageDir = new File(finalPath);
        
        String newFileName = String.valueOf(profileUser.getProfileUserId()); 
        
        File profilePicFile = new File(userImageDir, "/" + newFileName + ".jpg");
        try{
            profilePicture.transferTo(profilePicFile);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Product image saving failed", ex);
        }
        
        //Ends Image Upload
        
        profileUserDAO.update(profileUser);
        return new ResponseEntity<>(profileUser, HttpStatus.OK);
    }
    
    @RequestMapping(value = "profileUser/delete/{profile_user_id}", method = RequestMethod.DELETE)
    public ResponseEntity<ProfileUser> deleteProfileUser(@PathVariable("profile_user_id") int id){
        ProfileUser profileUser = profileUserDAO.getById(id);
        
        if(profileUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        profileUserDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
//    @CrossOrigin
//    private ProfileUser saveOrUpdateImage(MultipartFile multipartFile, ProfileUser pu, String rootDirectory) {
//        try {
//            String finalPath = rootDirectory + "resources/superapp1/www/img/profilePics/";
//            // File Directory for the Images
//            File userImageDir = new File(finalPath);
//
//            if (!userImageDir.exists()) {
//                userImageDir.mkdir();
//            }
//            String newFileName = String.valueOf(pu.getName() + "_" +pu.getLicenseNo());
//            File profilePic = new File(userImageDir, "/" + newFileName + ".jpg");
//            
//            
//            profilePic.createNewFile();
//            multipartFile.transferTo(profilePic);
//            pu.setProfilePicture(newFileName);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return pu;
//    }
}
