package com.sous.health.pharmacie.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sous.health.pharmacie.entities.RefreshToken;
import com.sous.health.pharmacie.entities.Role;
import com.sous.health.pharmacie.entities.URole;
import com.sous.health.pharmacie.entities.User;
import com.sous.health.pharmacie.payload.request.LoginRequest;
import com.sous.health.pharmacie.payload.request.SignupRequest;
import com.sous.health.pharmacie.payload.request.TokenRefreshRequest;
import com.sous.health.pharmacie.payload.response.JwtResponse;
import com.sous.health.pharmacie.payload.response.MessageResponse;
import com.sous.health.pharmacie.repository.RoleRepository;
import com.sous.health.pharmacie.repository.UserRepository;
import com.sous.health.pharmacie.security.jwt.JwtUtils;
import com.sous.health.pharmacie.security.services.UserDetailsImpl;
import com.sous.health.pharmacie.services.RefreshTokenService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  RoleRepository roleRepository;
  
  @Autowired
  PasswordEncoder encoder;
  
  @Autowired
  RefreshTokenService refreshTokenService;

 
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    String jwt = jwtUtils.generateJwtToken((Authentication) userDetails);

    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
        .collect(Collectors.toList());

    RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

    return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
        userDetails.getUsername(), roles));
  }
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByPassword(signUpRequest.getPassword())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Password is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(URole.ROLE_VISITOR)
					.orElseThrow(() -> new RuntimeException("Error0: Role is not found."));
			roles.add(userRole);
//			System.out.println("visitor");
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(URole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error saving admin : Role is not found."));
					roles.add(adminRole);
					user.setRoles(roles);
					userRepository.save(user);
//					System.out.println("admin");
					break;
				case "client":
					Role modRole = roleRepository.findByName(URole.ROLE_CLIENT)
							.orElseThrow(() -> new RuntimeException("Error saving client : Role is not found."));
					roles.add(modRole);
					user.setRoles(roles);
					userRepository.save(user);
//					System.out.println("client");
					break;
				default:
					Role userRole = roleRepository.findByName(URole.ROLE_VISITOR)
							.orElseThrow(() -> new RuntimeException("Error saving visitor : Role is not found."));
					roles.add(userRole);
					user.setRoles(roles);
					userRepository.save(user);
				}
			});
		}

		//user.setRoles(roles);
		//userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}