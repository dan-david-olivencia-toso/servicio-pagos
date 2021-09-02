package com.dan.dot.pagos.rest;

import com.dan.dot.pagos.domain.Pago;
import com.dan.dot.pagos.service.PagoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin(maxAge = 86400)
@RestController
@RequestMapping("/api/pago")
@Api(value = "PagoRest", description = "Permite gestionar la información relacionada a los pagos de los clientes")
public class PagoRest {

    @Autowired
    PagoService pagoService;

    @CrossOrigin(maxAge = 86400)
    @GetMapping
    public ResponseEntity<?> todos(){
        List<Pago> listaPagos = new ArrayList<>();
        try{
            listaPagos = pagoService.listarTodos();
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        return ResponseEntity.ok(listaPagos);
    }

    @CrossOrigin(maxAge = 86400)
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Pago pago){
        Pago p = null;

        try {
            p = this.pagoService.guardar(pago);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        return ResponseEntity.ok(p);
    }

    @CrossOrigin(maxAge = 86400)
    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un pago por id")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        Optional<Pago> p = null;
        try{
            p = this.pagoService.buscarPagoPorId(id);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        return ResponseEntity.ok(p);
    }

    @CrossOrigin(maxAge = 86400)
    @GetMapping(path = "/cliente/{idCliente}")
    @ApiOperation(value = "Estado de cuenta corriente de un cliente con un detalle de Pagos")
    public ResponseEntity<?> buscarPorClienteId(@PathVariable Integer idCliente) {
        List<Pago> pagosCliente = null;

        try {
            pagosCliente = this.pagoService.buscarPorClienteId(idCliente);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        return ResponseEntity.ok(pagosCliente);
    }

    @CrossOrigin(maxAge = 86400)
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Borra lógicamente un Pago")
    public ResponseEntity<?> borrar(@PathVariable Integer id){
        try {
            this.pagoService.borrar(id);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        return ResponseEntity.ok().build();
    }

}
