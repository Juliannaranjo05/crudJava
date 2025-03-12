package com.sena.crud_basic.DTO;

public class CommentDTO {
    private int id_comment;
    private int id_user;
    private int id_event;
    private String comment;
    private String date_comment;

    public CommentDTO() {
    }

    public CommentDTO(int id_comment, int id_user, int id_event, String comment, String date_comment) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.id_event = id_event;
        this.comment = comment;
        this.date_comment = date_comment;
    }

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate_comment() {
        return date_comment;
    }

    public void setDate_comment(String date_comment) {
        this.date_comment = date_comment;
    }
}