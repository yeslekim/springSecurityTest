package com.kys.securityTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kys.securityTest.model.dto.UserDTO;
import com.kys.securityTest.model.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/user")
@Log4j2
public class UserController {

	private final UserService userService;
	 
    @GetMapping(value = "/loginView")
    public String loginView(){
        return "user/login";
    }
    
    @GetMapping(value = "/init")
    public String createAdmin(@ModelAttribute UserDTO userDTO){
//        userDTO.setUserEmail("2");
//        userDTO.setRole(UserRole.USER);
//        if(userService.createUser(userDTO) == null){
//            log.error("Create Admin Error");
//        }
//
//        userDTO.setUserEmail("1");
//        userDTO.setRole(UserRole.ADMIN);
//        if(userService.createUser(userDTO) == null){
//            log.error("Create Admin Error");
//        }
        return "redirect:/index";
    }
    
    @PostMapping(value = "/logout")
    public String logout(){
    	return "redirect:/index";
    }
}
