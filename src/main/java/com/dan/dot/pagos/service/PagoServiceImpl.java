package com.dan.dot.pagos.service;

import com.dan.dot.pagos.domain.Pago;
import com.dan.dot.pagos.repository.PagoRepository;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired //Configuration necesaria para guardar en memoria
    PagoRepository pagoRepository;

    @Override
    public Optional<Pago> buscarPagoPorId(Integer id) throws RecursoNoEncontradoException{
        if(!pagoRepository.existsById(id)){
            throw new RecursoNoEncontradoException("Pago con id " + id + " no encontrado.");
        }

        return this.pagoRepository.findById(id);
    }

    @Override
    public Pago guardarPago(Pago p) throws RecursoNoPersistidoException {
        Pago pagoGuardado = null;

        if(!pagoRepository.existsById(p.getCliente().getId())){
            throw new RecursoNoPersistidoException("Pago no persistido en base de datos. Cliente con ID no encontrado: " + p.getCliente().getId());
        }

        try{
            pagoRepository.save(p);
        }
        catch(Exception ex){
            throw new RecursoNoPersistidoException("Pago no persistido en base de datos: " + ex);
        }

        return pagoGuardado;
    }

    @Override
    public List<Pago> estadoCuentaCorriente(Integer idCliente) {
        // TODO: Cambiar implementación de método
        List<Pago> lp = (List<Pago>) listarPagos()
                .stream()
                .filter(unPago -> unPago.getCliente().getId().equals(idCliente))
                .collect(Collectors.toList());

        return lp;
    }


    private List<Pago> listarPagos() {
        return Lists.newArrayList(pagoRepository.findAll().iterator());
    }

}
