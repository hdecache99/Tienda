package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    //Metodo para consultar las categorias
    public List<Categoria> getCategorias(boolean activos);

    //Se obtiene una categoria por su ID
    public Categoria getCategoria(Categoria categoria);

    //Inserta : se inserta cuando el idCategoria esta vavio (Valor 0 o null)
    //Modificar; Se modifica cuando idCategirua NO esta vaci
    public void save(Categoria categoria);
    
    //Se elimina resgistro por su idCategoria
    public void delete(Categoria categoria);

}
