package br.com.unifor.tcc.lojavirtal.controller;

import br.com.caelum.vraptor.Resource;

@Resource
public class AdminController {

//	private final EstoqueDeProdutos estoque;
//	private final Result result;
//	private final Validator validator;
//	private final UserService userService;
//
//	public AdminController(EstoqueDeProdutos estoque, Result result,
//			Validator validator, UserService userService) {
//		this.estoque = estoque;
//		this.result = result;
//		this.validator = validator;
//		this.userService = userService;
//	}
//	
//	public List<Produto> busca(String nome){
//		return estoque.obter(nome);
//	}
//	
//	@Get
//	@Path("/admin/produtos/novo")
//	public void adicionarProduto() {
//		result.include("user", userService.getCurrentUser()).include(
//				"logoutUrl", userService.createLogoutURL("/"));
//	}
//
//	@Post
//	@Path("/admin/produtos")
//	public void adicionarProduto(final Produto produto) {
//		validar(produto);
//		validator.onErrorUsePageOf(AdminController.class).adicionarProduto();
//		estoque.adicionarEditar(produto);
//		result.include("aviso", produto.getNome() + " adicionado com sucesso!")
//				.redirectTo(getClass()).index();
//	}
//
//	@Delete
//	@Path("/admin/produtos/{codigo}")
//	public void deletarProduto(Long codigo) {
//		estoque.deletar(codigo);
//		result.include("aviso", "Produto deletado com sucesso!")
//				.forwardTo(getClass()).index();
//	}
//
//	@Get
//	@Path("/admin/produtos/{codigo}")
//	public Produto editarProduto(Long codigo) {
//		result.include("user", userService.getCurrentUser()).include(
//				"logoutUrl", userService.createLogoutURL("/"));
//		return estoque.obter(codigo);
//	}
//
//	@Put
//	@Path("/admin/produtos/{produto.codigo}")
//	public void editarProduto(Produto produto) {
//		validar(produto);
//		validator.onErrorUsePageOf(AdminController.class).editarProduto(
//				produto.getCodigo());
//		estoque.adicionarEditar(produto);
//		result.include("aviso", produto.getNome() + " alterado com sucesso!")
//				.redirectTo(getClass()).index();
//	}
//
//	@Get
//	@Path("/")
//	public void index() {
//		result.include("produtos", estoque.todos())
//				.include("user", userService.getCurrentUser())
//				.include("logoutUrl", userService.createLogoutURL("/"));
//	}
//
//	private void validar(final Produto produto) {
//		validator.checking(new Validations() {
//
//			{
//				that(produto.getNome() != null
//						&& produto.getNome().length() >= 3, "produto.nome",
//						"nome.obrigatorio");
//				that(produto.getDescricao() != null
//						&& (produto.getDescricao().length() > 0 && produto
//								.getDescricao().length() <= 40),
//						"produto.descricao", "descricao.obrigatoria");
//				that(produto.getPreco() != null && produto.getPreco() > 0.0,
//						"produto.preco", "preco.positivo");
//			}
//
//		});
//	}

}
