package com.example.appteste002.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appteste002.R;
import com.example.appteste002.data.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper myDB;
    private ViewHolder mViewHolder = new ViewHolder();
    private static SimpleDateFormat simpleData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);
        this.mViewHolder.texto_tomou = findViewById(R.id.texto_tomou);
        this.mViewHolder.btn_tomei = findViewById(R.id.btn_tomei);
        //this.mViewHolder.textoData = simpleData.format(Calendar.getInstance().getTime());
        this.mViewHolder.btn_tomei.setOnClickListener(this);
        //this.mViewHolder.mLayout = findViewById(R.id.scroll_layout);
        this.mViewHolder.btn_detalhes = findViewById(R.id.btn_detalhes);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_tomei) {
            //Caso clique em "Tomei"
            /*this.mViewHolder.mTextView = new TextView(this);
            this.mViewHolder.mTextView.setGravity(Gravity.CENTER);
            this.mViewHolder.mTextView.setText(this.mViewHolder.textoData);
            this.mViewHolder.mTextView.setPadding(0, 8, 0, 8);
            this.mViewHolder.mTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            this.mViewHolder.mLayout.addView(this.mViewHolder.mTextView);
            Toast.makeText(this, this.getString(R.string.parabens), Toast.LENGTH_LONG).show();*/
            this.mViewHolder.editRemedio = this.getString(R.string.remedio_nome);
            this.mViewHolder.textoData = simpleData.format(Calendar.getInstance().getTime());


            //database
            boolean estaInserido = myDB.inserirData(this.mViewHolder.editRemedio, this.mViewHolder.textoData);
            if (estaInserido) {
                Toast.makeText(this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Falha ao inserir!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void mudarTela(View view){
        Intent irDetalhes = new Intent(this, DetalhesActivity.class);
        startActivity(irDetalhes);
    }


    private static class ViewHolder {
        TextView texto_tomou;
        Button btn_tomei;
        String textoData;
        //LinearLayout mLayout;
        TextView mTextView;
        String editRemedio;
        Button btn_detalhes;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
