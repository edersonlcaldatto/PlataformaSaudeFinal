package br.com.animati.DAO;

import br.com.animati.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoDAO extends JpaRepository<Atendimento, Long> {

}
