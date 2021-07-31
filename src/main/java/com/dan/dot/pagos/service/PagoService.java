package com.dan.dot.pagos.service;

import com.dan.dot.pagos.domain.Pago;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PagoService {

    Pago guardarPago(Pago p) throws RecursoNoEncontradoException;

    List<Pago> estadoCuentaCorriente(Integer idCliente);

    class RecursoNoEncontradoException extends Exception {
        public RecursoNoEncontradoException(String errorMessage, Integer id) {
            super(errorMessage+id);
        }
    }

}
