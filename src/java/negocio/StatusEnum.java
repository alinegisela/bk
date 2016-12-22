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

    StatusEnum(int valorOpcao) {
        valor = valorOpcao;
    }

    public int getValor() {
        return valor;
    }

    public String toString(int valor) {
        if (valor == 1) {
            return "EM_ANDAMENTO";
        } else if (valor == 2) {
            return "CONCLUIDA";
        }
        return "";
    }

    public StatusEnum toEnum(String opcao) {
        if (opcao.equals("EM_ANDAMENTO")) {
            return StatusEnum.EM_ANDAMENTO;
        } else if (opcao.equals("CONCLUIDA")) {
            return StatusEnum.CONCLUIDA;
        }
        return null;
    }

}
