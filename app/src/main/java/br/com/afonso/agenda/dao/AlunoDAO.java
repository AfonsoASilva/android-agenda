package br.com.afonso.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

import java.util.ArrayList;
import java.util.List;

import br.com.afonso.agenda.modelo.Aluno;

/**
 * Created by afonso on 18/06/17.
 */

public class AlunoDAO extends SQLiteOpenHelper {

    private final String NOME_TABELA = "alunos";

    public AlunoDAO(Context context) {

        super(context, "agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+this.NOME_TABELA+" (" +
                "id INTEGER PRIMARY KEY," +
                "nome TEXT NOT NULL," +
                "endereco TEXT," +
                "telefone TEXT," +
                "site TEXT," +
                "nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1)
            System.out.println("Sem alterações na base de dados!");
    }

    public void insert(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contetAluno = new ContentValues();
        contetAluno.put("nome", aluno.getNome());
        contetAluno.put("endereco", aluno.getEndereco());
        contetAluno.put("telefone", aluno.getTelefone());
        contetAluno.put("site", aluno.getSite());
        contetAluno.put("nota", aluno.getNota());
        db.insert(this.NOME_TABELA, null, contetAluno);
    }

    public List<Aluno> getAll() {

        List<Aluno> alunos = new ArrayList<Aluno>();

        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from "+this.NOME_TABELA;
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext())
        {
            Aluno aluno = new Aluno();
            aluno.setId(c.getLong(c.getColumnIndex("id")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setEndereco(c.getString(c.getColumnIndex("endereco")));
            aluno.setTelefone(c.getString(c.getColumnIndex("telefone")));
            aluno.setSite(c.getString(c.getColumnIndex("site")));
            aluno.setNota(c.getDouble(c.getColumnIndex("nota")));
            alunos.add(aluno);
        }
        return alunos;
    }
}
