package com.user.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.app.entity.User;
import com.user.app.repository.UserRepository;
import com.user.app.dto.LoginRequestDTO;
import com.user.app.dto.ResponseDTO;
import com.user.app.dto.UserRequestDTO;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path="/user")
public class UserController {
	
  @Autowired
  private UserRepository userRepository;

  @PostMapping(path="/add")
  public ResponseEntity<ResponseDTO> addNewUser (@RequestBody UserRequestDTO userRequestDTO) {
	  
    User n = new User();
    n.setName(userRequestDTO.getName());
    n.setEmail(userRequestDTO.getEmail());
    n.setPassword(userRequestDTO.getPassword());
    userRepository.save(n);
    ResponseDTO responseDTO = new ResponseDTO("User added", 200);
    return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
  
  @PostMapping("/login")
  public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
	Optional<User> optionalUser = userRepository.findByNameAndPassword(loginRequestDTO.getName(), loginRequestDTO.getPassword());
	ResponseDTO responseDTO = new ResponseDTO("", 0);
	
	if(!optionalUser.isPresent()){
		responseDTO.setMessage("Bad credentials");
		responseDTO.setStatusCode(404);
	}else {
		responseDTO.setMessage("User accepted");
		responseDTO.setStatusCode(200);	
	}	
  	return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);
  }
}