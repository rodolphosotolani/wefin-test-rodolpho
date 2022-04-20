package br.com.rts.wefin.test.wefintestrodolpho.entity;

import br.com.rts.wefin.test.wefintestrodolpho.enums.TipoIdentificadorEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String identificador;

    private TipoIdentificadorEnum tipoIdentificador;

}
