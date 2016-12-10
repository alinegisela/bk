/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Penguin
 */
public enum PrioridadeEnum {
    BAIXA(1), MÉDIA(2), ALTA(3);
    
    private int valor;
    
    PrioridadeEnum(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    
    
}
