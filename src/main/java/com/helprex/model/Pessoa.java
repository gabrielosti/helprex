/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "pessoas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findByNome", query = "select pes from Pessoa pes where pes.nome like :nome"),
    @NamedQuery(name = "Pessoa.findByCpfCnpj", query = "select pes from Pessoa pes where pes.cpfcnpj like :cpfcnpj"),
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends AbstractEntity {

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true, unique = true)
    private String cpfcnpj;

    @OneToMany(mappedBy = "pessoa")
    private Set<Chamado> chamados;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpfcnpj) {
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
    }

    @Override
    public void updateParameters(Object entity) {
        Pessoa outro = (Pessoa) entity;
        this.nome = outro.nome;
        this.cpfcnpj = outro.cpfcnpj;
        this.chamados = outro.chamados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    @XmlTransient
    public Set<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(Set<Chamado> chamados) {
        this.chamados = chamados;
    }

}
