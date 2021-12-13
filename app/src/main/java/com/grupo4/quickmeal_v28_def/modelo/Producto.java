package com.grupo4.quickmeal_v28_def.modelo;

public class Producto {

    private int Id;
    private String nombre;
    private byte[] image;
    private String descripcion;
    private String precio;

    public Producto() {
    }


    public Producto(int id, String nombre, byte[] image, String descripcion, String precio) {
        Id = id;
        this.nombre = nombre;
        this.image = image;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
