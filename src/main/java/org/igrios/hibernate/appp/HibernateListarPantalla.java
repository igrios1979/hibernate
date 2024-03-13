package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class HibernateListarPantalla {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        List<Cliente> clientes = em.createQuery("select c from Cliente  c").getResultList();

        SwingUtilities.invokeLater(() -> {
            createAndShowGUI(clientes);
        });

        em.close();
    }

    private static void createAndShowGUI(List<Cliente> clientes) {
        JFrame frame = new JFrame("Lista de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        frame.getContentPane().add(panel);

        String[] columnNames = {"id", "Nombre", "Apellido", "tipoPago"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        clientes.forEach(cliente -> {
            Object[] rowData = {cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getTipoPago()};
            model.addRow(rowData);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
