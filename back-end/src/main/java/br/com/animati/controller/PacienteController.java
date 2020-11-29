package br.com.animati.controller;

import br.com.animati.DAO.PacienteDAO;
import br.com.animati.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteDAO pacienteDAO;

    @GetMapping
    public List<Paciente> listar(){
        return pacienteDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable(value = "id") Long id){
        Optional<Paciente> paciente = pacienteDAO.findById(id);
        if(paciente.isPresent())
            return new ResponseEntity<Paciente>(paciente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrar(@RequestBody Paciente paciente){
        return pacienteDAO.save(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id ){
        Optional<Paciente> pacienteDelete = pacienteDAO.findById(id);
        if(pacienteDelete.isPresent()) {
            pacienteDAO.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualiza(@PathVariable(value = "id") long id, @RequestBody Paciente newPaciente){
        Optional<Paciente> paciente1 = pacienteDAO.findById(id);
        if(paciente1.isPresent()){
            Paciente paciente = paciente1.get();
            paciente.setNome(newPaciente.getNome());
            paciente.setSexo(newPaciente.getSexo());
            paciente.setRg(newPaciente.getRg());
            paciente.setPassword(newPaciente.getPassword());
            paciente.setCpf(newPaciente.getCpf());
            paciente.setNomeSocial(newPaciente.getNomeSocial());
            paciente.setEmpresa(newPaciente.getEmpresa());
            paciente.setNomeMae(newPaciente.getNomeMae());

            pacienteDAO.save(paciente);
            return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
