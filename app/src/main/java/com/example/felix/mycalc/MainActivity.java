package com.example.felix.mycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private TextView screen;
    private String display = "";
    private String currentOperator = "";
    Button add, sub, div, mul, equal, one, two, three, four, five, six, seven, eight, nine, zero, del, clear, percent, bracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.screen);
        screen.setText(display);

    }

    private void updateScreen() {
        screen.setText(display);
    }

    public void onClickNumber(View v) {  //To take Input number from View
        Button b = (Button) v;
        display += b.getText();
        updateScreen();
    }

    public void onClickOperator(View v) {  //To take Input operator from View
        Button b = (Button) v;
        display += b.getText();
        currentOperator = b.getText().toString();
        updateScreen();
    }

    public void onClickDelete(View v){

        display = display.substring(0, display.length() - 1);
        updateScreen();
    }


    private double operateArithmetic(String a, String b, String op){
        switch (op){
            case "+": return(Double.valueOf(a) + Double.valueOf(b));
            case "-": return(Double.valueOf(a) - Double.valueOf(b));
            case "X": return(Double.valueOf(a) * Double.valueOf(b));
            case "÷": return(Double.valueOf(a) / Double.valueOf(b));
            case "%": return(Double.valueOf(a) / 100);
            default: return -1;
        }
    }

    private double operatePercent(String a){
        return(Double.valueOf(a) / 100);
    }

    public void onClickEqual(View v){
        String[] operation=display.split(Pattern.quote(currentOperator));
        Double result;

        if(operation.length==1){
            result = operatePercent(operation[0]);
            screen.setText(display + "\n" + String.valueOf(result));
        }
        else {
            result = operateArithmetic(operation[0], operation[1], currentOperator);
            screen.setText(display + "\n" + String.valueOf(result));
        }
    }


    private void clear(){
        display="";
        currentOperator="";
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }

}




