package com.example.xgh.calculator;

import android.icu.text.SymbolTable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.javia.arity.Symbol;
import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

import java.util.regex.PatternSyntaxException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv;
    private TextView tv1;
    private Button bt0;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button bt10;
    private Button bt11;
    private Button bt12;
    private Button bt13;
    private Button bt14;
    private Button bt15;
    private Button btc;
    private Button btdel;
    private String formula="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        tv=findViewById(R.id.caculate);
        tv1=findViewById(R.id.result);
        bt1 =(Button) findViewById(R.id.bt1);
        bt2 =(Button) findViewById(R.id.bt2);
        bt3 =(Button) findViewById(R.id.bt3);
        bt4 =(Button) findViewById(R.id.bt4);
        bt5 =(Button) findViewById(R.id.bt5);
        bt6 =(Button) findViewById(R.id.bt6);
        bt7 =(Button) findViewById(R.id.bt7);
        bt8 =(Button) findViewById(R.id.bt8);
        bt9 =(Button) findViewById(R.id.bt9);
        bt10 =(Button) findViewById(R.id.bt10);
        bt11 =(Button) findViewById(R.id.bt11);
        bt12 =(Button) findViewById(R.id.bt12);
        bt13 =(Button) findViewById(R.id.bt13);
        bt14 =(Button) findViewById(R.id.bt14);
        bt15 =(Button) findViewById(R.id.bt15);
        btc =(Button) findViewById(R.id.btc);
        btdel =(Button) findViewById(R.id.btdel);
        bt0 =(Button) findViewById(R.id.bt0);


        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt10.setOnClickListener(this);
        bt11.setOnClickListener(this);
        bt12.setOnClickListener(this);
        bt13.setOnClickListener(this);
        bt14.setOnClickListener(this);
        bt15.setOnClickListener(this);
        btc.setOnClickListener(this);
        btdel.setOnClickListener(this);


    }
    public void onClick(View view){
        Button btn=(Button) view;
        switch (view.getId()){
            case R.id.bt0:
            case R.id.bt1:
            case R.id.bt2:
            case R.id.bt3:
            case R.id.bt4:
            case R.id.bt5:
            case R.id.bt6:
            case R.id.bt7:
            case R.id.bt8:
            case R.id.bt9:
            case R.id.bt15:
                formula +=btn.getText().toString();
                tv.setText(formula);
                break;
            case R.id.bt10:
            case R.id.bt11:
            case R.id.bt12:
            case R.id.bt13:
            case R.id.btc:
            case R.id.btdel:
                if (!formula.equals("")){
                    formula +=btn.getText().toString();
                    tv.setText(formula);
                }else {
                    Toast.makeText(MainActivity.this,formula+"表达式不符合要求",
                    Toast.LENGTH_SHORT).show();
                    formula ="";
                }
                break;
            case R.id.bt14:
                String reg ="^\\d+(.\\d)?[+\\-*]\\d+(.\\d)?";
                try {
                    if (formula != null && !formula.equals("") && formula.matches(reg)) {
                        Symbols symbols=new Symbols();
                        double result =symbols.eval(formula);
                        tv1.setText(btn.getText().toString()+result);


                    } else {
                        Toast.makeText(MainActivity.this,formula+"表达式不符合要求",
                                Toast.LENGTH_SHORT).show();

                    }

                }catch (SyntaxException e){
                    e.printStackTrace();
                }
                formula="";
                break;


        }

    }
    //完成当前数据的保存
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView caculate =findViewById(R.id.caculate);

        TextView result = findViewById(R.id.result);
        outState.putString("caculate",caculate.getText().toString());
        outState.putString("result",result.getText().toString());
    }


    //
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView result = findViewById(R.id.result);
        TextView caculate =findViewById(R.id.caculate);
        String cacu=savedInstanceState.getString("caculate");
        String str = savedInstanceState.getString("result");
        result.setText(str);
        caculate.setText(cacu);


    }
}

