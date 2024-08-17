package org.example.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "productos")
public class posteos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String titulo;

    @Column(name = "contenido", nullable = false)
    private String contenido;
    @Column(name = "fecha_publicacion", nullable = false)
    private Date FechaPublicacion;
    @OneToMany(mappedBy = "posteo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<comentarios> comentarios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaPublicacion() {
        return FechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        FechaPublicacion = fechaPublicacion;
    }

    public List<org.example.entities.comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<org.example.entities.comentarios> comentarios) {
        this.comentarios = comentarios;
    }
}
