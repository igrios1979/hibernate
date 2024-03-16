package org.igrios.hibernate.appp.repositories;

import java.util.List;

public interface CrudRepository<G> {

    List<G> listar();
    G PorId(Long id);
    void guardar(G g);
    void eliminar(Long id);

}
