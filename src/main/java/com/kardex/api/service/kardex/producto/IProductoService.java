package com.kardex.api.service.kardex.producto;

import com.kardex.api.model.dto.kardex.ProductoDto;
import com.kardex.api.model.entities.Producto;
import javassist.NotFoundException;

import javax.transaction.SystemException;
import java.util.List;

public interface IProductoService {

    ProductoDto createPro(ProductoDto request) throws SystemException, NotFoundException;

    List<ProductoDto> getProductos();

    void updateProducto(Producto pr);

}
