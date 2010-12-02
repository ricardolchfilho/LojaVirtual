package br.com.unifor.tcc.lojavirtal.infra;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.unifor.tcc.lojavirtal.model.EstoqueDeProdutos;
import br.com.unifor.tcc.lojavirtal.model.Produto;

import com.googlecode.objectify.Objectify;

@Component
public class ProdutoDao implements EstoqueDeProdutos {

	private final Objectify objectify;
	
	public ProdutoDao(Objectify objectify) {
		this.objectify = objectify;
	}

	@Override
	public void adicionarEditar(Produto produto) {
		objectify.put(produto);
	}

	@Override
	public List<Produto> todos() {
		return (List<Produto>) objectify.query(Produto.class).list();
	}

	@Override
	public Produto obter(Long codigo) {
		return objectify.query(Produto.class).filter("codigo", codigo).get();
	}

	@Override
	public void deletar(Long codigo) {
		objectify.delete(Produto.class, codigo);
	}

	@Override
	public List<Produto> obter(String nome) {
		return (List<Produto>) objectify.query(Produto.class)
				.filter("nome", nome).list();
	}

	@Override
	public void recarrega(Produto produto) {
		produto = obter(produto.getCodigo());
	}

}
