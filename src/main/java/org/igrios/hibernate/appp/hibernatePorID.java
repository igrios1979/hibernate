package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import java.util.Scanner;

public class hibernatePorID {
    public static void main(String[] args) {

        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {

            System.out.println("Ingrese el ID del cliente (o 'exit' para salir):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                salir = true;
                continue; // Ir directamente a la siguiente iteración del bucle
            }

            try {
                Long id = Long.parseLong(input);

                EntityManager em = JpaUtil.getEntityManager();
                Cliente cliente = em.find(Cliente.class, id);
                System.out.println("Cliente: " + cliente);
                em.close();
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un ID válido (número entero).");
            }
        }
    }
}
