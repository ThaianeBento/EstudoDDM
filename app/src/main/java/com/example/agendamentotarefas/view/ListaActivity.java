package com.example.agendamentotarefas.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendamentotarefas.R;
import com.example.agendamentotarefas.adapter.TarefaAdapter;
import com.example.agendamentotarefas.data.TarefaRepository;
import com.example.agendamentotarefas.model.Tarefa;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {
    private ListView listViewTarefas;
    private Button btnVoltarLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista);

        listViewTarefas = findViewById(R.id.listViewTarefas);
        btnVoltarLista = findViewById(R.id.btnVoltarLista);

        ArrayList<Tarefa> tarefas = TarefaRepository.getTarefas();
        TarefaAdapter adapter = new TarefaAdapter(this, tarefas);
        listViewTarefas.setAdapter(adapter);

        btnVoltarLista.setOnClickListener(v -> {
            finish();
        });
        
    }

}
