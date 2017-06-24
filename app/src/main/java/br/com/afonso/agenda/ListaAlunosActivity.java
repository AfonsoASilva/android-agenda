package br.com.afonso.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

import br.com.afonso.agenda.dao.AlunoDAO;
import br.com.afonso.agenda.modelo.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        Button btnNovo = (Button)findViewById(R.id.lista_novo);
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formularioIntent = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                ListaAlunosActivity.this.startActivity(formularioIntent);
            }
        });

    }

    @Override
    protected void onResume() {
        AlunoDAO alunoDAO = new AlunoDAO(this);
        List<Aluno> alunos = alunoDAO.getAll();
        alunoDAO.close();

        Collections.sort(alunos);

        final ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);

        listaAlunos.setAdapter(adapter);
        super.onResume();
    }
}
