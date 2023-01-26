package com.app.api.controller;

import com.app.api.entity.Roles;
import com.app.api.entity.UserRole;
import com.app.api.entity.Users;
import com.app.api.service.RoleService;
import com.app.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_role")
public class UserRoleRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
/*
    @GetMapping("/list")
    public ResponseEntity<?> list_GET()
    {
        UserRole userRole = new UserRole();
        Users userDb=userService.findById(userRole.getUser().getUserId());
        if(userDb!=null) {
            Roles roleDb=roleService.findById(userRole.getRole().getRoleId());
            if(roleDb!=null) {

            }
        }

        if(collectionMapper.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(collectionMapper,HttpStatus.OK);
        }
    }*/
    @PostMapping("/register")
    public ResponseEntity<?> register_POST(@RequestBody UserRole userRole){
        Users userDb=userService.findById(userRole.getUser().getUserId());
        if(userDb!=null) {
            Roles roleDb=roleService.findById(userRole.getRole().getRoleId());

            if(roleDb!=null) {
                userDb.addRole(roleDb);
                userService.update(userDb);

                return new ResponseEntity<>("!User Role Registrado !", HttpStatus.OK);
            }

            return new ResponseEntity<>("¡Error, Role no existe!",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("¡Error, User no existe!",HttpStatus.NOT_FOUND);
    }
}
