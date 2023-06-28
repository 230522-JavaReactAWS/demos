package com.revature.security;

import com.revature.daos.CourseDAO;
import com.revature.daos.PersonDAO;
import com.revature.models.Person;
import com.revature.services.PersonService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Component
public class JwtGenerator {

    private SecretKey secretKey =  Keys.secretKeyFor(SignatureAlgorithm.HS512); // Setting secret key here for now

    //TODO: inject a PersonService so we can get all user info
    @Autowired
    private PersonService personService;

    // There are 3 things we want to do inside of here

    // Generate a new JWT
    public String generateToken(Authentication authentication){
        // First thing I need to do is get the username
        String username = authentication.getName();
        // Next we need the date which we created the JWT
        Date currentDate = new Date();
        // We'll also need to mark when we want this to expire
        Date expireDate = new Date(currentDate.getTime() + (1000 * 60 * 60 * 24));
        //TODO: We need a Person object to gather Role and Id data
        Person person = personService.findPersonByUsername(username);


        // Now that we have all the pieces to populate our JWT, let's actually build it

        String token = Jwts.builder()
                .setSubject(username)
                //TODO: set user ID and user role in custom claims.
                //TODO: This is how we can send specific data in the JWT payload!
                .claim("Id", person.getId())
                .claim("Role", person.getRole().getName())
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)// We need a secret key which SHOULD NOT be shared, otherwise bad
                .compact();

        return token;
    }

    // Validate an existing JWT
    public boolean validateToken(String token){

        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("JWT token is expired or invalid");
        }

    }

    // Get the username itself from the JWT
    public String getUsernameFromToken(String token){
        // We need to parse the jwt and extract the subject from the token
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
