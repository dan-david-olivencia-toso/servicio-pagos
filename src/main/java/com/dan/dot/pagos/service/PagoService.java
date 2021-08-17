package com.dan.dot.pagos.service;

import com.dan.dot.pagos.domain.Pago;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//Notación para indicar que es un servicio
@Service
//Asegura que toda la data requerida este segura hasta que la transacción termine
//Recomiendo leer acerca de esta notación (es un mundo completo jeje)
@Transactional
public interface PagoService {

    Pago guardarPago(Pago p) throws RecursoNoEncontradoException;

    List<Pago> estadoCuentaCorriente(Integer idCliente);

    class RecursoNoEncontradoException extends Exception {
        public RecursoNoEncontradoException(String errorMessage, Integer id) {
            super(errorMessage+id);
        }
    }

}
