package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.Services.CienteServiceImpl;
import org.igrios.hibernate.appp.Services.ClientesService;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import java.util.List;
import java.util.Optional;

public class HibernateCrudService {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        ClientesService service = new CienteServiceImpl(em);
        System.out.println("==========|LISTAR|==============");
        List<Cliente> clientes = service.listar();

        clientes.forEach(c -> System.out.println("->" + c));

        System.out.println("==========|POR ID|==============");
        Optional<Cliente> optcl = service.porId(2L);
        optcl.ifPresent(System.out::println);

        System.out.println("==========|INSERTAR NVO CLIENTE|==============");

        Cliente cl = new Cliente();
        cl.setApellido("uriburo");
        cl.setNombre("felix");
        cl.setTipoPago("Efectivo");

        service.guardar(cl);
        System.out.println("insert ok .............");
        service.listar().forEach(System.out::println);
        em.close();



    }


}
