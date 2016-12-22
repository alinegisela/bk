
import builders.DoadorBuilder;
import controladores.DoadorControlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Penguin
 */
public class Main {

    public static void main(String[] args) {
        DoadorBuilder b = new DoadorBuilder();
        b.setNome("1");
        b.setCpf("2");
        b.setEmail("3");
        b.setEndereco("4");
        b.setTelefone("5");
        
        DoadorControlador c = new DoadorControlador();
        c.inserir(b.buid());
        
        System.out.println("Pronto porra");
        
    }
}
