package org.igrios.hibernate.appp.Services;

import org.igrios.hibernate.appp.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClientesService {

    List<Cliente> listar();
    Optional<Cliente> porId(Long id);
    void guardar(Cliente cliente);
    void eliminar(Long id);

}
