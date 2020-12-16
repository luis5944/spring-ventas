package com.ventas.ventas.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "cliente")

public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotNull
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 70, message = "El nombre tiene que tener al menos 3 caracteres.")
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;


    @NotNull
    @NotBlank(message = "Los apellidos son obligatorio.")
    @Size(min = 3, max = 150, message = "Los apellidos tienen que tener al menos 3 caracteres.")
    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Size(max = 150, message = "La dirección no puede superar los 150 caracteres.")
    @Column(length = 150)
    private String direccion;


    @Size(min = 6, message = "Al menos 6 caracteres")
    @Column(length = 10)
    private String telefono;


    @NotNull
    @NotBlank(message = "El email es obligatorio")
    @Size(min = 10, message = "El email debe ser de al menos 10 caracteres")
    @Email(message = "El email es incorrecto")
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
