package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "comentarios")

public class comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "comentario", nullable = false)
    private String comentario;
    @Column(name = "fecha_comentario", nullable = false)
    private String fecha_comentario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private posteos posteo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(String fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }

    public posteos getPosteo() {
        return posteo;
    }

    public void setPosteo(posteos posteo) {
        this.posteo = posteo;
    }
}
