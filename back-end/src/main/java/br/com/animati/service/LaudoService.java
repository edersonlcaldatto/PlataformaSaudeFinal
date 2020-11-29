package br.com.animati.service;

import br.com.animati.entity.Laudo;

import java.util.List;
import java.util.Optional;

public interface LaudoService {

    public void cadastrar(Laudo laudo);

    public void editar(Laudo laudo);

    public void deletar(long IdLaudo) throws Exception;

    public List<Laudo> listar();

    public Optional<Laudo> findById(long IdLaudo);

    public void limparLista();
}
