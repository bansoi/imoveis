package br.com.imobiliaria.test;

import static org.junit.Assert.*;

import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.imobiliaria.entity.Usuario;
import br.com.imobiliaria.helper.UsuarioDao;

public class TestValidarSenha {

	UsuarioDao userDao = null;
	
	@Before
	public void createDao(){
		userDao = new UsuarioDao(Usuario.class);
	}
	
	@Test
	public void validarSenhaIncorreta() {
		assertFalse("Senha v�lida",userDao.validarSenhaUsuario("55", "edersp"));
		assertFalse("Usu�rio v�lido", userDao.validarSenhaUsuario("123", "fiap"));
	}

}
