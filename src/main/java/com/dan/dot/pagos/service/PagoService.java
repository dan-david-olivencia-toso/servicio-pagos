package com.dan.dot.pagos.service;

import com.dan.dot.pagos.domain.Pago;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//Notación para indicar que es un servicio
@Service
//Asegura que toda la data requerida este segura hasta que la transacción termine
//Recomiendo leer acerca de esta notación (es un mundo completo jeje)
@Transactional
public interface PagoService {

    Optional<Pago> buscarPagoPorId(Integer id) throws RecursoNoEncontradoException;
    List<Pago> listarTodos();
    List<Pago> buscarPorClienteId(Integer idCliente)  throws RecursoNoEncontradoException;
    Pago guardar(Pago p) throws RecursoNoPersistidoException;
    Pago borrar(Integer id) throws RecursoNoEncontradoException;

    public static class RecursoNoEncontradoException extends Exception {
        public RecursoNoEncontradoException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static class RecursoNoPersistidoException extends Exception {
        public RecursoNoPersistidoException(String errorMessage) { super(errorMessage); }
    }

}
