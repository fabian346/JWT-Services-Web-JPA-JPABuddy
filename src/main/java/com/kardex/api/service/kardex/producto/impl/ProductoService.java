package com.kardex.api.service.kardex.producto.impl;

import com.kardex.api.commons.util.Converter;
import com.kardex.api.model.dto.kardex.ProductoDto;
import com.kardex.api.model.entities.Producto;
import com.kardex.api.repository.producto.impl.IProductoRepoImpl;
import com.kardex.api.service.kardex.producto.IProductoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.SystemException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final IProductoRepoImpl iProductoRepo;


    @Autowired
    public ProductoService(IProductoRepoImpl iProductoRepo) {
        this.iProductoRepo = iProductoRepo;
    }


    @Override
    public ProductoDto createPro(ProductoDto request) throws SystemException, NotFoundException {

        var in = iProductoRepo.save(Converter.converterObject(request, Producto.class));
        if(in.isPresent()){
            return Converter.converterObject(in.get(), ProductoDto.class);
        }
        else{
            throw new SystemException("Not possible create product");

        }
    }

    @Override
    public List<ProductoDto> getProductos(){

        List<ProductoDto> listDto = new ArrayList<>();
        var list = iProductoRepo.getProductos();

        for (Producto i : list) {

            listDto.add(Converter.converterObject(i, ProductoDto.class));
        }

        return listDto;
    }

    @Override
    public void updateProducto(Producto pr){

        iProductoRepo.save(pr);
    }
}
