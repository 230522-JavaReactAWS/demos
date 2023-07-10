package com.revature.security;

import com.revature.daos.PersonDAO;
import com.revature.models.Person;
import com.revature.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // How did we find the user in our other services?
    // Pulled in the DAO and used that

    private final PersonDAO personDao;

    @Autowired
    public CustomUserDetailsService(PersonDAO personDao) {
        this.personDao = personDao;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person p = personDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No User Found"));
        // We need to return the user details object
        // Username, Password, Authorities
        return new User(p.getUsername(), p.getPassword(), mapRoleToAuthority(p.getRole()));

    }

    // This is allowing us to map the roles in our database to roles with authorized abilities in our application
    // We need the name of the role for later to help us authorize who is accessing what
    private Collection<GrantedAuthority> mapRoleToAuthority(Role role){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

        return grantedAuthorities;

    }
}
