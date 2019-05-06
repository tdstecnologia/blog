package br.com.tdstecnologia.blog.features.security.http;

import br.com.tdstecnologia.blog.features.exceptions.UsuarioNaoLogadoException;
import br.com.tdstecnologia.blog.features.security.ControleAcesso;
import java.io.IOException;
import javax.faces.application.ViewExpiredException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(servletNames = {"Faces Servlet"})
public class HttpFiltroAcesso implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HttpFiltroAcesso->init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        try {
            if (request.getRequestURI().contains(".css") || request.getRequestURI().contains(".js")) {

            } else {
                System.out.println("URI: " + request.getRequestURI());
                System.out.println("URL: " + request.getRequestURL());
            }

            if (ControleAcesso.validarAcessoEmPaginaRestrita(request.getRequestURI())) {
                if (!ControleAcesso.isUsuarioLogado(request.getSession(false))) {
                    throw new UsuarioNaoLogadoException();
                }
            } else if (request.getRequestURI().contains("logout.xhtml")) {
                throw new UsuarioNaoLogadoException();
            }

            chain.doFilter(request, response);
        } catch (ViewExpiredException e) {
            request.setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error.xhtml?faces-redirect=true");
        } catch (UsuarioNaoLogadoException e) {
            System.out.println(e.getMessage());
            ControleAcesso.logout(request.getSession(false));
            request.setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/login.xhtml?faces-redirect=true");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error.xhtml?faces-redirect=true");
        }
    }

    @Override
    public void destroy() {
        System.out.println("HttpFiltroAcesso->destroy");
    }

}
