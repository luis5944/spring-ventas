package com.ventas.ventas.model;

import javax.persistence.*;

//Para hacer una tabla
@Entity
//Le pasamos el nombre de la tabla
@Table(name = "cliente")

public class Cliente {

    //Ponemos que sea la id de la tabla y que se genere automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    //Ponemos que sea una columna sin nulos y maximo longitud de 70
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(length = 150)
    private String direccion;

    @Column(length = 10)
    private String telefono;

    @Column(nullable = false, length = 150)
    private String email;


    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
