package com.axsos.BookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.BookClub.models.LoginUser;
import com.axsos.BookClub.models.User;
import com.axsos.BookClub.repositories.UserRepository;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "Unique", "This email is already in use");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The confirm password must match the password");
    	}
    	if(result.hasErrors()) {
    		 return null;
    	}
    	else {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		return userRepo.save(newUser);
    	}
        // TO-DO: Additional validations!
       
    }
    public User login(LoginUser newLogin, BindingResult result) {
        // TO-DO: Additional validations!
    	if(result.hasErrors()) {
    		return null;
    	}
    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Unique", "Unknown email");
    		return null;
    	}
    	User user = potentialUser.get();
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	else {
    		return user;
    	}
        
    }
    public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);
    	if(u.isPresent()) {
    		return u.get();
    	}
    	else {
    		return null;
    	}
    }

}
