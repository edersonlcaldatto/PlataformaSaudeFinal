package br.com.animati.DAO;

import br.com.animati.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicoDAO extends JpaRepository<Medico, Long> {


}
