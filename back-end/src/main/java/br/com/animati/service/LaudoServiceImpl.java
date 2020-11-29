package br.com.animati.service;

import br.com.animati.DAO.LaudoDAO;
import br.com.animati.entity.Laudo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaudoServiceImpl implements LaudoService {

    @Autowired
    private LaudoDAO laudoDAO;

    @Override
    public void cadastrar(Laudo laudo) {
        laudoDAO.save(laudo);
    }

    @Override
    public void editar(Laudo laudo) {
        laudoDAO.save(laudo);
    }

    @Override
    public void deletar(long idLaudo) throws Exception {
        laudoDAO.deleteById(idLaudo);
    }

    @Override
    public List<Laudo> listar() {
        return laudoDAO.findAll();
    }

    @Override
    public Optional<Laudo> findById(long IdLaudo) {
        return laudoDAO.findById(IdLaudo);
    }

    @Override
    public void limparLista() {
        laudoDAO.deleteAll();
    }
}
