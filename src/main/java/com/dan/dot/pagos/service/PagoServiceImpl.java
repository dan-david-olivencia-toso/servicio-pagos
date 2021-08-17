package com.dan.dot.pagos.service;

import com.dan.dot.pagos.domain.Pago;
import com.dan.dot.pagos.repository.PagoRepository;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired //Configuration necesaria para guardar en memoria
    PagoRepository pagoRepository;

    @Override
    public Pago guardarPago(Pago p) throws RecursoNoEncontradoException {

        if(!pagoRepository.existsById(p.getCliente().getId())) {
            throw new RecursoNoEncontradoException("Cliente no encontrado con ID:", p.getCliente().getId());
        }

        pagoRepository.save(p);
        return p;
    }

    @Override
    public List<Pago> estadoCuentaCorriente(Integer idCliente) {
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
