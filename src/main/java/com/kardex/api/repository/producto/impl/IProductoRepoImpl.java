package com.kardex.api.repository.producto.impl;

import com.kardex.api.model.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoRepoImpl {

    Optional<Producto> save(Producto resquest);

    List<Producto> getProductos();

}
