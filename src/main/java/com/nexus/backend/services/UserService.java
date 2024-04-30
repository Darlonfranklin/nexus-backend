package com.nexus.backend.services;

import com.nexus.backend.domain.User;
import com.nexus.backend.domain.dtos.UserDTO;
import com.nexus.backend.repositories.UserRepository;
import com.nexus.backend.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User create(UserDTO objDTO) {
        objDTO.setId(null);
        objDTO.setPassword(encoder.encode(objDTO.getPassword()));
        User newObj = new User(objDTO);
        return repository.save(newObj);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found! " + id));
    }

    public User update(Long id, @Valid UserDTO objDTO) {
        objDTO.setId(id);
        User oldObj = findById(id);
        oldObj = new User(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Long id) {
        User obj = findById(id);
        repository.deleteById(id);
    }

}
