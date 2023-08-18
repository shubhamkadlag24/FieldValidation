package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public String save(User user) {
		
		//variable for every field in entity class
		String username=user.getName();
		String password=user.getPassword();
		String mobileNo=user.getPhoneNo();
		String city =user.getCity();
		String mail=user.getEmail();
		int pincode= user.getPincode();
		String pinCode=String.valueOf(pincode);
		
		//declared counter
		int count=0;
		int passwordCap=0;
		int passwordSmall=0;
		int passwordSpecial=0;
		int passwordNum=0;
		int cityCnt=0;
		int mobileCnt=0;
		int pincodeCnt=0;
		int emailCnt1=0;
		int emailCnt2=0;
		
		//Logic for Validation of Name Field
		for(int i=0;i<username.length();i++) {
			if((username.charAt(i)>='a' && username.charAt(i)<='z') || (username.charAt(i)>='A' && username.charAt(i)<='Z')) {
				count++;
			}
		}
		
		//Logic for Validation of City Field
		for(int i=0;i<city.length();i++) {
			if((city.charAt(i)>='a' && city.charAt(i)<='z') || (city.charAt(i)>='A' && city.charAt(i)<='Z')) {
				cityCnt++;
			}
		}
		
		//Logic for Validation of  mobile number field
		for(int i=0;i<mobileNo.length();i++) {
			if(mobileNo.charAt(i)>='0' && mobileNo.charAt(i)<='9') {
				mobileCnt++;
			}
		}
		//Logic for Validation of pincode Field
		for(int i=0;i<pinCode.length();i++) {
			if(pinCode.charAt(i)>='0' && pinCode.charAt(i)<='9') {
				pincodeCnt++;
			}
		}
		
		//Logic for Validation of password Field
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i)>='A' && password.charAt(i)<='Z') {
				passwordCap++;
				
			}
			else if(password.charAt(i)>='a' && password.charAt(i)<='z') {
				passwordSmall++;
			
			}
			else if(password.charAt(i)>='0' && password.charAt(i)<='9') {
				 passwordNum++;
			}
			else {
				passwordSpecial++;
			}
				
		}
		
		//Logic for Validation of Email Field
		for(int i=0;i<mail.length();i++) {
			if(mail.charAt(i)=='@')
				emailCnt1++;
			if(mail.charAt(i)=='.') {
				emailCnt2++;
			}
				
			
		}
		//condition for name field
		if(count!=username.length() ) {
		  
		  return "Enter only Alphabate in name feild";
		
		}

		if(count>=10) {
			return "Enter less than 10 characters in Name";
		}
		
		//condition for password field
		if(passwordCap==0 || passwordSmall==0 ||passwordNum==0|| passwordSpecial==0 || password.length()<8) {
			return "Please enter one uppercase , one lowercase letter and special symbol and enter 8 digit ";
		}
		
		//		//condition for email field
		if(emailCnt1!=1 || emailCnt2!=1) {
			return "Email should contain only one @ sign and one fullstop";
		}
		
		//condition for city field
		if(cityCnt != city.length()) {
			return "Enter only Alphabate in City do not enter Numric value or special charactor";
		}
		
		//		//condition for city field
		if(pincodeCnt != 6 || pinCode.length()<6) {
			return "Enter only 6 digit and do not enter Alphabate";
		}
		
		//condition for mobile field
		if(mobileCnt != mobileNo.length() || mobileNo.length() != 10) {
			return "Enter 10 Digit valid Mobile Number";
			
		}
	
		userRepo.save(user);
		return "Save Successfully";
				
	}


	}
	

