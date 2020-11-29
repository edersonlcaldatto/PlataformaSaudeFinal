package br.com.animati.service;

import br.com.animati.entity.Medico;
import br.com.animati.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {


    public void cadastrar(Paciente paciente);

    public void editar(Paciente paciente);

    public void deletar(long IdPaciente) throws Exception;

    public List<Paciente> listar();

    public Optional<Paciente> findById(long IdPaciente);

    public void limparLista();


}
