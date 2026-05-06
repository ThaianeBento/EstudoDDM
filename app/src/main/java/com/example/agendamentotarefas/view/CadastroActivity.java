package com.example.agendamentotarefas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

            Toast.makeText(this, titulo + " - " + tipo + " - " + horario + " - " + local, Toast.LENGTH_LONG).show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}
