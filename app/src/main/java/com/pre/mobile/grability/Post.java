package com.pre.mobile.grability;

/**
 * Created by Carlos Mauicio Idárraga Espitia on 10/06/2015.
 */
public class Post{

    //Atributos
    private String titulo;
    private String descripcion;
    private String imagen;

        public Post(){
        }

    public Post (String titulo, String descripcion, String imagen){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}


