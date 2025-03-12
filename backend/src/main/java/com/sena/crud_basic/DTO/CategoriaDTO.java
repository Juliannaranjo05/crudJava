package com.sena.crud_basic.DTO;

public class CategoriaDTO {
    private int idCategoria;
    private String nombreCategoria;

    // Constructor vacío
    public CategoriaDTO() {}

    // Constructor con parámetros
    public CategoriaDTO(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    // Getters y Setters
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
