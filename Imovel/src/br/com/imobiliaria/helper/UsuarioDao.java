package br.com.imobiliaria.helper;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.imobiliaria.entity.Usuario;

public class UsuarioDao extends GenericDaoImpl<Usuario>{

	public UsuarioDao(Class<Usuario> clazz) {
		super(clazz);
	}
	
	
	public boolean validarSenhaUsuario(String senha , String nickName){
		openSessionAndBeginTransaction();
		
		Criteria query = session.createCriteria(Usuario.class);
		
		query.add(Restrictions.and(Restrictions.eq("senha", senha),Restrictions.eq("nickName", nickName)));
		
		Usuario usuario = (Usuario) query.uniqueResult();
		
		if (usuario != null) {
			return true;
		}
		
		return false;
	}
}
