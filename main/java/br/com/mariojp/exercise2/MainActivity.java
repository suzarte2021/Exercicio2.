package br.com.mariojp.exercise2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{
    public static String texto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getIntent().hasExtra(MainActivity.texto)){
            String text = getIntent().getStringExtra(MainActivity.texto);
            TextView textView = findViewById(R.id.textView);
            textView.setText("Oii, " + texto + "!");
        }

    }
    public void trocarusuario(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getIntent().getStringExtra(MainActivity.texto);
        TextView textView = findViewById(R.id.textView);
        outState.putString("Oii, Mundo!" ,textView.getText().toString());
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstaceState) {
        getIntent().getStringExtra(MainActivity.texto);
        TextView textView = findViewById(R.id.textView);
        textView.setText(savedInstaceState.getString("Oi, Sync Project with Gradles FilesMundo!"));
        super.onRestoreInstanceState(savedInstaceState);


    }

}