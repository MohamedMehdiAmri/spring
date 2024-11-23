package com.app.rdv.Security.services;

import com.app.rdv.Security.entity.AppRole;
import com.app.rdv.Security.entity.AppUser;

public interface IServiceAuthentication {
    public AppUser createAppUser(AppUser appUser);
    public AppRole createAppRole(AppRole appRole);
    public void addRoleToUser(String username, String role);
    public  AppUser loadUserByUsername(String username);
}