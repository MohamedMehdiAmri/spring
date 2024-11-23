package com.app.rdv.Security.services;

import com.app.rdv.Security.entity.AppRole;
import com.app.rdv.Security.entity.AppUser;
import com.app.rdv.Security.repositories.AppRoleRepository;
import com.app.rdv.Security.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAuthentication implements  IServiceAuthentication{
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public AppUser createAppUser(AppUser appUser) {

        AppUser appUser1 = appUserRepository.findByUsername((appUser.getUsername()));
        if (appUser1==null){
            appUser.setPassword((passwordEncoder.encode(appUser.getPassword())));
            return  appUserRepository.save(appUser);
        }
        else
            return null;
    }
    @Override
    public AppRole createAppRole(AppRole appRole) {
        AppRole appRole1 = appRoleRepository.findByRole((appRole.getRole()));
        if(appRole1==null){
            return appRoleRepository.save(appRole);
        }else{
            return  null;
        }
    }
    @Override
    public void addRoleToUser(String username, String role) {
        AppUser user = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRole(role);
        user.getRoles().add(appRole);
        appUserRepository.save(user);
    }
    @Override
    public AppUser loadUserByUsername(String username) {
        return
                appUserRepository.findByUsername(username);
    }
}
