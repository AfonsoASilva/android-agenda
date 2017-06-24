package br.com.afonso.agenda.controller;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.afonso.agenda.FormularioActivity;
import br.com.afonso.agenda.R;
import br.com.afonso.agenda.modelo.Aluno;

/**
 * Created by afonso on 18/06/17.
 */

public class FormularioHelper {

    private Aluno aluno;

    public FormularioHelper() {
    }

    public FormularioHelper(FormularioActivity formularioActivity) {
        this.aluno = new Aluno();
        this.aluno.setNome(((EditText) formularioActivity.findViewById(R.id.formulario_nome)).getText().toString());
        this.aluno.setEndereco(((EditText) formularioActivity.findViewById(R.id.formulario_endereco)).getText().toString());
        this.aluno.setSite(((EditText) formularioActivity.findViewById(R.id.formulario_site)).getText().toString());
        this.aluno.setTelefone(((EditText) formularioActivity.findViewById(R.id.formulario_telefone)).getText().toString());
        this.aluno.setNota(((RatingBar) formularioActivity.findViewById(R.id.formulario_nota)).getRating());
    }


    public Aluno GetAluno() {
        return this.aluno;
    }
}
