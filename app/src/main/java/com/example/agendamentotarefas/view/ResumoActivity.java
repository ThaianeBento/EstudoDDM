package com.example.agendamentotarefas.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.agendamentotarefas.R;
import com.example.agendamentotarefas.viewModel.TarefaViewModel;

public class ResumoActivity extends AppCompatActivity {

    private TextView txtResumoTarefa;
    private TextView txtTarefasAnteriores;
    private Button btnVoltar;
    private Button btnVerLista;
    private TarefaViewModel tarefaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumoTarefa = findViewById(R.id.txtResumoTarefa);
        txtTarefasAnteriores = findViewById(R.id.txtTarefasAnteriores);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVerLista = findViewById(R.id.btnVerLista);
        tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);

        btnVerLista.setOnClickListener(v -> {
            Intent intent = new Intent(ResumoActivity.this, ListaActivity.class);
            startActivity(intent);
        });


        tarefaViewModel.getUltimaTarefa().observe(this, tarefa -> {
            if (tarefa != null) {
                String textoPrioridade = tarefa.getPrioridade() ? "Sim" : "Não";

                String resumo =
                        "Título: " + tarefa.getTitulo() + "\n\n" +
                                "Tipo: " + tarefa.getTipo() + "\n\n" +
                                "Horário: " + tarefa.getHorario() + "\n\n" +
                                "Local: " + tarefa.getLocal() + "\n\n" +
                                "Prioritária: " + textoPrioridade;

                txtResumoTarefa.setText(resumo);
            } else {
                txtResumoTarefa.setText("Nenhuma tarefa cadastrada.");
            }
        });

        btnVoltar.setOnClickListener(v -> {
            finish();
        });

        txtTarefasAnteriores.setText("1. Estudar Android - Estudo - 19:00 - Biblioteca\n\n2. Reunião - Trabalho - 14:00 - Escritório");
    }



}
