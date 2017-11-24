/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "tiposchamados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoChamado.findByNome", query = "select tc from TipoChamado tc where tc.nome like :nome")
})
public class TipoChamado extends AbstractEntity {

    @Column(length = 255, nullable = false, unique = true)
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tiposchamado_funcionarios")
    private Set<Funcionario> funcionarios = new HashSet<>();

    public TipoChamado() {
    }

    public TipoChamado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public void updateParameters(Object entity) {
        TipoChamado outro = (TipoChamado) entity;
        this.nome = outro.nome;
        this.funcionarios = outro.funcionarios;
    }

}
