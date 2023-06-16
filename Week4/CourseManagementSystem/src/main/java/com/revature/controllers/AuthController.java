package com.revature.controllers;

import com.revature.daos.PersonDAO;
import com.revature.daos.RoleDAO;
import com.revature.dto.RegisterDTO;
import com.revature.models.Person;
import com.revature.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This controller will be in charge of allowing us to actually register and login different people
@RestController
@RequestMapping("auth")
public class AuthController {

    // We have a couple of imports that we'll add in to make sure everything works correctly
    private final AuthenticationManager authenticationManager;

    private final PersonDAO personDao;

    private final RoleDAO roleDao;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, PersonDAO personDao, RoleDAO roleDao, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.personDao = personDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }


    // Now we need to make a register method that will allow us to sign up with some basic details
    // We might need something like firstName, lastName, username, password.
    // We could set a default role, maybe Student is what we default to
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){

        // Before we can actually register a user, we need to check the database to make sure someone with that username
        // doesn't already exist
        if (personDao.existsByUsername(registerDTO.getUsername())){
            return new ResponseEntity<String>("Username is taken!", HttpStatus.BAD_REQUEST);
            // The statement above checks to see if the username is taken, if it is, it sends that message to the client
            // with a 400 status code
        }

        // Now that we have checked the availability of the username, let's build the user we plan to save
        Person p = new Person();
        p.setFirstName(registerDTO.getFirstName());
        p.setLastName(registerDTO.getLastName());
        p.setUsername(registerDTO.getUsername());
        p.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        // Now that we've done all this, let's set the standard role
        Role role = roleDao.getByName("Student");

        p.setRole(role);

        // We've built the proper person object so let's save it now
        personDao.save(p);

        return new ResponseEntity<>("User successfully registered!", HttpStatus.CREATED);

    }
}
