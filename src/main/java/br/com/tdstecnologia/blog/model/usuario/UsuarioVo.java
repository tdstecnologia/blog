package br.com.tdstecnologia.blog.model.usuario;

import br.com.tdstecnologia.blog.model.abstracts.AbstractVo;
import java.util.Date;
import java.util.Objects;

public class UsuarioVo extends AbstractVo<UsuarioVo>{
    
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Boolean ativo;
    private Date dataCriacao;
    private Date dataAtivacao;
    private String tokenAtivacao;
    private Date dataCriacaoToken;

    public UsuarioVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(Date dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public String getTokenAtivacao() {
        return tokenAtivacao;
    }

    public void setTokenAtivacao(String tokenAtivacao) {
        this.tokenAtivacao = tokenAtivacao;
    }

    public Date getDataCriacaoToken() {
        return dataCriacaoToken;
    }

    public void setDataCriacaoToken(Date dataCriacaoToken) {
        this.dataCriacaoToken = dataCriacaoToken;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioVo other = (UsuarioVo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
