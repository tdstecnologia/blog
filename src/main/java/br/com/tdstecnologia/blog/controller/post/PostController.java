package br.com.tdstecnologia.blog.controller.post;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PostController implements Serializable{

    public void salvarPost() {
        System.out.println("Salvar Post");
    }

  
    
    public String flowIndex() {
        return "/index";
    }
    
    
}
