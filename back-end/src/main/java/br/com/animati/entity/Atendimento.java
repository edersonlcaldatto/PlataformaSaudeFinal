package br.com.animati.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Atendimento {

    @Id
    @GeneratedValue
    private long IdAtendimento;

    @CreationTimestamp
    private Date dataHora;

    private String nomeProcedimento;

    private String modalidade;

    @JoinColumn(name = "medico_id", nullable = false)
    @OneToOne
    private Medico medico;

    @JoinColumn(name = "paciente_id", nullable = false)
    @OneToOne
    private Paciente paciente;

}
