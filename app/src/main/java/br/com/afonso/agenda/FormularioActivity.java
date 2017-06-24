package br.com.afonso.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.afonso.agenda.controller.FormularioHelper;
import br.com.afonso.agenda.dao.AlunoDAO;
import br.com.afonso.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper formularioHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                this.salvar();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void salvar() {
        this.formularioHelper = new FormularioHelper(this);
        Aluno aluno = this.formularioHelper.GetAluno();
        AlunoDAO alunoDAO = new AlunoDAO(this);
        alunoDAO.insert(aluno);
        alunoDAO.close();
        String mensagem = "Aluno "+aluno.getNome()+" Salvo!";
        finish();
        Toast.makeText(FormularioActivity.this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
