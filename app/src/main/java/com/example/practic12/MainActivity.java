package com.example.practic12;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    int player = 1;
    SharedPreferences sharedPreferences;
    Button statistics;
    String motion;
    Button startGame;
    Button robot;
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
    Switch aSwitch;
    List<Button> btnList = new ArrayList<>();
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    ImageButton img_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        settings = getSharedPreferences("SETTINGS", MODE_PRIVATE);
        if (settings.contains("MODE_NIGHT_ON")) {
            setCurrentTheme();
        } else {
            editor = settings.edit();
            editor.putBoolean("MODE_NIGHT_ON", false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            Toast.makeText(this, "День", Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.activity_main);

        img_btn = findViewById(R.id.image_btn);
        if (settings.getBoolean("MODE_NIGHT_ON", false)) {
            img_btn.setImageResource(R.drawable.ic_day);
        } else {
            img_btn.setImageResource(R.drawable.ic_night);
        }
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor = settings.edit();
                if (settings.getBoolean("MODE_NIGHT_ON", false)) {
                    editor.putBoolean("MODE_NIGHT_ON", false);
                } else {
                    editor.putBoolean("MODE_NIGHT_ON", true);
                }
                editor.apply();
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivity(intent);
            }
        });

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

        Toast.makeText(MainActivity.this, "Игра двух людей", Toast.LENGTH_SHORT).show();
        for (Button button : btnList) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (player == 1) {
                        motion = "X";
                        player = 2;
                    } else if (player == 2) {
                        motion = "O";
                        player = 1;
                    }
                    button.setText(motion);
                    if (btn3.getText() == "X" && btn2.getText() == "X" && btn8.getText() == "X"
                            || btn4.getText() == "X" && btn5.getText() == "X" && btn6.getText() == "X"
                            || btn7.getText() == "X" && btn9.getText() == "X" && btn1.getText() == "X"
                            //по вертикали
                            || btn3.getText() == "X" && btn6.getText() == "X" && btn9.getText() == "X"
                            || btn2.getText() == "X" && btn5.getText() == "X" && btn1.getText() == "X"
                            || btn4.getText() == "X" && btn7.getText() == "X" && btn8.getText() == "X"
                            //по горизонтали
                            || btn3.getText() == "X" && btn7.getText() == "X" && btn5.getText() == "X"
                            || btn8.getText() == "X" && btn5.getText() == "X" && btn9.getText() == "X"
                        //по диагонали
                    ) {
                        rez.setText("Выиграл крестик");
                        for (int i = 0; i < btnList.size(); i++) {
                            btnList.get(i).setEnabled(false);
                        }

                    } else if (btn3.getText() == "O" && btn2.getText() == "O" && btn8.getText() == "O"
                            || btn4.getText() == "O" && btn5.getText() == "O" && btn6.getText() == "O"
                            || btn7.getText() == "O" && btn9.getText() == "O" && btn1.getText() == "O"
                            //по вертикали
                            || btn3.getText() == "O" && btn6.getText() == "O" && btn9.getText() == "O"
                            || btn2.getText() == "O" && btn5.getText() == "O" && btn1.getText() == "O"
                            || btn4.getText() == "O" && btn7.getText() == "O" && btn8.getText() == "O"
                            //по горизонтали
                            || btn3.getText() == "O" && btn7.getText() == "O" && btn5.getText() == "O"
                            || btn8.getText() == "O" && btn5.getText() == "O" && btn9.getText() == "O"
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
            });
            Intent intent = getIntent();
            String value = intent.getStringExtra("key");
        }

        robot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowWin();
            }
        });
    }

    public void ShowWin() {
        int play1 = sharedPreferences.getInt("игрок 1", 0);
        int play2 = sharedPreferences.getInt("игрок 2", 0);
        int play12 = sharedPreferences.getInt("Ничья", 0);
        String sms = "игрок 1 = " + play1 + "игрок 2 = " + play2 + "Ничья" + play12;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Статистика").setMessage(sms).setPositiveButton("ОК", null).show();
    }
    private void setCurrentTheme() {
        if(settings.getBoolean("MODE_NIGHT_ON", false)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO));
        }
    }
}