
import builders.DoacaoBuilder;
import builders.DoadorBuilder;
import builders.InstituicaoBuilder;
import builders.VisitaBuilder;
import controladores.DoacaoControlador;
import controladores.DoadorControlador;
import controladores.InstituicaoControlador;
import controladores.VisitaControlador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import negocio.Doador;
import negocio.Instituicao;
import negocio.Insumo;
import negocio.MaterialDoacao;
import negocio.PrioridadeEnum;
import negocio.StatusEnum;
import negocio.TipoEnum;

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

    public static void main(String[] args) throws ClassNotFoundException {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println(formato.format(new Date()));
        
        
        
        /*
        List<MaterialDoacao> materiais = new ArrayList<MaterialDoacao>();
         materiais.add(new MaterialDoacao(1, PrioridadeEnum.ALTA, new Insumo(1, "insumo", TipoEnum.ALIMENTO, "descrição")));

         System.out.println("aqui");
        DoadorBuilder b = new DoadorBuilder();
        b.setNome("a");
        b.setCpf("28");
        b.setEmail("3");
        b.setEndereco("4");
        b.setTelefone("5");
        DoadorControlador c = new DoadorControlador();
        c.inserir(b.build());

        InstituicaoBuilder ib = new InstituicaoBuilder();
        ib.setCnpj("82");
        ib.setDescricao("descrevendo");
        ib.setEmail("email");
        ib.setEndereco("endereco");
        ib.setNome("J");
        ib.setPrioridades(materiais);
        ib.setTel("tel");
        InstituicaoControlador ci = new InstituicaoControlador();
        ci.inserir(ib.build());

        DoacaoBuilder bdoacao = new DoacaoBuilder();
        bdoacao.setCodigo(82);
        bdoacao.setDataDoacao(new Date());
        bdoacao.setDataVisita(new Date());
        bdoacao.setDoacao(materiais);
        materiais.add(new MaterialDoacao(1, PrioridadeEnum.ALTA, new Insumo(1, "insumo", TipoEnum.ALIMENTO, "descrição")));
        bdoacao.setDoador(c.recuperar("9977"));
        bdoacao.setInstituicao(ci.recuperar("123"));
        bdoacao.setStatus(StatusEnum.CONCLUIDA);
        DoacaoControlador dc = new DoacaoControlador();
        dc.inserir(bdoacao.build());
        
        VisitaBuilder v = new VisitaBuilder();
        v.setCodigo(212);
        v.setData_da_visita(new Date());
        v.setDoador(c.recuperar("9977"));
        v.setHorario("hora");
        v.setInstituicao(ci.recuperar("123"));
        v.setStatus(StatusEnum.CONCLUIDA);
        VisitaControlador vc = new VisitaControlador();
        vc.inserir(v.build());
        
        System.out.println("terminou");
         */
        

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
