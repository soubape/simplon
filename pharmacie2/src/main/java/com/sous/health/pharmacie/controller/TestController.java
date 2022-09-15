package com.sous.health.pharmacie.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('VISITOR') or hasRole('ADMIN') or hasRole('CLIENT')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/visitor")
	@PreAuthorize("hasRole('VISITOR')")
	public String moderatorAccess() {
		return "Visitor Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/client")
	@PreAuthorize("hasRole('CLIENT')")
	public String clientAccess() {
		return "Client Board.";
	}
}