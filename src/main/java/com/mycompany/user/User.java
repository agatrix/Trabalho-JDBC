package com.mycompany.user;

import com.mycompany.entity.Entity;
import java.time.LocalDateTime;

/**
 *
 * @author gusta
 */
public class User extends Entity{
    
    private String name;
    private String email;
    private String senha;
    private LocalDateTime ultimoAcesso; //Por ser um Objeto, inicia em NULL
    private boolean ativo = true;

    //Construtor Padrão
    public User(){}
    
    //Construtor Sobrecarregado
    public User(String name, String email, String senha, LocalDateTime ultimoAcesso) throws Exception {
        
        setName(name);
        setEmail(email);
        setSenha(senha);
        setUltimoAcesso(ultimoAcesso);
        if(this.ultimoAcesso == null)
            setAtivo(false);
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null)
            throw new IllegalArgumentException("Valor nulo");
        
        if(name.length()>150)
            throw new IllegalArgumentException("Tamanho Excedido");
        

        
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null)
            throw new IllegalArgumentException("Valor nulo");
        
        if(email.length()>255)
            throw new IllegalArgumentException("Tamanho Excedido");
               
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha == null)
            throw new IllegalArgumentException("Valor nulo");
        
        if(senha.length()>64)
            throw new IllegalArgumentException("Tamanho Excedido");
        
        this.senha = senha;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {        
        this.ultimoAcesso = ultimoAcesso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", senha=" + senha + ", ultimoAcesso=" + ultimoAcesso + ", ativo=" + ativo + '}';
    }
    
}
