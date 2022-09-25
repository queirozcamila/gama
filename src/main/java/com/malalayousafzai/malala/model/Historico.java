package com.malalayousafzai.malala.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_visualizacao")
    private LocalDateTime dataVisualizacao = LocalDateTime.now();

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Cliente cliente;

    @OneToMany
    @JoinColumn
    private List<Video> videos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataVisualizacao() {
        return dataVisualizacao;
    }

    public void setDataVisualizacao(LocalDateTime dataVisualizacao) {
        this.dataVisualizacao = dataVisualizacao;
    }
}
