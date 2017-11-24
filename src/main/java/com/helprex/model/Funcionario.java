/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helprex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "funcionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findBycodigoInterno", query = "select func from Funcionario func where func.codigoInterno like :codigoInterno")
})
public class Funcionario extends Pessoa {

    @Column(unique = true, nullable = true, length = 3000)
    private String codigoInterno;

    public Funcionario() {
    }

    public Funcionario(String codigoInterno, String nome, String cpfcnpj) {
        super(nome, cpfcnpj);
        this.codigoInterno = codigoInterno;
    }

    @Override
    public void updateParameters(Object entity) {
        Funcionario outro = (Funcionario) entity;
        this.codigoInterno = outro.codigoInterno;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }
}
