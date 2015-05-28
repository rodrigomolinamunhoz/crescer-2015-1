package filmator;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import filmator.controller.AutorizadorInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AutorizadorInterceptor());
	}	

}
