/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "chamados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chamado.findBycodigo", query = "select ch from Chamado ch where ch.codigo like :codigo")
    ,
    @NamedQuery(name = "Chamado.findBytitulo", query = "select ch from Chamado ch where ch.titulo like :titulo")
})
public class Chamado extends AbstractEntity {

    @Column(unique = true, nullable = false, length = 3000)
    private String codigo;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechamento;

    @Column(length = 3000)
    private String solucao;

    @Column(nullable = false, length = 100)
    private String titulo;

    @ManyToOne
    private TipoChamado tipoChamado;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @ManyToOne
    private Pessoa pessoa;

    @OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL)
    private Set<Acao> acoes = new HashSet<>();

    public Chamado() {
    }

    public Chamado(String codigo) {
        this.codigo = codigo;
        this.status = Status.ABERTO;
    }

    public Chamado(String codigo, String titulo, Status status, Prioridade prioridade) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.status = status;
        this.prioridade = prioridade;
    }

    @Override
    public void updateParameters(Object entity) {
        Chamado outro = (Chamado) entity;
        this.codigo = outro.codigo;
        this.fechamento = outro.fechamento;
        this.solucao = outro.solucao;
        this.titulo = outro.titulo;
        this.tipoChamado = outro.tipoChamado;
        this.status = outro.status;
        this.prioridade = outro.prioridade;
        this.pessoa = outro.pessoa;
        this.acoes = outro.acoes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoChamado getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(TipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Set<Acao> getAcoes() {
        return acoes;
    }

    public void setAcoes(Set<Acao> acoes) {
        this.acoes = acoes;
    }

}
