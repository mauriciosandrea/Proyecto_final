package com.techlab.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.techlab.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}