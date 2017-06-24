package br.com.afonso.agenda.modelo;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by afonso on 18/06/17.
 */

public class Aluno implements Comparable<Aluno> {

    private long id;
    private String nome;
    private  String endereco;
    private String telefone;
    private String site;
    private  double nota;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public int compareTo(Aluno aluno) {
        return this.getNome().compareTo(aluno.getNome());
    }
}
