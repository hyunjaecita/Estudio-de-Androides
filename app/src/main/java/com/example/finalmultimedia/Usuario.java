package com.example.finalmultimedia;

public class Usuario {
    private String nombre;
    private String dni;
    private String email;
    private String cumple;

    public Usuario(String nombre, String dni, String email, String cumple){
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.cumple = cumple;

    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getCumple() {
        return cumple;
    }

}
