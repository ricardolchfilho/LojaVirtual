package br.com.unifor.tcc.lojavirtal.interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

import com.google.appengine.api.users.UserService;

@Intercepts
public class AuthorizationInterceptor implements Interceptor {

	private final UserService userService;

	private final Result result;

	public AuthorizationInterceptor(UserService userService, Result result) {
		this.userService = userService;
		this.result = result;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		if (!userService.isUserLoggedIn()
				|| method.containsAnnotation(Restrito.class)) {
			return true;
		}

		return false;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object object) throws InterceptionException {

		if (method.containsAnnotation(Restrito.class)) {
			if (userService.isUserAdmin()) {
				stack.next(method, object);
			} else {
				result.include("userService", userService)
						.include("acessoRestrito", true)
						.forwardTo("/WEB-INF/jsp/produtos/lista.jsp");
			}
		} else {
			stack.next(method, object);
		}
	}

}
