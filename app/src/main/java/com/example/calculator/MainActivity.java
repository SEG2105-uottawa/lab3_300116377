package com.example.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double data01,date02;
    private enum Operator{none, add,sub,mul, eq, div,remainder}
    private Operator operator=Operator.none;
    private boolean haveDot=false;
    private  boolean requireCleaning=false;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickNumericalbtn(View view){
        int process=view.getId();
        TextView cur=findViewById(R.id.display);

        if(operator==Operator.eq){
            operator=Operator.none;
            cur.setText("");
        }
        if(requireCleaning){
            requireCleaning=false;
            cur.setText("");
        }

        switch (process){
            case R.id.zero:
                cur.setText(cur.getText()+"0");
            case R.id.one:
                cur.setText(cur.getText()+"1");
            case R.id.two:
                cur.setText(cur.getText()+"2");
            case R.id.three:
                cur.setText(cur.getText()+"3");
            case R.id.four:
                cur.setText(cur.getText()+"4");
            case R.id.five:
                cur.setText(cur.getText()+"5");
            case R.id.six:
                cur.setText(cur.getText()+"6");
            case R.id.seven:
                cur.setText(cur.getText()+"7");
            case R.id.eight:
                cur.setText(cur.getText()+"8");
            case R.id.nine:
                cur.setText(cur.getText()+"9");
            case R.id.dot:
                if(!haveDot){
                    cur.setText(cur.getText()+".");
                    haveDot=true;
                }else{}
                break;
            default:
                cur.setText("Error");
                Log.d("Error","Unknown");
                break;


        }
    }


    public void onClickFunction(View view){
        int process=view.getId();
        TextView current=findViewById(R.id.display);

        if(process==R.id.clear){
            operator=Operator.none;
            current.setText("");
            data01=0;
            date02=0;
            requireCleaning=false;
            return;
        }
        String  datatext=current.getText().toString();
        double numberV=datatext.length()>0?Double.parseDouble(datatext):0;
        if(operator==Operator.none){
            data01=numberV;
            requireCleaning=true;
            switch (process){
                case R.id.equals:
                    operator=Operator.eq;
                    data01=0;
                    break;
                case R.id.plus:
                    operator=Operator.add;
                    break;
                case R.id.minus:
                    operator=Operator.sub;

                    break;
                case R.id.multiply:
                    operator=Operator.mul;
                    break;
                case R.id.div:
                    operator=Operator.div;
                    break;
                case R.id.remainder:
                    operator=Operator.remainder;
                    break;
                case R.id.clear:
                    operator=Operator.none;
                    break;
            }
        }else {
            double result=0;
            date02=numberV;
            switch (operator){
                case eq:
                    break;
                case none:
                    break;
                case add:
                    result=data01+date02;
                    break;
                case sub:
                    result=data01-date02;
                    break;
                case mul:
                    result=data01*date02;
                    break;
                case div:
                    result=data01/date02;
                    break;
                case remainder:
                    result=data01%date02;
                    break;
            }
            data01=result;
            operator=Operator.none;
            if((result-(int)result!=0)){
                current.setText(String.valueOf(result));
            }
            else {
                current.setText(String.valueOf((int)result));
            }
        }



    }



}