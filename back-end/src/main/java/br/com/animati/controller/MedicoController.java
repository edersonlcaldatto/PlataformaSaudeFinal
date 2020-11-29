package br.com.animati.controller;

import br.com.animati.DAO.MedicoDAO;
import br.com.animati.entity.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoDAO medicoDAO;

    @GetMapping
    public List<Medico> listar(){
        return medicoDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable(value = "id") Long id){
        Optional<Medico> medico = medicoDAO.findById(id);
        if(medico.isPresent())
            return new ResponseEntity<Medico>(medico.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico cadastrar(@RequestBody Medico medico){
        return medicoDAO.save(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id ){
        Optional<Medico> medicoDelete = medicoDAO.findById(id);
        if(medicoDelete.isPresent())
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualiza(@PathVariable(value = "id") long id, @RequestBody Medico newMedico){
        Optional<Medico> medico1 = medicoDAO.findById(id);
        if(medico1.isPresent()){
            Medico medico = medico1.get();
            medico.setNome(newMedico.getNome());
            medico.setUf(newMedico.getUf());
            medico.setCrm(newMedico.getCrm());

            medicoDAO.save(medico);
            return new ResponseEntity<Medico>(medico, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
