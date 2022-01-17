package com.kardex.api.web.api.rest.kardex.producto;

import com.kardex.api.commons.constantes.producto.EndPointsProducto;
import com.kardex.api.model.dto.kardex.ProductoDto;
import com.kardex.api.service.kardex.producto.IProductoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.SystemException;
import java.util.List;

@RestController
@RequestMapping("producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final IProductoService productoService;

    @Autowired
    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping(EndPointsProducto.CREATE_PRODUCTO)
    public ResponseEntity<ProductoDto> createPro(@RequestBody ProductoDto dto) throws SystemException, NotFoundException {

        var productResponse = productoService.createPro(dto);

        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping(EndPointsProducto.GET_LIST_PRODUCTO)
    public ResponseEntity<List<ProductoDto>> getAllProductos() throws SystemException, NotFoundException {

        var list = productoService.getProductos();

        return ResponseEntity.ok(list);
    }

    @PostMapping(EndPointsProducto.UPDATE_PRODUCTO)
    public ResponseEntity<ProductoDto> updateProducto(@RequestBody ProductoDto dto) throws SystemException, NotFoundException {

        var productResponse = productoService.createPro(dto);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
