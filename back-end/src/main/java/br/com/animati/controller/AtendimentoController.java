package br.com.animati.controller;

import br.com.animati.DAO.AtendimentoDAO;
import br.com.animati.entity.Atendimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoDAO atendimentoDAO;

    @GetMapping
    public List<Atendimento> listar(){
        return atendimentoDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> findById(@PathVariable(value = "id") Long id){
        Optional<Atendimento> atendimento = atendimentoDAO.findById(id);
        if(atendimento.isPresent())
            return new ResponseEntity<Atendimento>(atendimento.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atendimento cadastrar(@RequestBody Atendimento atendimento){
        return atendimentoDAO.save(atendimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id ){
        Optional<Atendimento> atendimentoDelete = atendimentoDAO.findById(id);
        if(atendimentoDelete.isPresent())
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> atualiza(@PathVariable(value = "id") long id, @RequestBody Atendimento newAtendimento){
        Optional<Atendimento> atendimento1 = atendimentoDAO.findById(id);
        if(atendimento1.isPresent()){
            Atendimento atendimento = atendimento1.get();
            atendimento.setNomeProcedimento(newAtendimento.getNomeProcedimento());
            atendimento.setMedico(newAtendimento.getMedico());
            atendimento.setModalidade(newAtendimento.getModalidade());
            atendimento.setDataHora(newAtendimento.getDataHora());
            atendimento.setPaciente(newAtendimento.getPaciente());

            atendimentoDAO.save(atendimento);
            return new ResponseEntity<Atendimento>(atendimento, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
