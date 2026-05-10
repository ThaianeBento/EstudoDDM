package com.example.agendamentotarefas.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendamentotarefas.R;

public class ResumoActivity extends AppCompatActivity {

    private TextView txtResumoTarefa;
    private TextView txtTarefasAnteriores;
    private Button btnVoltar;
    private Button btnVerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumoTarefa = findViewById(R.id.txtResumoTarefa);
        txtTarefasAnteriores = findViewById(R.id.txtTarefasAnteriores);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVerLista = findViewById(R.id.btnVerLista);

        btnVerLista.setOnClickListener(v -> {
            Intent intent = new Intent(ResumoActivity.this, ListaActivity.class);
            startActivity(intent);
        });

        //Receber valores de cadastro -> vem de putExtra
        String titulo = getIntent().getStringExtra("titulo");
        String tipo = getIntent().getStringExtra("tipo");
        String horario = getIntent().getStringExtra("horario");
        String local = getIntent().getStringExtra("local");
        boolean prioritaria = getIntent().getBooleanExtra("prioritaria", false);
        String textoPrioridade = prioritaria ? "Sim" : "Não";

        String resumo =
                "Título: " + titulo + "\n\n" +
                        "Tipo: " + tipo + "\n\n" +
                        "Horário: " + horario + "\n\n" +
                        "Local: " + local + "\n\n" +
                        "Prioritária: " + textoPrioridade;

        btnVoltar.setOnClickListener(v -> {
            finish();
        });

        txtResumoTarefa.setText(resumo);
        txtTarefasAnteriores.setText("1. Estudar Android - Estudo - 19:00 - Biblioteca\n\n2. Reunião - Trabalho - 14:00 - Escritório");
    }



}
