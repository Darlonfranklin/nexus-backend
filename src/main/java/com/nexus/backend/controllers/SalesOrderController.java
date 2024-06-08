package com.nexus.backend.controllers;
import com.nexus.backend.domain.SalesOrder;
import com.nexus.backend.domain.dtos.SalesOrderDTO;
import com.nexus.backend.services.SalesOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sales-order")
public class SalesOrderController {

    @Autowired
    private SalesOrderService salesService;

    @PostMapping
    public ResponseEntity<SalesOrderDTO> create(@Valid @RequestBody SalesOrderDTO objDTO) {
        SalesOrder newObj = salesService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<SalesOrderDTO>> findAll() {
        List<SalesOrder> list = salesService.findAll();
        List<SalesOrderDTO> listDTO = list.stream().map(SalesOrderDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SalesOrderDTO> findById(@PathVariable Long id) {
        SalesOrder obj = salesService.findById(id);
        return ResponseEntity.ok().body(new SalesOrderDTO(obj));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SalesOrderDTO> update(@PathVariable Long id, @Valid @RequestBody SalesOrderDTO objDTO) {
        SalesOrder obj = salesService.update(id, objDTO);
        return ResponseEntity.ok().body(new SalesOrderDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SalesOrderDTO> delete(@PathVariable Long id) {
        salesService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
