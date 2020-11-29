package br.com.animati;

import br.com.animati.entity.Atendimento;
import br.com.animati.entity.Laudo;
import br.com.animati.entity.Medico;
import br.com.animati.service.LaudoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;

public class LaudoServiceImplTest {


    @Autowired
    private LaudoServiceImpl laudoService;

    @Test
    public void cadastrar() {
        Medico medico1 = new Medico();
        medico1.setIdMedico(1);
        medico1.setNome("Joao");
        medico1.setCrm("787878");
        medico1.setUf("PR");

        Atendimento atendimento = new Atendimento();
        atendimento.setIdAtendimento(1);
        atendimento.setDataHora(new Date());
        atendimento.setModalidade("Nao sei o que é");
        atendimento.setNomeProcedimento("Mamografia");
        atendimento.setMedico(medico1);

        Laudo laudo = new Laudo();
        laudo.setIdLaudo(1);
        laudo.setTexto("Tudo certo");
        laudo.setAtendimento(atendimento);
        laudo.setMedico(medico1);

        this.laudoService.cadastrar(laudo);
    }

    @Test
    public void editar() {

        Medico medico1 = new Medico();
        medico1.setIdMedico(1);
        medico1.setNome("Joao");
        medico1.setCrm("787878");
        medico1.setUf("PR");

        Atendimento atendimento = new Atendimento();
        atendimento.setIdAtendimento(1);
        atendimento.setDataHora(new Date());
        atendimento.setModalidade("Nao sei o que é");
        atendimento.setNomeProcedimento("Mamografia");
        atendimento.setMedico(medico1);

        Laudo laudo = new Laudo();
        laudo.setIdLaudo(1);
        laudo.setTexto("Tudo certo");
        laudo.setAtendimento(atendimento);
        laudo.setMedico(medico1);

        this.laudoService.cadastrar(laudo);

        String texto = "Novo texto";
        laudo.setTexto(texto);
        laudoService.editar(laudo);

    }

    @Test
    public void deletar() {

        Medico medico1 = new Medico();
        medico1.setIdMedico(1);
        medico1.setNome("Joao");
        medico1.setCrm("787878");
        medico1.setUf("PR");

        Atendimento atendimento = new Atendimento();
        atendimento.setIdAtendimento(1);
        atendimento.setDataHora(new Date());
        atendimento.setModalidade("Nao sei o que é");
        atendimento.setNomeProcedimento("Mamografia");
        atendimento.setMedico(medico1);

        Laudo laudo = new Laudo();
        laudo.setIdLaudo(1);
        laudo.setTexto("Tudo certo");
        laudo.setAtendimento(atendimento);
        laudo.setMedico(medico1);

        this.laudoService.cadastrar(laudo);
        try {
            this.laudoService.deletar(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    @Test
//    public void listar() {
//        for (int i = 1; i <= 5; i++) {
//            this.laudoService.cadastrar(new Laudo(i, "Valor de I = " + i, null, null));
//        }
//    }

}
