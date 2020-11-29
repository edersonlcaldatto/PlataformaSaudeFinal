package br.com.animati;

import br.com.animati.entity.Atendimento;
import br.com.animati.entity.Medico;
import br.com.animati.service.AtendimentoService;
import br.com.animati.service.AtendimentoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
@SpringBootTest
public class AtendimentoServiceImplTest {

    @Autowired
    private AtendimentoServiceImpl atendimentoService;

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

        this.atendimentoService.cadastrar(atendimento);

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

        this.atendimentoService.cadastrar(atendimento);

        String nomeProcedimento = "Radiografica";
        atendimento.setNomeProcedimento(nomeProcedimento);
        atendimentoService.editar(atendimento);

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

        this.atendimentoService.cadastrar(atendimento);
        try {
            this.atendimentoService.deletar(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    @Test
//    public void listar() {
//        for (int i = 1; i <= 5; i++) {
//            this.atendimentoService.cadastrar(new Atendimento(i, new Date(), "Mamografia", "SUS", null));
//        }
//
//    }

}
