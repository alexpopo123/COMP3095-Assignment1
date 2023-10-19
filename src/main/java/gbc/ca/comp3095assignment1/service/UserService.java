package gbc.ca.comp3095assignment1.service;

import gbc.ca.comp3095assignment1.model.User;
import gbc.ca.comp3095assignment1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User createUser(User user) {
        // Implement the logic to create and save a new user in the database
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        // Implement the logic to retrieve a list of all users from the database
        return userRepository.findAll();
    }

    // Get a user by ID
    public Optional<User> getUserById(Long id) {
        // Implement the logic to retrieve a user by their ID from the database
        return userRepository.findById(id);
    }

    // Update a user by ID
    public User updateUser(Long id, User updatedUser) {
        // Implement the logic to update a user by their ID in the database
        if (userRepository.existsById(id)) {
            updatedUser.setId(id); // Set the ID for the updated user
            return userRepository.save(updatedUser); // Save the updated user
        } else {
            // Handle the case where the user with the given ID does not exist
            return null;
        }
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        // Implement the logic to delete a user by their ID from the database
        userRepository.deleteById(id);
    }
}