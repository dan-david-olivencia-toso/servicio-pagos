package com.dan.dot.pagos.repository;
import com.dan.dot.pagos.domain.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    Optional<Pago> findPagoById(Integer id);
    List<Pago> findPagosByClienteId(Integer id);
    Pago save(Pago pago);
}
