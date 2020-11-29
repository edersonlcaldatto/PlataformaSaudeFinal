package br.com.animati.service;

import br.com.animati.DAO.MedicoDAO;
import br.com.animati.entity.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoDAO medicoDAO;

    @Override
    public void cadastrar(Medico Medico) {
        medicoDAO.save(Medico);
    }

    @Override
    public void editar(Medico Medico) {
        medicoDAO.save(Medico);
    }

    @Override
    public void deletar(long idMedico) throws Exception {
        medicoDAO.deleteById(idMedico);
    }

    @Override
    public List<Medico> listar() {
        return medicoDAO.findAll();
    }

    @Override
    public Optional<Medico> findById(long IdMedico) {
        return medicoDAO.findById(IdMedico);
    }

    @Override
    public void limparLista() {
        medicoDAO.deleteAll();
    }
}
