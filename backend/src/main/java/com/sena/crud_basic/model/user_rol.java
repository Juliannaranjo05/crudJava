package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity (name="user_rol")

public class user_rol {
    /*
     * atributos o columnas de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private int id_user;

    @Column(name="id_rol",length = 50,nullable = false)
    private int id_rol;


    public user_rol (int id_user, int id_rol){
        this.id_user = id_user;
        this.id_rol = id_rol;
     }

     public int getid_user() {
        return id_user;
     }

     public void setid_user(int id_user){
        this.id_user=id_user;
     }

    public int get_name_rol() {
      return id_rol;
     }
    
    public void set_name_rol(int id_rol){
         this.id_rol=id_rol;
     }
}