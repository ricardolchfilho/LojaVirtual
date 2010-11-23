package br.com.unifor.tcc.lojavirtal.infra;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.unifor.tcc.lojavirtal.model.Categoria;
import br.com.unifor.tcc.lojavirtal.model.EstoqueDeProdutos;
import br.com.unifor.tcc.lojavirtal.model.Produto;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

@Component
public class ProdutoDao implements EstoqueDeProdutos {
	
	private final Objectify objectify;

	public ProdutoDao(Objectify objectify) {
		this.objectify = objectify;
	}
	
	@Override
	public void adicionar(Produto produto) {
		objectify.put(produto);
	}
	
	@Override
	public List<Produto> produtosAVenda() {
		return (List<Produto>) objectify.query(Produto.class).filter("vendido", false).list();
	}

	@Override
	public List<Produto> todos() {
		return (List<Produto>) objectify.query(Produto.class).list();
	}

	@Override
	public List<Produto> daCategoria(Categoria categoria) {
		return objectify.query(Produto.class).filter("categoriaKey", new Key<Categoria>(Categoria.class, categoria.getCodigo())).list();
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
	public Produto editar(Produto produto) {
		// TODO Auto-generated method stub
//		objectify.
		return null;
	}

}
