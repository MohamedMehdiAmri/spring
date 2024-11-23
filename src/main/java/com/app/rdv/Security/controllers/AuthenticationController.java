package com.app.rdv.Security.controllers;


import com.app.rdv.Security.entity.AppRole;
import com.app.rdv.Security.entity.AppUser;
import com.app.rdv.Security.services.IServiceAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private IServiceAuthentication serviceAuthentication;

    @PostMapping("/users")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return serviceAuthentication.createAppUser(appUser);
    }

    @PostMapping("/roles")
    public AppRole createRole(@RequestBody AppRole appRole) {
        return serviceAuthentication.createAppRole(appRole);
    }

    @PostMapping("/users/roles")
    public void addRoleToUser(@RequestParam String username, @RequestParam String role) {
        serviceAuthentication.addRoleToUser(username, role);
    }
}