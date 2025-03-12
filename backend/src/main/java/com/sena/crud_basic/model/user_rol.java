package com.sena.crud_basic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_rol")
public class user_rol {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_user_rol")
   private int idUserRol;

   @ManyToOne
   @JoinColumn(name = "id_usuario", nullable = false)
   private user user;

   @Column(name = "id_rol", nullable = false)
   private int idRol;

   public user_rol() {
   }

   public user_rol(int idUserRol, user user, int idRol) {
      this.idUserRol = idUserRol;
      this.user = user;
      this.idRol = idRol;
   }

   public int getIdUserRol() {
      return idUserRol;
   }

   public void setIdUserRol(int idUserRol) {
      this.idUserRol = idUserRol;
   }

   public user getUser() {
      return user;
   }

   public void setUser(user user) {
      this.user = user;
   }

   public int getIdRol() {
      return idRol;
   }

   public void setIdRol(int idRol) {
      this.idRol = idRol;
   }
}