
import builders.DoacaoBuilder;
import builders.DoadorBuilder;
import controladores.DoadorControlador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import negocio.Doador;
import negocio.Instituicao;
import negocio.MaterialDoacao;
import negocio.StatusEnum;

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
                
        DoacaoBuilder bdoacao = new DoacaoBuilder();
        bdoacao.setCodigo(1);
        bdoacao.setDataDoacao(new Date());
        bdoacao.setDataVisita(new Date());
        bdoacao.setDoacao(new ArrayList<MaterialDoacao>());
        bdoacao.setDoador(new Doador());
        bdoacao.setInstituicao(new Instituicao());
        bdoacao.setStatus(StatusEnum.CONCLUIDA);
        
        DoadorBuilder b = new DoadorBuilder();
        b.setNome("a");
        b.setCpf("9977");
        b.setEmail("3");
        b.setEndereco("4");
        b.setTelefone("5");
        
        DoadorControlador c = new DoadorControlador();
        c.inserir(b.buid());
        /*List<Doador> t = c.recuperarTodos();
        for (Doador d : t) {
            System.out.println("O nome do baguhio é: " + d.getNome());
        }

        /*
         b.setNome("joana");
        b.setCpf("3");
        b.setEmail("3");
        b.setEndereco("4");
        b.setTelefone("5");
        c.inserir(b.buid());
         */
        

    }
}
