package com.example.agendamentotarefas.view;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendamentotarefas.R;

public class ResumoActivity extends AppCompatActivity {

    private TextView txtResumoTarefa;
    private TextView txtTarefasAnteriores;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumoTarefa = findViewById(R.id.txtResumoTarefa);
        txtTarefasAnteriores = findViewById(R.id.txtTarefasAnteriores);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(v -> {
            finish();
        });
        txtResumoTarefa.setText("Resumo da tarefa aparecerá aqui.");
        txtTarefasAnteriores.setText("1. Estudar Android - Estudo - 19:00 - Biblioteca\n\n2. Reunião - Trabalho - 14:00 - Escritório");
    }



}
