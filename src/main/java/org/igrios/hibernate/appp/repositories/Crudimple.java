package org.igrios.hibernate.appp.repositories;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;

import java.util.List;

public class Crudimple implements CrudRepository<Cliente>{
    private EntityManager em;

    public Crudimple(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> listar() {
        return em.createQuery("select c from Cliente c",Cliente.class).getResultList();
    }

    @Override
    public Cliente PorId(Long id) {
            return em.find(Cliente.class,id);
    }

    @Override
    public void guardar(Cliente cliente) {

        if(cliente.getId() != null && cliente.getId()>0){
            em.merge(cliente); /* Es un update   */

        }else{
            em.persist(cliente); /*insert*/
        }

    }

    @Override
    public void eliminar(Long id) {
       Cliente c =  em.find(Cliente.class,id);
        em.remove(c);


    }
}
