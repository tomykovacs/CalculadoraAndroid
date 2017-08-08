package com.example.tomy.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Double num1 = 0.0;
    Double num2 = 0.0;
    Double resultado = 0.0;
    Boolean auxResultado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButtonClear (View view) {
        TextView textView = (TextView) findViewById(R.id.textViewResultado);
        textView.setText("0");
    }

    public void onClick (View view) {
        Button button = (Button) findViewById(view.getId());
        TextView textView = (TextView) findViewById(R.id.textViewResultado);
        if(textView.getText().equals("0") || textView.getText().equals("") || auxResultado){
            textView.setText(button.getText());
            auxResultado = false;
        } else {
            String aux = textView.getText().toString();
            aux += button.getText().toString();
            textView.setText(aux);
        }
    }

    public void onClickButtonComa (View view) {
        Button button = (Button) findViewById(R.id.buttonComa);
        TextView textView = (TextView) findViewById(R.id.textViewResultado);
        if(textView.getText().equals("0") || textView.getText().equals("") || auxResultado){
            textView.setText(button.getText());
            auxResultado = false;
        } else {
            String aux = textView.getText().toString();
            aux += button.getText().toString();
            textView.setText(aux);
        }
    }

    public void onClickButtonOperador (View view){
        Button button = (Button) findViewById(view.getId());
        TextView textView = (TextView) findViewById(R.id.textViewResultado);
        String aux = textView.getText().toString();
        if(aux.contains("+") == false && aux.contains("-") == false && aux.contains("x") == false && aux.contains("/") == false){
            textView.setText(textView.getText().toString() + button.getText());
            auxResultado = false;
        }
    }

    public void onClickButtonIgual(View view){
        TextView textView = (TextView) findViewById(R.id.textViewResultado);
        String aux = textView.getText().toString();
        if (aux.contains("-")) {
            String [] aux2 = aux.split("-");
            num1 = Double.parseDouble(aux2 [0]);
            num2 = Double.parseDouble(aux2 [1]);
            resultado = num1 - num2;
            if (resultado %1 == 0){
                Integer intAux = resultado.intValue();
                textView.setText(intAux.toString());
            } else {
                textView.setText(resultado.toString());
            }
            auxResultado = true;
        }
        if (aux.contains("+")) {
            String [] aux2 = aux.split("\\+");
            num1 = Double.parseDouble(aux2 [0]);
            num2 = Double.parseDouble(aux2 [1]);
            resultado = num1 + num2;
            if (resultado %1 == 0){
                Integer intAux = resultado.intValue();
                textView.setText(intAux.toString());
            } else {
                textView.setText(resultado.toString());
            }
            auxResultado = true;
        }
        if (aux.contains("/")) {
            String [] aux2 = aux.split("/");
            num1 = Double.parseDouble(aux2 [0]);
            num2 = Double.parseDouble(aux2 [1]);
            if(num1 != 0 && num2 != 0){
                resultado = num1 / num2;
                if (resultado %1 == 0){
                    Integer intAux = resultado.intValue();
                    textView.setText(intAux.toString());
                } else {
                    textView.setText(resultado.toString());
                }
                auxResultado = true;
            } else {
                Toast.makeText(this, "No se puede dividir por cero!", Toast.LENGTH_SHORT).show();
            }
        }
        if (aux.contains("x")) {
            String [] aux2 = aux.split("x");
            num1 = Double.parseDouble(aux2 [0]);
            num2 = Double.parseDouble(aux2 [1]);
            resultado = num1 * num2;
            if (resultado %1 == 0){
                Integer intAux = resultado.intValue();
                textView.setText(intAux.toString());
            } else {
                textView.setText(resultado.toString());
            }
            auxResultado = true;
        }
    }
}
