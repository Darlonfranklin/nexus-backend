package com.nexus.backend.services;
import com.nexus.backend.domain.Client;
import com.nexus.backend.domain.dtos.ClientDTO;
import com.nexus.backend.repositories.ClientRepository;
import com.nexus.backend.services.exceptions.DataIntegrityViolationException;
import com.nexus.backend.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourceLoader resourceLoader;

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
        findById(id);
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

    public ByteArrayInputStream generateReport(int id) throws JRException, SQLException, IOException {
        Resource resource = resourceLoader.getResource("classpath:/reports/report-customers.jrxml");

        if (!resource.exists()) {
            throw new FileNotFoundException("O arquivo report-customers.jrxml não foi encontrado.");
        }

        JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ID_PARAM", id);

        try (Connection conn = dataSource.getConnection()) {

            String query = "SELECT * FROM tb_client WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRResultSetDataSource(rs));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            return new ByteArrayInputStream(outputStream.toByteArray());
        }
    }

}
