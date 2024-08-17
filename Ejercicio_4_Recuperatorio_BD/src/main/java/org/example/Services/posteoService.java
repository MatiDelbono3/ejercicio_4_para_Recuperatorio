package org.example.Services;

import org.example.DTO.posteo;
import org.example.connections.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class posteoService {
    public List<posteo> ObtenerPostsSinComentarios(){
        Session session= HibernateUtil.getSession();
        List<posteo>PosteosSinComentarios=new ArrayList<>();
        try {
            session.beginTransaction();
            String Sql3="SELECT p.*\n" +
                    "FROM posts p\n" +
                    "LEFT JOIN comentarios c ON p.id = c.post_id\n" +
                    "WHERE c.post_id IS NULL\n" +
                    "ORDER BY p.fecha_publicacion DESC";
            Query<posteo>Consulta3=session.createQuery(Sql3, posteo.class);
            PosteosSinComentarios=Consulta3.getResultList();
            return PosteosSinComentarios;
        }finally {
            session.close();
        }
    }
}
