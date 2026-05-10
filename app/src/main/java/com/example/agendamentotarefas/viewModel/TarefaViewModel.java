package com.example.agendamentotarefas.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.agendamentotarefas.data.TarefaRepository;
import com.example.agendamentotarefas.model.Tarefa;

import java.util.ArrayList;

public class TarefaViewModel extends ViewModel {

    public void adicionarTarefa(Tarefa tarefa){
        TarefaRepository.adicionarTarefa(tarefa);
    }

    public LiveData<ArrayList<Tarefa>> getTarefasLiveData() {
        return TarefaRepository.getTarefasLiveData();
    }

    public LiveData<Tarefa> getUltimaTarefa() {
        return TarefaRepository.getUltimaTarefa();
    }

}
