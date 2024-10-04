package com.my_blog.blogger.controller;

import com.my_blog.blogger.model.Useras;
import com.my_blog.blogger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4000")
public class UserController {
    UserService service;

    @GetMapping("/getuser")
    public List<Useras> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/getuser/{id}")
    public Useras findUserById(@PathVariable Long id) {
        return service.findUserById(id);
    }

    @PostMapping("/saveuser")
    public Useras saveUser(@RequestBody Useras user) {
        return service.saveUser(user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return id + " User deleted.";
    }

    @PutMapping("/edituser/{id}")
    public Useras editUser(@RequestBody Useras user, @PathVariable Long id) {
        try {
            return service.editUser(user, id);
        }catch (Exception e) {
            System.out.println(id+ " Update işlemi hatalı.");
            return null;
        }
    }
}
