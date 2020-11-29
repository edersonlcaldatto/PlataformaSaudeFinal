package br.com.animati;

import br.com.animati.entity.Medico;
import br.com.animati.service.MedicoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicoServiceImplTest {

    @Autowired
    private MedicoServiceImpl medicoService;


    @Test
    public void cadastrar() {
        Medico medico1 = new Medico();
        medico1.setIdMedico(1);
        medico1.setNome("Joao");
        medico1.setCrm("787878");
        medico1.setUf("PR");

        this.medicoService.cadastrar(medico1);
    }

    @Test
    public void editar() {

        Medico medico1 = new Medico();
        medico1.setIdMedico(1);
        medico1.setNome("Joao");
        medico1.setCrm("787878");
        medico1.setUf("PR");

        Medico medico2 = new Medico();
        medico2.setIdMedico(2);
        medico2.setNome("Pedro");
        medico2.setCrm("9999999");
        medico2.setUf("SC");

        this.medicoService.cadastrar(medico1);
        this.medicoService.cadastrar(medico2);

        String nomeNovo = "Pedro 2";
        medico2.setNome(nomeNovo);

        this.medicoService.editar(medico2);
    }

    @Test
    public void deletar() {

        Medico medico1 = new Medico();
        medico1.setIdMedico(1);
        medico1.setNome("Joao");
        medico1.setCrm("787878");
        medico1.setUf("PR");

        this.medicoService.cadastrar(medico1);
        try {
            this.medicoService.deletar(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listar() {
        for (int i = 1; i <= 5; i++) {
            this.medicoService.cadastrar(new Medico(i, "Medico" + i, "PR", "123" + i));
        }
    }

}
