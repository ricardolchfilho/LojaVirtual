package br.com.unifor.tcc.lojavirtal.interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;

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
		return !method.containsAnnotation(Public.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object object) throws InterceptionException {
		
		try {
			userService.isUserAdmin();
			stack.next(method, object);
		} catch (IllegalStateException e) {
			String loginUrl = userService.createLoginURL("/admin");
			result.use(Results.page()).redirect(loginUrl);
		}
	}
	
}
