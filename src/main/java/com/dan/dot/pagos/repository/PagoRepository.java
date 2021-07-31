package com.dan.dot.pagos.repository;
import frsf.isi.dan.InMemoryRepository;
import com.dan.dot.pagos.domain.Pago;

public class PagoRepository extends InMemoryRepository<Pago>{

    @Override
    public Integer getId(Pago pago) {
        return pago.getId();
    }

    @Override
    public void setId(Pago pago, Integer id) {
        pago.setId(id);
    }
}
