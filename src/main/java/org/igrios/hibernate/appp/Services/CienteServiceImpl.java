package org.igrios.hibernate.appp.Services;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.repositories.CrudRepository;
import org.igrios.hibernate.appp.repositories.Crudimple;
import java.util.List;
import java.util.Optional;

public class CienteServiceImpl implements ClientesService{

    private EntityManager em;
    private CrudRepository<Cliente> crud;

    public CienteServiceImpl(EntityManager em) {
        this.em = em;
        this.crud = new Crudimple(em);
    }

    @Override
    public List<Cliente> listar() {

       return crud.listar();
    }

    @Override
    public Optional<Cliente> porId(Long id) {
        return Optional.ofNullable(crud.PorId(id));
    }

    @Override
    public void guardar(Cliente cliente) {
        try{
                em.getTransaction().begin();
                crud.guardar(cliente);
                em.getTransaction().commit();

        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try{
            em.getTransaction().begin();
            crud.eliminar(id);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }
}
