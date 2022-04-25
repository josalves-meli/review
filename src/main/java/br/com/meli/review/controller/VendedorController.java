package br.com.meli.review.controller;

import br.com.meli.review.dto.VendedorDTO;
import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    VendedorService vendedorService;

    // busca por id o vendedor
    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> obter(@PathVariable Long id){
        Vendedor vendedorExistente = vendedorService.obter(id);
        VendedorDTO result = VendedorDTO.map(vendedorExistente);
        return ResponseEntity.ok(result);
    }

    // cadastra um novo vendedor
    @PostMapping
    public ResponseEntity<VendedorDTO> cadastrar(@RequestBody VendedorDTO dto, UriComponentsBuilder uriBuilder){
        Vendedor vendedor = dto.map();
        vendedorService.salvar(vendedor);

        URI uri = uriBuilder
                .path("/vendedor/{id}")
                .buildAndExpand(vendedor.getId())
                .toUri();

        VendedorDTO d = dto.map(vendedor);
        return ResponseEntity.created(uri).body(d);

    }
}
