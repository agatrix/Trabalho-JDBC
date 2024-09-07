package com.mycompany.user;

import com.mycompany.entity.Entity;
import java.time.LocalDate;

/**
 *
 * @author gusta
 */
public class User extends Entity{
    
    private String name;
    private String email;
    private String senha;
    private LocalDate ultimoAcesso;
    private boolean ativo = true;

    public User(String name, String email, String senha, LocalDate ultimoAcesso) throws Exception {
        
        setName(name);
        setEmail(email);
        setSenha(senha);
        setUltimoAcesso(ultimoAcesso);
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception{
        if(name == null)
            throw new Exception("Valor nulo");
        
        if(name.length()>150)
            throw new Exception("Tamanho Excedido");
        

        
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email == null)
            throw new Exception("Valor nulo");
        
        if(email.length()>255)
            throw new Exception("Tamanho Excedido");
               
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {
        if(senha == null)
            throw new Exception("Valor nulo");
        
        if(senha.length()>64)
            throw new Exception("Tamanho Excedido");
        
        this.senha = senha;
    }

    public LocalDate getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDate ultimoAcesso) throws Exception {
        
        if(senha == null)
            throw new Exception("Valor nulo");
        
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
