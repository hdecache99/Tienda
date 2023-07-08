package com.Tienda.service;

import com.Tienda.domain.Producto;
import java.util.List;

public interface ProductoService {

    //Metodo para consultar las categorias
    public List<Producto> getProductos(boolean activos);

    //Se obtiene una categoria por su ID
    public Producto getProducto(Producto categoria);

    //Inserta : se inserta cuando el idProducto esta vavio (Valor 0 o null)
    //Modificar; Se modifica cuando idCategirua NO esta vaci
    public void save(Producto categoria);
    
    //Se elimina resgistro por su idProducto
    public void delete(Producto categoria);

}
