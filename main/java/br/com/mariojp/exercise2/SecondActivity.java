package br.com.mariojp.exercise2;

import static br.com.mariojp.exercise2.MainActivity.texto;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        TextView textView = findViewById(R.id.textView);
        if (textView == null) {
            textView.setText("Oii, " + texto + "!");
        }
        textView.setText("Oii, " + texto + "!");

    }

    public void Cancelar(View view) {
        finish();

    }

    public void Confirmar(View view) {
        getIntent().getStringExtra(texto);
        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);
        String text = editText.getText().toString();
        texto = editText.getText().toString();
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        intent.putExtra(texto,text);
        textView.setText("Oii, " + texto + "!");
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView textView = findViewById(R.id.textView);
        outState.putString("Oii, Mundo!",textView.getText().toString());
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstaceState) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(savedInstaceState.getString("Oi, Mundo!" + texto));
        super.onRestoreInstanceState(savedInstaceState);



    }

}