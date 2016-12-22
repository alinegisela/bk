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
    
     public String toString(int valor) {
        if (valor == 1) {
            return "BAIXA";
        } else if (valor == 2) {
            return "MÉDIA";
        } else if (valor == 3){
            return "ALTA";
        }
        return "";
    }

    public PrioridadeEnum toEnum(String opcao) {
        if (opcao.equals("BAIXA")) {
            return PrioridadeEnum.BAIXA;
        } else if (opcao.equals("MÉDIA")) {
            return PrioridadeEnum.MÉDIA;
        } else if (opcao.equals("ALTA")) {
            return PrioridadeEnum.ALTA;
        }
        return null;
        
    }
}
