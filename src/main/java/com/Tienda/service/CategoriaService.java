package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //Metodo para consultar las categorias
    public List<Categoria> getCategorias(boolean activos);
    
}
