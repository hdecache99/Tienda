
package com.Tienda.service.impl;

import com.Tienda.dao.UsuarioDao;
import com.Tienda.domain.Rol;
import com.Tienda.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Tienda.service.UsuarioDetailsService;

@Service("userDetailsService")
public class UsuarioDetailServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Attempting to load user: " + username);

        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            System.out.println("User not found: " + username);
            throw new UsernameNotFoundException(username);
        }

        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());

        var roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : usuario.getRoles()) {
            System.out.println("Assigned role: " + rol.getNombre());
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        System.out.println("User authenticated successfully: " + username);

        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
