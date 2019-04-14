package ru.koval.UsersStuff;

import org.springframework.security.core.GrantedAuthority;

public enum UsersRoles implements GrantedAuthority {
    Admin, User;

    @Override
    public String getAuthority() {
        return name();
    }
}
