package com.example.agendamentotarefas.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.agendamentotarefas.R;
import com.example.agendamentotarefas.adapter.TarefaAdapter;
import com.example.agendamentotarefas.model.Tarefa;
import com.example.agendamentotarefas.viewModel.TarefaViewModel;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {
    private ListView listViewTarefas;
    private Button btnVoltarLista;
    private TarefaAdapter adapter;
    private ArrayList<Tarefa> tarefas;
    private TarefaViewModel tarefaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista);

        listViewTarefas = findViewById(R.id.listViewTarefas);
        btnVoltarLista = findViewById(R.id.btnVoltarLista);

        tarefas = new ArrayList<>();
        adapter = new TarefaAdapter(this, tarefas);
        listViewTarefas.setAdapter(adapter);
        tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);

        tarefaViewModel.getTarefasLiveData().observe(this, listaAtualizada -> {
            tarefas.clear();

            if (listaAtualizada != null) {
                tarefas.addAll(listaAtualizada);
            }

            adapter.notifyDataSetChanged();
        });


        btnVoltarLista.setOnClickListener(v -> {
            finish();
        });
        
    }

}
