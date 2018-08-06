package dan.springboot.controller;

import dan.springboot.model.User;
import dan.springboot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private Service service;

    @GetMapping("/users")
    public List<User> retrieveUsers() {
        return service.retrieveAllUsers();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        return service.retrieveUser(id);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Integer id) {
        if (service.removeUser(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user) {
        if (service.updateUser(user)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("users")
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }
}
