package com.example.agendamentotarefas.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agendamentotarefas.R;
import com.example.agendamentotarefas.data.TarefaRepository;
import com.example.agendamentotarefas.model.Tarefa;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTitulo;
    private Spinner spinnerTipo;
    private CheckBox checkPrioritaria;
    private TimePicker timePickerHorario;
    private AutoCompleteTextView autoLocal;
    private ProgressBar progressBar;
    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        editTitulo = findViewById(R.id.editTitulo);
        spinnerTipo = findViewById(R.id.spinnerTipo);
        checkPrioritaria = findViewById(R.id.checkPrioritaria);
        timePickerHorario = findViewById(R.id.timePickerHorario);
        autoLocal = findViewById(R.id.autoLocal);
        progressBar = findViewById(R.id.progressBar);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        String[] tipos = {"Trabalho", "Estudo", "Lazer", "Outro"};

        ArrayAdapter<String> adapterTipos = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                tipos
        );
        adapterTipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(adapterTipos);

        String[] locais={"Casa","Escritório","Biblioteca","Academia"};
        ArrayAdapter<String> adapterLocais = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                locais
        );
        adapterLocais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        autoLocal.setAdapter(adapterLocais);
        autoLocal.setThreshold(1);

        btnConfirmar.setOnClickListener(v -> {
            String titulo = editTitulo.getText().toString().trim();
            String tipo = spinnerTipo.getSelectedItem().toString();
            boolean prioritaria = checkPrioritaria.isChecked();
            String local = autoLocal.getText().toString().trim();
            int hora = timePickerHorario.getHour();
            int minuto = timePickerHorario.getMinute();
            String horario = hora + ":" + minuto;

            if (titulo.isEmpty()){
                editTitulo.setError("Informe o título da tarefa");
                return;
            }

            if (local.isEmpty()) {
                autoLocal.setError("Informe o local da tarefa");
                return;
            }

            Tarefa tarefa = new Tarefa();

            tarefa.setTitulo(titulo);
            tarefa.setTipo(tipo);
            tarefa.setHorario(horario);
            tarefa.setLocal(local);
            tarefa.setPrioridade(prioritaria);

            TarefaRepository.adicionarTarefa(tarefa);

            Intent intent = new Intent(CadastroActivity.this, ResumoActivity.class);

            intent.putExtra("titulo", titulo);
            intent.putExtra("tipo", tipo);
            intent.putExtra("horario", horario);
            intent.putExtra("local", local);
            intent.putExtra("prioritaria", prioritaria);

            progressBar.setVisibility(View.VISIBLE);
            btnConfirmar.setEnabled(false);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                startActivity(intent);

                progressBar.setVisibility(View.GONE);
                btnConfirmar.setEnabled(true);
            }, 1000);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}
