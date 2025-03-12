package com.sena.crud_basic.DTO;

public class UserRolDTO {
    private int idRol;
    private int idUserRol;
    private int idUsuario;

    public UserRolDTO(int idRol, int idUserRol, int idUsuario) {
        this.idRol = idRol;
        this.idUserRol = idUserRol;
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdUserRol() {
        return idUserRol;
    }

    public void setIdUserRol(int idUserRol) {
        this.idUserRol = idUserRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
