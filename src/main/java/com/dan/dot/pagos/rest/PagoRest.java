package com.dan.dot.pagos.rest;

import com.dan.dot.pagos.domain.Cheque;
import com.dan.dot.pagos.domain.Efectivo;
import com.dan.dot.pagos.domain.Pago;
import com.dan.dot.pagos.domain.Transferencia;
import com.dan.dot.pagos.service.PagoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pago")
@Api(value = "PagoRest", description = "Permite gestionar la información relacionada a los pagos de los clientes")
public class PagoRest {

    @Autowired
    PagoService pagoService;

    @PostMapping
    public ResponseEntity<?> crearPago(@RequestBody Pago pago){
        Pago p = null;

        try {
            p = this.pagoService.guardarPago(pago);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        return ResponseEntity.ok(p);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un pago por id")
    public ResponseEntity<?> pagoPorId(@PathVariable Integer id){
        Optional<Pago> p = null;
        try{
            p = this.pagoService.buscarPagoPorId(id);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping(path = "/pagos/{idCliente}")
    @ApiOperation(value = "Estado de cuenta corriente de un cliente con un detalle de Pagos")
    public ResponseEntity<?> estadoCuentaCorriente(@PathVariable Integer idCliente) {
        List<Pago> pagosCliente = null;

        try {
            pagosCliente = this.pagoService.estadoCuentaCorriente(idCliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.ok(pagosCliente);
    }

}
