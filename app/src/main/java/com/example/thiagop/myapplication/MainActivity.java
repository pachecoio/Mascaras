package com.example.thiagop.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText cnpj = (EditText)findViewById(R.id.cnpj);
        cnpj.addTextChangedListener(Mask.insert(Mask.CNPJ_MASK, cnpj));

        EditText cpf = (EditText)findViewById(R.id.cpf);
        cpf.addTextChangedListener(Mask.insert(Mask.CPF_MASK, cpf));

        EditText telefone = (EditText)findViewById(R.id.telefone);
        telefone.addTextChangedListener(Mask.insert(Mask.CELULAR_MASK, telefone));

        EditText cep = (EditText)findViewById(R.id.cep);
        cep.addTextChangedListener(Mask.insert(Mask.CEP_MASK, cep));

        EditText preco = (EditText)findViewById(R.id.preco);
        preco.addTextChangedListener(MonetaryMask.monetario(preco));

    }
}
