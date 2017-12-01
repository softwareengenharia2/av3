package br.com.fean.si.es2.conf;

import br.com.fean.si.es2.bean.Cliente;
import br.com.fean.si.es2.controller.HomeController;
import br.com.fean.si.es2.controller.PreCadastroClienteController;
import br.com.fean.si.es2.business.PreCadastroClienteBusiness;
import br.com.fean.si.es2.dao.PreCadastroClienteDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, PreCadastroClienteBusiness.class, PreCadastroClienteDAO.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
