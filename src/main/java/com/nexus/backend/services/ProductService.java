package com.nexus.backend.services;

import com.nexus.backend.domain.Product;
import com.nexus.backend.domain.dtos.ProductDTO;
import com.nexus.backend.repositories.ProductRepository;
import com.nexus.backend.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product create(ProductDTO objDTO) {
        Product newObj = new Product(objDTO);
        return repository.save(newObj);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found! " + id));
    }

    public Product update(Long id, @Valid ProductDTO objDTO) {
        objDTO.setId(id);
        Product oldObj = findById(id);
        oldObj = new Product(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Long id) {
        Product obj = findById(id);
        repository.deleteById(id);
    }
}


