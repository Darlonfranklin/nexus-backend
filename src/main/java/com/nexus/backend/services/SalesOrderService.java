package com.nexus.backend.services;

import com.nexus.backend.domain.Client;
import com.nexus.backend.domain.Product;
import com.nexus.backend.domain.Sales;
import com.nexus.backend.domain.SalesOrder;
import com.nexus.backend.domain.dtos.ClientDTO;
import com.nexus.backend.domain.dtos.SalesOrderDTO;
import com.nexus.backend.repositories.ClientRepository;
import com.nexus.backend.repositories.SalesOrderRepository;
import com.nexus.backend.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository repository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    public SalesOrder create(SalesOrderDTO objDTO) {
        return repository.save(newSalesOrder(objDTO));
    }

    public List<SalesOrder> findAll() {
        return repository.findAll();
    }

    public SalesOrder findById(Long id) {
        Optional<SalesOrder> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found! " + id));
    }

    public SalesOrder update(Long id, @Valid SalesOrderDTO objDTO) {
        objDTO.setId(id);
        SalesOrder oldObj = findById(id);
        oldObj = new SalesOrder(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Long id) {
        SalesOrder obj = findById(id);
        repository.deleteById(id);
    }


    private SalesOrder newSalesOrder(SalesOrderDTO obj) {
        Client client = clientService.findById(obj.getClient());
        Product product = productService.findById(obj.getProduct());

        SalesOrder salesOrder = new SalesOrder();
        if (obj.getId() != null) {
            salesOrder.setId(obj.getId());
        }

        if (salesOrder.getSales() == null) {
            salesOrder.setSales(new Sales());
        }

        salesOrder.setClient(client);
        salesOrder.setProduct(product);
        salesOrder.getSales().setRequestDate(obj.getRequestDate());
        salesOrder.getSales().setProductQuantity(obj.getProductQuantity());
        salesOrder.getSales().setTotalValue(obj.getTotalValue());
        return salesOrder;
    }

}
