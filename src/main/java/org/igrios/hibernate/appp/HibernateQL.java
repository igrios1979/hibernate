package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.dominio.ClienteDto;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import java.util.List;

public class HibernateQL {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("==========================||Consultar todos||====================" );
        List<Cliente> ct = em.createQuery("select c from Cliente c ",Cliente.class).getResultList();

       ct.forEach(System.out::println);
        System.out.println("==========================||Consultar por iD||====================" );
        Cliente cl = em.createQuery("Select c from Cliente c where c.id=:id",Cliente.class)
                .setParameter("id",46L).getSingleResult();
        System.out.println("cl = " + cl);

        System.out.println("==========================||solo Nombre||====================" );
        String cli = em.createQuery("Select c.nombre from Cliente c where c.id=:id",String.class)
                .setParameter("id",41L).getSingleResult();
        System.out.println("nombre cliente Id 35:::" + cli);

        System.out.println("==========================|PERSONALIZADAO|===================");

        Object[] objetoCliente = em.createQuery("select c.nombre, c.id , c.apellido from Cliente c where c.id=:id",Object[].class)
                .setParameter("id",40L).getSingleResult();

        Long id = (Long) objetoCliente[1];
        String nombre = (String) objetoCliente[0];

        System.out.println("nombre id  = " + nombre +"  id"+"  "+id);


        System.out.println(" ==== Personalisados lista de objetos  ");

        List<Object[]> registros = em.createQuery("select c.id,c.nombre from Cliente c",Object[].class).getResultList();
        for(Object[] reg : registros){
            id = (Long) reg[0];
            nombre = (String) reg[1];
            System.out.println(" id =  " + id + "  nombre: "  +nombre);

        }
        registros.forEach(r ->{
            Long cid = (Long)  r[0];
            String nom = (String) r[1];
            System.out.println("nom +\" -- \"+ cid); = " + nom +" -- "+ cid);
            
        });
        System.out.println(" ==== Personalisados Lista de objetos instanciacion dinamica  ========  ");

         ct = em.createQuery("select new Cliente(c.nombre,c.apellido) from Cliente c",Cliente.class).getResultList();
         ct.forEach(System.out::println);



        System.out.println(" ==== Personalisados Lista de objetos instanciacion dinamica  ========  ");

        List<ClienteDto> ctdto = em.createQuery("select new org.igrios.hibernate.appp.dominio.ClienteDto(c.nombre,c.apellido) from Cliente c", ClienteDto.class).getResultList();
        ctdto.forEach(System.out::println);

em.close();
    }
}
