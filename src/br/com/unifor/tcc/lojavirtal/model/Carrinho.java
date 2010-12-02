package br.com.unifor.tcc.lojavirtal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Carrinho implements Serializable,CarrinhoRepositorio{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Item> itens = new ArrayList<Item>();
	private Integer unidades = 0;
	private Double total = 0.0;
	
	@Override
	public void adiciona(Item item) {
		itens.add(item);
		total += item.getProduto().getPreco() * item.getQuantidade();
		unidades += item.getQuantidade();
	}

	public List<Item> getItens() {
		return itens;
	}

	public Double getTotal() {
		return total;
	}

	public Integer getTotalDeItens(){
		return itens.size();
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}
	
	@Override
	public void remove(int indiceItem) {
		Item removido = itens.remove(indiceItem);
		total -= removido.getProduto().getPreco() * removido.getQuantidade();
		unidades -= removido.getQuantidade();
	}
	
	@Override
	public void destroy(){
		itens = new ArrayList<Item>();
		unidades = 0;
		total = 0.0;
	}
}