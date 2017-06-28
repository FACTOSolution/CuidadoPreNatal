package com.example.fmendes.cuidadoprenatalapp.controller.core;

/**
 * Created by Fmendes on 31/05/2017.
 */

public class Noticia {

    private String titulo;
    private Integer img;
    private Integer imagemAutor;
    private String autor;
    private String descricao;

    public Noticia(){}


    public Noticia(String titulon, Integer imgn, String autorn, String descricaon, Integer imgAutor){

        this.titulo = titulon;
        this.img = imgn;
        this.autor = autorn;
        this.descricao = descricaon;
        this.imagemAutor = imgAutor;

    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getImagemAutor() {
        return imagemAutor;
    }

    public void setImagemAutor(Integer imagemAutor) {
        this.imagemAutor = imagemAutor;
    }


}
