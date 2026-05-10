package com.example.agendamentotarefas.data;

import com.example.agendamentotarefas.model.Tarefa;

import java.util.ArrayList;

public class TarefaRepository {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    public static void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }
    public static ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
}
