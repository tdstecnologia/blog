package br.com.tdstecnologia.blog.model.usuario;

import br.com.tdstecnologia.blog.model.abstracts.AbstractVo;
import br.com.tdstecnologia.blog.model.post.PostVo;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb02_usuario")
public class UsuarioVo extends AbstractVo<UsuarioVo> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "data_ativacao")
    private Date dataAtivacao;

    @Column(name = "token_ativacao")
    private String tokenAtivacao;

    @Column(name = "data_criacao_token")
    private Date dataCriacaoToken;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostVo> posts;

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

    public List<PostVo> getPosts() {
        return posts;
    }

    public void setPosts(List<PostVo> posts) {
        this.posts = posts;
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
