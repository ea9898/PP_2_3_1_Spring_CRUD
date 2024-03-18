package web.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.example.project.entity.User;
import web.example.project.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping(value = "/users")
	public void getAllUsers(ModelMap model) {

	}

	@GetMapping("/home")
	public ResponseEntity<String> home() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/update/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userService.update(user, id);
	}
}