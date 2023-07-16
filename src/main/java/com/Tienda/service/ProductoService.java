package com.Tienda.service;

import com.Tienda.domain.Producto;
import java.util.List;

public interface ProductoService {

    //Metodo para consultar las categorias
    public List<Producto> getProductos(boolean activos);

    //Se obtiene una categoria por su ID
    public Producto getProducto(Producto producto);

    //Inserta : se inserta cuando el idProducto esta vavio (Valor 0 o null)
    //Modificar; Se modifica cuando idCategirua NO esta vaci
    public void save(Producto producto);

    //Se elimina resgistro por su idProducto
    public void delete(Producto producto);

    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    
    //Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> metodoNativo(double precioInf, double precioSup);

}
