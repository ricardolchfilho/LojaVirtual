package br.com.unifor.tcc.lojavirtal.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.annotation.NotSaved;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;

	private String descricao;

	private Double preco;

	private boolean vendido = false;
	
	@NotSaved
	private Categoria categoria;
	
	private Key<Categoria> categoriaKey;
	
	public Produto() {
	}

	public Produto(String nome, String descricao, BigDecimal preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco.doubleValue();
	}
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this(nome, descricao, preco);
		this.categoria = categoria;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	@PrePersist
	void onSave(Objectify ofy) {
		if (categoria != null) {
			ofy.put(categoria);
			this.categoriaKey = new Key<Categoria>(Categoria.class, categoria.getCodigo());
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void definirComoVendido() {
		this.vendido = true;
	}
	
	public boolean isVendido() {
		return vendido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Produto other = (Produto) obj;

		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}

		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
