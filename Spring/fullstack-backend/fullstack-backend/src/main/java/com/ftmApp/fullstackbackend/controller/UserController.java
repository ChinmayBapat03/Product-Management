package com.ftmApp.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ftmApp.fullstackbackend.exception.UserNotFoundException;
import com.ftmApp.fullstackbackend.model.User;
import com.ftmApp.fullstackbackend.repo.UserRepo;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/create") //path (postmapping is shortcut to @RequestMapping(method = RequestMethod.POST)
	User newUser(@RequestBody User newUser) {
		return userRepo.save(newUser); //requestbody is json body (data converted in json format)
	}
	
	@GetMapping("/users")
	List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/getUser/{productId}")
	User getUserById(@PathVariable Long productId){
		return userRepo.findById(productId).orElseThrow(()->new UserNotFoundException(productId));
	}
	
	@PutMapping("/update/{productId}")
	User updateUser(@RequestBody User newUser, @PathVariable Long productId) {
		return userRepo.findById(productId).map(user -> {
			user.setProductName(newUser.getProductName());
			user.setProductCost(newUser.getProductCost());
			user.setnBreaks(newUser.getnBreaks());
			
			return userRepo.save(user);
		}).orElseThrow(()->new UserNotFoundException(productId));
	}
	
	@DeleteMapping("/delete/{productId}")
	String deleteUser(@PathVariable Long productId) {
		if(!userRepo.existsById(productId)) {
			throw new UserNotFoundException(productId);
		}
		userRepo.deleteById(productId);
		return "User with id " + productId + "has been successfully deleted";
	}
}
