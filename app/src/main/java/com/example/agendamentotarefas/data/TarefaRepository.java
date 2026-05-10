package com.example.agendamentotarefas.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.agendamentotarefas.model.Tarefa;

import java.util.ArrayList;

public class TarefaRepository {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    private static MutableLiveData<ArrayList<Tarefa>> tarefasLiveData  =
            new MutableLiveData<>(new ArrayList<>());
    private static MutableLiveData<Tarefa> ultimaTarefaLiveData =
            new MutableLiveData<>();
    public static void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        ultimaTarefaLiveData.setValue(tarefa);
        tarefasLiveData.setValue(new ArrayList<>(tarefas));
    }
    public static ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public static LiveData<ArrayList<Tarefa>> getTarefasLiveData() {
        return tarefasLiveData;
    }

    public static LiveData<Tarefa> getUltimaTarefa() {
        return ultimaTarefaLiveData;
    }

}
