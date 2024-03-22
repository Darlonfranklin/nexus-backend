package com.nexus.backend.repositories;

import com.nexus.backend.domain.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> { }
