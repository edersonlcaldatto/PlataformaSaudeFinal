package br.com.animati.service;

import br.com.animati.DAO.PacienteDAO;
import br.com.animati.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteDAO pacienteDAO;

    @Override
    public void cadastrar(Paciente paciente) {
        pacienteDAO.save(paciente);
    }

    @Override
    public void editar(Paciente paciente) {
        pacienteDAO.save(paciente);
    }

    @Override
    public void deletar(long IdPaciente) throws Exception {
        pacienteDAO.deleteById(IdPaciente);
    }

    @Override
    public List<Paciente> listar() {
        return pacienteDAO.findAll();
    }

    @Override
    public Optional<Paciente> findById(long idPaciente) {
        return pacienteDAO.findById(idPaciente);
    }

    @Override
    public void limparLista() {
        pacienteDAO.deleteAll();
    }
}
