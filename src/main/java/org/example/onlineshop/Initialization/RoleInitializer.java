package org.example.onlineshop.Initialization;

import org.example.onlineshop.Entity.Role;
import org.example.onlineshop.Repository.RoleR;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import org.example.onlineshop.Enum.RoleName;

@Component
public class RoleInitializer implements CommandLineRunner {

    private final RoleR roleRepository;
    private final List<String> initialRolls = Arrays.stream(RoleName.values()).map(RoleName::name).toList();

    public RoleInitializer(RoleR roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        for (String roleName : initialRolls) {
            boolean exists = roleRepository.existsByName(roleName);
            if(!exists) {
                roleRepository.save(new Role(roleName));
            }
        }
    }
}
