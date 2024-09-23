package com.UltraC.demo.repositorie;
import com.UltraC.demo.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
