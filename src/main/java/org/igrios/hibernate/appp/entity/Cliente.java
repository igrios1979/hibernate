package org.igrios.hibernate.appp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(name="forma_pago")
    private String tipoPago;

    // Constructor por defecto Obligado por defecto por que Hibernate instancia y  si no lo tiene lanza Error

    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(String nombre, String apellido, String tipoPago) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoPago = tipoPago;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    // Método toString
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tipoPago='" + tipoPago + '\'' +
                '}';
    }
}
