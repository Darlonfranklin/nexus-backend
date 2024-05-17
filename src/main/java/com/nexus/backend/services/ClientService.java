package com.nexus.backend.services;
import com.nexus.backend.domain.Client;
import com.nexus.backend.domain.dtos.ClientDTO;
import com.nexus.backend.repositories.ClientRepository;
import com.nexus.backend.services.exceptions.DataIntegrityViolationException;
import com.nexus.backend.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client create(ClientDTO objDTO) {
        objDTO.setId(null);
        validForCpfAndEmail(objDTO);
        Client newObj = new Client(objDTO);
        return repository.save(newObj);
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found! " + id));
    }

    public Client update(Long id, @Valid ClientDTO objDTO) {
        objDTO.setId(id);
        Client oldObj = findById(id);
        oldObj = new Client(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Long id) {
        Client obj = findById(id);
        repository.deleteById(id);
    }

    public void validForCpfAndEmail(ClientDTO objDTO) {
        Optional<Client> obj = repository.findByPersonCpf(objDTO.getCpf());

        if (obj.isPresent() && !Objects.equals(obj.get().getId(), objDTO.getId())) {
            throw new DataIntegrityViolationException("CPF already exists");
        }

        obj = repository.findByPersonEmail(objDTO.getEmail());
        if (obj.isPresent() && !Objects.equals(obj.get().getId(), objDTO.getId())) {
            throw new DataIntegrityViolationException("E-MAIL already exists");
        }
    }
}
