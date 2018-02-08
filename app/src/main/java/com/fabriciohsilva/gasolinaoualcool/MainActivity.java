package com.fabriciohsilva.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textAlcool = (EditText) findViewById(R.id.textPrecoAlcool);
        this.mViewHolder.textGasolina = (EditText) findViewById(R.id.textPrecoGasolina);
        this.mViewHolder.textResultado = (TextView) findViewById(R.id.textResultado);
        this.mViewHolder.comparar = (Button) findViewById(R.id.buttonComparar);

        this.mViewHolder.comparar.setOnClickListener(this);




    }//end protected void onCreate(Bundle savedInstanceState)

    @Override
    public void onClick(View view){
        int id = view.getId();

        if (id == R.id.buttonComparar) {

            Double valorAlcool = Double.parseDouble(this.mViewHolder.textAlcool.getText().toString());
            Double valorGasoli = Double.parseDouble(this.mViewHolder.textGasolina.getText().toString());
            Double resultado;

            if (valorGasoli == null) {
                this.mViewHolder.textResultado.setText(R.string.msg_gasolina_vazia);
            }
            else if (valorAlcool == null){
                this.mViewHolder.textResultado.setText(R.string.msg_alcool_vazio);
            }
            else{

                //alcool ou gasolina?
                resultado = (valorAlcool / valorGasoli);

                if (resultado >= 0.7){
                    //gasolina
                    this.mViewHolder.textResultado.setText( R.string.result_gasolina);
                }
                else {
                    //alcool
                    this.mViewHolder.textResultado.setText( R.string.resultado_alcool);
                }
            }

        }//end if (id == R.id.textResultado)


    }//end public void onClick(View view)

    private static class ViewHolder {
        EditText textAlcool;
        EditText textGasolina;
        TextView textResultado;
        Button comparar;
    }//end private static class mviewHolder

}//end public class MainActivity extends AppCompatActivity implements View.OnClickListener