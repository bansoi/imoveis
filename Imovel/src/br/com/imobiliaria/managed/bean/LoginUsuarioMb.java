package br.com.imobiliaria.managed.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.imobiliaria.entity.Usuario;
import br.com.imobiliaria.helper.UsuarioDao;

@ManagedBean(name = "login")
@SessionScoped
public class LoginUsuarioMb {

	private Usuario usuario = new Usuario();

	public String validarSenha() {
		UsuarioDao usuarioDao = new UsuarioDao(Usuario.class);

		boolean validado = usuarioDao.validarSenhaUsuario(usuario.getSenha(), usuario.getNickName());

		if (validado) {
			return "sucesso";
		}
		usuario = new Usuario();
		FacesContext.getCurrentInstance().addMessage("erro", new FacesMessage("Senha ou login incorreto!"));
		return "index";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
