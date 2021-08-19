package com.dan.dot.pagos.service;

import com.dan.dot.pagos.domain.Pago;
import com.dan.dot.pagos.repository.PagoRepository;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    PagoRepository pagoRepository;

    @Override
    public List<Pago> listarTodos(){
        return this.pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> buscarPagoPorId(Integer id) throws RecursoNoEncontradoException{
        if(!pagoRepository.existsById(id)){
            throw new RecursoNoEncontradoException("Pago con id " + id + " no encontrado.");
        }

        return this.pagoRepository.findById(id);
    }

    @Override
    public Pago guardar(Pago p) throws RecursoNoPersistidoException {
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
    public List<Pago> buscarPorClienteId(Integer clienteId) {
        return pagoRepository.findPagosByClienteId(clienteId);
    }

    @Override
    public Pago borrar(Integer id) throws RecursoNoEncontradoException {
        Pago p;

        if(pagoRepository.existsById(id)){
            p = pagoRepository.findPagoById(id).get();
            p.setHabilitado(false);
            pagoRepository.save(p);
        }
        else{
            throw new RecursoNoEncontradoException("Pago con id " + id + " no encontrado.");
        }

        return p;
    }

    private List<Pago> listarPagos() {
        return Lists.newArrayList(pagoRepository.findAll().iterator());
    }

}
