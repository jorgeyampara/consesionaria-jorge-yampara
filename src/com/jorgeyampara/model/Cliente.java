package com.jorgeyampara.model;

public class Cliente {
    private String nif;
    private String nombre;
    private String ciudad;
    private String direccion;
    private int telefono;
    public Cliente(){

    }

    public Cliente(String nif, String nombre, String ciudad, String direccion, int telefono) {
        this.setNif(nif);
        this.setNombre(nombre);
        this.setCiudad(ciudad);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
