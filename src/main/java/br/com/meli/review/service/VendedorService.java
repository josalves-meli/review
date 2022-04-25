package br.com.meli.review.service;

import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor salvar(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    public Vendedor obter(Long id) {
        Optional<Vendedor> byId = this.vendedorRepository.findById(id);
        return byId.orElse(new Vendedor());
    }
}
