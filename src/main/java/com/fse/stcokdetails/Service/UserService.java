package com.fse.stcokdetails.Service;

import com.fse.stcokdetails.Model.User;
import com.fse.stcokdetails.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void addUser(User user) {
        userRepository.save(user);

    }
}
