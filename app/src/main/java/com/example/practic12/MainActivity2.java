package com.example.practic12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity2 extends AppCompatActivity {
    Context context;
    String motion;
    int game = 1;
    Button startGame;
    Button robot;
    Button statistics;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    TextView rez;
    List<Button> btnList = new ArrayList<>();
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rez = findViewById(R.id.rez);
        robot = findViewById(R.id.robot);
        startGame = findViewById(R.id.start);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        statistics = findViewById(R.id.statistics);

        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);
        btnList.add(btn4);
        btnList.add(btn5);
        btnList.add(btn6);
        btnList.add(btn7);
        btnList.add(btn8);
        btnList.add(btn9);

        for (int i = 0; i < btnList.size(); i++) {
            btnList.get(i).setEnabled(false);
        }

        startGame.setOnClickListener(l -> {
            for (int i = 0; i < btnList.size(); i++) {
                btnList.get(i).setEnabled(true);
                btnList.get(i).setText("");
            }
        });
    }

    public void statisticClick(View view){
        ShowWin();
    }
    public void ShowWin() {
        int play1 = sharedPreferences.getInt("игрок 1", 0);
        int play2 = sharedPreferences.getInt("игрок 2", 0);
        int play12 = sharedPreferences.getInt("Ничья", 0);
        String sms = "игрок 1 = " + play1 + "игрок 2 = " + play2 + "Ничья" + play12;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Статистика").setMessage(sms).setPositiveButton("ОК", null).show();
    }

    public void playHumanClick(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onClick1(View view){
        btn1.setText("X");
        Winner();
        Random();
    }
    public void onClick2(View view){
        btn2.setText("X");
        Winner();
        Random();
    }
    public void onClick3(View view){
        btn3.setText("X");
        Winner();
        Random();
    }
    public void onClick4(View view){
        btn4.setText("X");
        Winner();
        Random();
    }
    public void onClick5(View view){
        btn5.setText("X");
        Winner();
        Random();
    }
    public void onClick6(View view){
        btn6.setText("X");
        Winner();
        Random();
    }
    public void onClick7(View view){
        btn7.setText("X");
        Winner();
        Random();
    }
    public void onClick8(View view){
        btn8.setText("X");
        Winner();
        Random();
    }
    public void onClick9(View view){
        btn9.setText("X");
        Winner();
        Random();
    }
    private void Winner() {
        if (btn1.getText() == "X" && btn4.getText() == "X" && btn7.getText() == "X"
                || btn2.getText() == "X" && btn5.getText() == "X" && btn8.getText() == "X"
                || btn3.getText() == "X" && btn6.getText() == "X" && btn9.getText() == "X"
                //по вертикали
                || btn1.getText() == "X" && btn2.getText() == "X" && btn3.getText() == "X"
                || btn4.getText() == "X" && btn5.getText() == "X" && btn6.getText() == "X"
                || btn7.getText() == "X" && btn8.getText() == "X" && btn9.getText() == "X"
                //по горизонтали
                || btn1.getText() == "X" && btn5.getText() == "X" && btn9.getText() == "X"
                || btn3.getText() == "X" && btn5.getText() == "X" && btn7.getText() == "X"
            //по диагонали
        ) {
            rez.setText("Выиграл крестик");
            for (int i = 0; i < btnList.size(); i++) {
                btnList.get(i).setEnabled(false);
            }

        } else if (btn1.getText() == "O" && btn4.getText() == "O" && btn7.getText() == "O"
                || btn2.getText() == "O" && btn5.getText() == "O" && btn8.getText() == "O"
                || btn3.getText() == "O" && btn6.getText() == "O" && btn9.getText() == "O"
                //по вертикали
                || btn1.getText() == "O" && btn2.getText() == "O" && btn3.getText() == "O"
                || btn4.getText() == "O" && btn5.getText() == "O" && btn6.getText() == "O"
                || btn7.getText() == "O" && btn8.getText() == "O" && btn9.getText() == "O"
                //по горизонтали
                || btn3.getText() == "O" && btn5.getText() == "O" && btn7.getText() == "O"
                || btn1.getText() == "O" && btn5.getText() == "O" && btn9.getText() == "O"
            //по диагонали
        ) {
            rez.setText("Выиграл нолик");
            for (int i = 0; i < btnList.size(); i++) {
                btnList.get(i).setEnabled(false);
            }

        } else {
            rez.setText("Ничья");
        }
    }
    public void Random(){
        Random random = new Random();
        int randomNumber = 1 + random.nextInt(9);
        switch (randomNumber){
            case 1: if (btn1.getText() == "") {btn1.setText("0"); Winner();} else {Random();} break;
            case 2: if (btn2.getText() == "") {btn2.setText("0"); Winner();} else {Random();} break;
            case 3: if (btn3.getText() == "") {btn3.setText("0"); Winner();} else {Random();} break;
            case 4: if (btn4.getText() == "") {btn4.setText("0"); Winner();} else {Random();} break;
            case 5: if (btn5.getText() == "") {btn5.setText("0"); Winner();} else {Random();} break;
            case 6: if (btn6.getText() == "") {btn6.setText("0"); Winner();} else {Random();} break;
            case 7: if (btn7.getText() == "") {btn7.setText("0"); Winner();} else {Random();} break;
            case 8: if (btn8.getText() == "") {btn8.setText("0"); Winner();} else {Random();} break;
            case 9: if (btn9.getText() == "") {btn9.setText("0"); Winner();} else {Random();} break;
        }
        Winner();
    }
}