package com.example.agendamentotarefas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.agendamentotarefas.R;
import com.example.agendamentotarefas.model.Tarefa;

import java.util.ArrayList;

public class TarefaAdapter extends ArrayAdapter<Tarefa> {
    public TarefaAdapter(@NonNull Context context, ArrayList<Tarefa> tarefas) {
        super(context, 0, tarefas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tarefa tarefa = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_tarefa, parent, false);
        }

        TextView txtTituloItem = convertView.findViewById(R.id.txtTituloItem);
        TextView txtDetalhesItem = convertView.findViewById(R.id.txtDetalhesItem);

        if (tarefa!=null){
            txtTituloItem.setText(tarefa.getTitulo());
            String prioridade = tarefa.getPrioridade() ? "Prioritária" : "Normal";
            String detalhes = tarefa.getTipo() + " | " +
                    tarefa.getHorario() + " | " +
                    tarefa.getLocal() + " | " +
                    prioridade;
            txtDetalhesItem.setText(detalhes);
        }
        // aqui você preenche os textos

        return convertView;
    }
}
