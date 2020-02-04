package br.com.qbrada.qbrada.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "evento")
public class Qbrada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String genero;

    @Column
    private String imagem;

    @Column
    private Date dataEvento;

    @Column
    private String horaInicio;

    @Column
    private String horaFim;

    @Column
    private String criador;

    @Column
    private String colaboradores;

    @Column
    private Boolean ativo;

    @Column
    private LocalDate dataCriacao;
}
