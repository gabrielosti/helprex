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
import javax.persistence.ManyToOne;
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
@Table(name = "acoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acao.findBytexto", query = "select acao from Acao acao where acao.texto like :texto")
})
public class Acao extends AbstractEntity {

    @Column(length = 3000, nullable = true)
    private String texto;

    @ManyToOne
    private Chamado chamado;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Acao raiz;

    @OneToMany(mappedBy = "raiz", cascade = CascadeType.ALL)
    private Set<Acao> reacoes = new HashSet<>();

    public Acao() {
    }

    public Acao(String texto, Chamado chamado, Pessoa pessoa) {
        this.texto = texto;
        this.chamado = chamado;
        this.pessoa = pessoa;
    }

    @Override
    public void updateParameters(Object entity) {
        Acao outro = (Acao) entity;
        this.texto = outro.texto;
        this.chamado = outro.chamado;
        this.pessoa = outro.pessoa;
        this.raiz = outro.raiz;
        this.reacoes = outro.reacoes;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @XmlTransient
    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @XmlTransient
    public Acao getRaiz() {
        return raiz;
    }

    public void setRaiz(Acao raiz) {
        this.raiz = raiz;
    }

    public Set<Acao> getReacoes() {
        return reacoes;
    }

    public void setReacoes(Set<Acao> reacoes) {
        this.reacoes = reacoes;
    }

}
