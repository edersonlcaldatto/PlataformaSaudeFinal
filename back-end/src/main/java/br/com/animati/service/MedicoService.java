package br.com.animati.service;

import br.com.animati.entity.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoService {

    public void cadastrar(Medico medico);

    public void editar(Medico medico);

    public void deletar(long IdMedico) throws Exception;

    public List<Medico> listar();

    public Optional<Medico> findById(long IdMedico);

    public void limparLista();
}
