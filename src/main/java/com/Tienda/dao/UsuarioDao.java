package com.Tienda.dao;

import com.Tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String name, String Password);

    Usuario findByUsernameOrCorreo(String name, String email);

    boolean existsByUsernameOrCorreo(String name, String email);

}
