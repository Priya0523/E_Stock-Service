package com.fse.stcokdetails.Controller;

import com.fse.stcokdetails.Model.User;
import com.fse.stcokdetails.Service.UserService;
import com.fse.stcokdetails.util.ServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@Slf4j
@EnableSwagger2
@RequestMapping(ServiceConstants.USER_API)
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/users")
    void addUser( User user){
        userService.addUser(user);
    }
}
