package br.com.unifor.tcc.lojavirtal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.storage.onestore.v3.OnestoreEntity.User;


@Entity
public class Usuario extends User{
	private String login;
	private String senha;
	private String nickName;
	
	public Usuario(){
		
	}
	
	public Usuario(String login, String senha, String nickName) {
		this.login = login;
		this.senha = senha;
		this.nickName = nickName;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
