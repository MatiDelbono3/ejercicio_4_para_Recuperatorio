package org.example.Services;

import org.example.DTO.comentario;
import org.example.connections.HibernateUtil;
import org.example.entities.posteos;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class comentarioService {
    public void InsertarNuevoComentario(posteos posteo){
        Session session= HibernateUtil.getSession();
        try {
        session.beginTransaction();
        session.save(posteo);
        session.getTransaction().commit();
    } finally {
            session.close();
        }
        }
        public List<comentario> ObtenerComentariosDeUnPost(int id_posteo){
            Session session=HibernateUtil.getSession();
            List<comentario>ComentariosDeUnPost=new ArrayList<>();
            try{
                session.beginTransaction();
                String Sql1="SELECT * \n" +
                        "FROM comentarios \n" +
                        "WHERE post_id = :id_posteo";
                Query<comentario>Consulta1=session.createQuery(Sql1, comentario.class);
                Consulta1.setParameter("idPosteo", id_posteo);
                ComentariosDeUnPost=Consulta1.getResultList();
                session.getTransaction().commit();
                return ComentariosDeUnPost;
            }finally {
                session.close();
            }
        }
        public List<Object>ObtenerNumeroComentariosDeCadaPost(){
            Session session=HibernateUtil.getSession();
            List<Object>NumeroComentariosDeCadaPost=new ArrayList<>();
            try {
                session.beginTransaction();
                String Sql2="SELECT post_id, COUNT(*) AS numero_comentarios\n" +
                        "FROM comentarios\n" +
                        "GROUP BY post_id;";
                Query<Object>Consulta2= session.createQuery(Sql2, Object.class);
                NumeroComentariosDeCadaPost=Consulta2.getResultList();
                session.getTransaction().commit();
                return NumeroComentariosDeCadaPost;
            }finally {
                session.close();
            }
        }

}
