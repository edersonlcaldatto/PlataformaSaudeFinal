package br.com.animati.service;

import br.com.animati.DAO.AtendimentoDAO;
import br.com.animati.entity.Atendimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoServiceImpl implements AtendimentoService {

    @Autowired
    private AtendimentoDAO atendimentoDAO;

    @Override
    public void cadastrar(Atendimento atendimento) {
        atendimentoDAO.save(atendimento);
    }

    @Override
    public void editar(Atendimento atendimento) {
        atendimentoDAO.save(atendimento);
    }

    @Override
    public void deletar(long IdAtendimento) throws Exception {
        atendimentoDAO.deleteById(IdAtendimento);
    }

    @Override
    public List<Atendimento> listar() {
        return atendimentoDAO.findAll();
    }

    @Override
    public Optional<Atendimento> findById(long IdAtendimento) {

        return atendimentoDAO.findById(IdAtendimento);
    }

    @Override
    public void limparLista() {
        atendimentoDAO.deleteAll();
    }
}
