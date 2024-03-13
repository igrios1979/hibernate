package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Scanner;

import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;
public class Conwhere {

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            EntityManager em = JpaUtil.getEntityManager();

            System.out.println("Ingrese el tipo de pago ('exit' para salir):");
            String tipoPago = scanner.nextLine();

            if (tipoPago.equalsIgnoreCase("exit")) {
                salir = true;
                continue;
            }

            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.tipoPago = ?1", Cliente.class);
            query.setParameter(1, tipoPago);

            List<Cliente> clientes = query.getResultList();
            if (clientes.isEmpty()) {
                System.out.println("No se encontró ningún cliente con el tipo de pago especificado.");
            } else {
                System.out.println("Clientes encontrados:");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente);
                }
            }
        }
    }
}
