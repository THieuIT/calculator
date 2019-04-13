package com.htt.tranhieu.calculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt0, bt1, bt2, bt3, bt4, bt6, bt7, bt5, bt8, bt9,btclear ,  btplus, btminus, btquals, btmultiply, btdivision;
    EditText etNumber;
    TextView result;
    List<Double> listSo;
    List<String> listDau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listSo = new ArrayList<>();
        listDau = new ArrayList<>();
        initWidget();
        setEventClickViews();




    }
    public void initWidget(){
        result = findViewById(R.id.tvResult);
        bt1 = findViewById(R.id.so1);
        bt0 = findViewById(R.id.so0);
        bt2 = findViewById(R.id.so2);
        bt3 = findViewById(R.id.so3);
        bt4 = findViewById(R.id.so4);
        bt5 = findViewById(R.id.so5);
        bt6 = findViewById(R.id.so6);
        bt7 = findViewById(R.id.so7);
        bt8 = findViewById(R.id.so8);
        bt9 = findViewById(R.id.so9);
        btclear = findViewById(R.id.btnclear);
        btplus = findViewById(R.id.plus);
        btminus = findViewById(R.id.minus);
        btquals = findViewById(R.id.equals);
        btmultiply = findViewById(R.id.multi);
        etNumber = findViewById(R.id.etnumber);
        btdivision = findViewById(R.id.division);
    }
    public void setEventClickViews(){
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt0.setOnClickListener(this);

        btclear.setOnClickListener(this);
        btplus.setOnClickListener(this);
        btminus.setOnClickListener(this);
        btdivision.setOnClickListener(this);
        btmultiply.setOnClickListener(this);
        btquals.setOnClickListener(this);

    }

//    private int cong(int a, int b){
//      return a+b;
//    }
//    private  int nhan(int a, int b){
//        return a*b;
//    }
//    private int tru(int a, int b){
//        return a-b;
//    }
//    private int chia(int a, int b){
//        return a/b;
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.so0:
                etNumber.append("0");
                break;
            case R.id.so1:
                etNumber.append("1");
                break;
            case R.id.so2:
                etNumber.append("2");
                break;
            case R.id.so3:
                etNumber.append("3");
                break;
            case R.id.so4:
                etNumber.append("4");

                break;
            case R.id.so5:
                etNumber.append("5");
                break;
            case R.id.so6:
                etNumber.append("6");
                break;
            case R.id.so7:
                etNumber.append("7");
                break;
            case R.id.so8:
                etNumber.append("8");
                break;
            case R.id.so9:
                etNumber.append("9");
                break;
            case R.id.plus:
                etNumber.append("+");
                break;
            case R.id.minus:
                etNumber.append("-");
                break;
            case R.id.multi:
                etNumber.append("*");
                break;
            case R.id.division:
                etNumber.append("/");
                break;
            case R.id.btnclear:
                etNumber.setText("");
                result.setText("");
                break;
            case R.id.equals:
                try {
                    result.setText((double)doCalc(etNumber.getText().toString()) + "");
                } catch (ScriptException e) {
                    e.printStackTrace();
                }


                break;
        }
    }

    public static Object doCalc(String str) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("rhino");
        return engine.eval(str);
    }


}
