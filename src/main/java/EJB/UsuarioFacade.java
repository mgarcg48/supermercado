/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import practica1.modelo.Usuario;

/**
 *
 * @author Perico
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "publicacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public boolean existeUsuario(String nombreUsuario){
        boolean existe=false;
        String consulta;
        List<Usuario> listaDeUsuarios;
        
        try{
            consulta="FROM Usuario u WHERE u.userUsuario=?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, nombreUsuario);
            listaDeUsuarios=query.getResultList();
            
            if(!listaDeUsuarios.isEmpty()){
                existe=true;
            }
            
        }catch(Exception e){
            System.out.println("NO hemos podido hacer la consulta a la base de datos");
        }
        
        
        
        return existe;
    }
    
    @Override
    public Usuario obtenerUsuario(Usuario usuario){
        Usuario user = null;
        List<Usuario> listaDeUsuarios;
        
        try{
            String consulta="FROM Usuario u WHERE u.userUsuario= ?1 and u.passwordUsuario= ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, usuario.getUserUsuario());
            query.setParameter(2, usuario.getPasswordUsuario());
            listaDeUsuarios = query.getResultList();
            if(!listaDeUsuarios.isEmpty()){
                user=listaDeUsuarios.get(0);
            }
            
        }catch(Exception e){
            System.out.println("Error desde el modelo en la consulta a base de datos");
        }
        
        return user;
        
    }
    
    
}
