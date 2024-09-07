package com.mycompany.entity;

/**
 * Classe criada para ser base, fazendo com que todos nossos 
 * objetos obrigatoriamente tenha id.
 * @author gusta
 */
public abstract class Entity {
    
    private long id;
    private boolean excluido; //Utilizado para marcar item na lixeira

    //<editor-fold defaultstate="collapsed" desc="get/set">
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }
    
    //</editor-fold>
    
}
