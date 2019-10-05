package com.revature.GradingApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.grading.dao.RegisterDao;
import com.revature.grading.model.Admindetails;
@RestController
public class AdminController {
	@GetMapping("login")
	 public static String login(@RequestParam("name") String name, @RequestParam("password") String password){
         
	        String errorMessage = null;
	        
	        RegisterDao dao =new RegisterDao();
	        Admindetails detail  = null;
	        try {
	        	detail=dao.ad1login(name,password);
	        	
	        } catch (Exception e) {
	            //e.printStackTrace();
	            errorMessage = e.getMessage();
	        }       
	         
	        // Prepare JSON Object
	        String json = null;
	        Gson gson = new Gson();
	        if( detail != null || errorMessage == null) {
	             json = gson.toJson(detail);
	        }
	        else {
	        	errorMessage = "Invalid Username and password";
	            JsonObject obj = new JsonObject();
	            obj.addProperty("errorMessage", errorMessage);
	            json = obj.toString();
	        }
	         
	         
	        return json;
	         
	    }

}
