package com.example.appcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editNum1;
    EditText editNum2;
    Button btnResult;
    TextView result;
    TextView resultado;
    Spinner operacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        btnResult = findViewById(R.id.btnResult);
        operacoes = findViewById(R.id.operacoes);
        result = findViewById(R.id.result);
        btnResult.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        double num1 = Double.parseDouble(editNum1.getText().toString());
        double num2 = Double.parseDouble(editNum2.getText().toString());

        String operacoesmat = (String) operacoes.getSelectedItem();
        double resultado = 0;

        if (operacoesmat.equals("+")){
            resultado = num1 + num2;
        }
        if (operacoesmat.equals("-")){
            resultado = num1 - num2;
        }
        if (operacoesmat.equals("/")){
            resultado = num1 / num2;
        }
        if (operacoesmat.equals("X")){
            resultado = num1 * num2;
        }

        String resultadoString = Double.toString(resultado);
        result.setText(resultadoString);

    }
}