package br.com.animati.service;

import br.com.animati.entity.Atendimento;

import java.util.List;
import java.util.Optional;

public interface AtendimentoService {

    public void cadastrar(Atendimento atendimento);

    public void editar(Atendimento atendimento);

    public void deletar(long IdAtendimento) throws Exception;

    public List<Atendimento> listar();

    public Optional<Atendimento> findById(long IdAtendimento);

    public void limparLista();
}
