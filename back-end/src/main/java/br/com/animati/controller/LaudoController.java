package br.com.animati.controller;

import br.com.animati.DAO.LaudoDAO;
import br.com.animati.entity.Laudo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/laudos")
public class LaudoController {

    @Autowired
    private LaudoDAO laudoDAO;

    @GetMapping
    public List<Laudo> listar(){
        return laudoDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laudo> findById(@PathVariable(value = "id") Long id){
        Optional<Laudo> laudo = laudoDAO.findById(id);
        if(laudo.isPresent())
            return new ResponseEntity<Laudo>(laudo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Laudo cadastrar(@RequestBody Laudo laudo){
        return laudoDAO.save(laudo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id ){
        Optional<Laudo> laudoDelete = laudoDAO.findById(id);
        if(laudoDelete.isPresent())
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Laudo> atualiza(@PathVariable(value = "id") long id, @RequestBody Laudo newLaudo){
        Optional<Laudo> laudo1 = laudoDAO.findById(id);
        if(laudo1.isPresent()){
            Laudo laudo = laudo1.get();
            laudo.setTexto(newLaudo.getTexto());
            laudo.setMedico(newLaudo.getMedico());
            laudo.setAtendimento(newLaudo.getAtendimento());
            laudoDAO.save(laudo);
            return new ResponseEntity<Laudo>(laudo, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
