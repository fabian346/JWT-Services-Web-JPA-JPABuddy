package com.kardex.api.repository.producto.impl;


import com.kardex.api.model.entities.Producto;
import com.kardex.api.repository.producto.IProductoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoRepositoryImpl implements IProductoRepoImpl{

    private final IProductoRepository iProductoRepository;

    public ProductoRepositoryImpl(IProductoRepository iProductoRepository) {
        this.iProductoRepository = iProductoRepository;
    }

    @Override
    public Optional<Producto> save(Producto request) {

        return Optional.of(iProductoRepository.save(request));
    }

    @Override
    public List<Producto> getProductos() {

        return iProductoRepository.findAll();
    }


}
