package com.example.demo.ControllerPackage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class InmemoryController {
	
	@GetMapping("/normal")
	public ResponseEntity<String> normal(){
		
		return ResponseEntity.ok("i am normal user");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> admin(){
		
		return ResponseEntity.ok("i am admin user");
	}
	
	@GetMapping("/employee")
	public ResponseEntity<String> employee(){
		
		return ResponseEntity.ok("i am employee user");
	}

}
