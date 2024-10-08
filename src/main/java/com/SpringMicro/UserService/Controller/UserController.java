package com.SpringMicro.UserService.Controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMicro.UserService.Model.User;
import com.SpringMicro.UserService.Model.WrapperClass;
import com.SpringMicro.UserService.Service.UserService;

import ch.qos.logback.classic.Logger;



@RestController
@RequestMapping("/user")
public class UserController {
	Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		logger.info("User Create Controller call");
		return userService.createUser(user);
	}
	
	@GetMapping("/get")
	public List<User> getAllUsers(){
		logger.info("User get Controller call");
		return userService.getAllUsers();
	}

	@GetMapping("/get/{userid}")
	public WrapperClass getUserById(@PathVariable("userid") long id) {
		logger.info("User getUserById Controller call");
		return userService.getUserById(id);
	}
	
	
}
