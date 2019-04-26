package ru.koval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.koval.UsersStaff.UsersRoles;
import ru.koval.domain.User;
import ru.koval.repos.UserRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void saveChanges(User user, String newPass){
        boolean isEmailChanged= (newPass != null && !newPass.equals(user.getPassword())) ||
                (user.getPassword() != null && !user.getPassword().equals(newPass));

        if(isEmailChanged){
            user.setPassword(newPass);
            userRepo.save(user);
        }
    }

    public User findUserByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public User editUserByAdmin(String username, Map<String, String> form){
        User user = userRepo.findByUsername(username);

        Set<String> roles = Arrays.stream(UsersRoles.values())
                .map(UsersRoles::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(UsersRoles.valueOf(key));
            }
        }

        userRepo.save(user);
        return user;
    }
}
