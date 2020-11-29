package br.com.animati.DAO;

import br.com.animati.entity.Laudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LaudoDAO extends JpaRepository<Laudo, Long> {


}
