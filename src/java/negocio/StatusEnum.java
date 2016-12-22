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
public enum StatusEnum {
    EM_ANDAMENTO(1), CONCLUIDA(2);
    
    private final int valor;
	
	StatusEnum(int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor(){
		return valor;
	}
}
