package org.example.onlineshop.Service;

import lombok.AllArgsConstructor;
import org.example.onlineshop.Entity.Employee;
import org.example.onlineshop.Repository.EmployeeR;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    EmployeeR  employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findEmployeeByUsername(username);
        if (employee == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        System.out.println(employee.getRole().getName());
        List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority(employee.getRole().getName()));
        return new User(employee.getUsername(), employee.getPassword(), grantedAuthorities);
    }
}
