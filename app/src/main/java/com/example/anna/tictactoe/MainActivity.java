package com.example.anna.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String WinX = "Winner player is X";
    public static final String WinO = "Winner player is O";
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int turn;
    boolean end = false;
    String a, b, c, d, e, f, g, h, i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        Toast.makeText(MainActivity.this, "Hodit X", Toast.LENGTH_LONG).show();
        turn = 1;
        b1.setOnClickListener(v -> actionOnClick(b1));
        b2.setOnClickListener(v -> actionOnClick(b2));
        b3.setOnClickListener(v -> actionOnClick(b3));
        b4.setOnClickListener(v -> actionOnClick(b4));
        b5.setOnClickListener(v -> actionOnClick(b5));
        b6.setOnClickListener(v -> actionOnClick(b6));
        b7.setOnClickListener(v -> actionOnClick(b7));
        b8.setOnClickListener(v -> actionOnClick(b8));
        b9.setOnClickListener(v -> actionOnClick(b9));
    }
    private void actionOnClick(Button b) {
        if (b.getText().toString().equals("")) {
            if (turn == 1) {
                Toast.makeText(MainActivity.this, "Hodit O", Toast.LENGTH_LONG).show();
                turn = 2;
                b.setText("X");
            } else {
                Toast.makeText(MainActivity.this, "Hodit X", Toast.LENGTH_LONG).show();
                turn = 1;
                b.setText("O");
            }
        }

        if (end) {
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
            end = false;
            Toast.makeText(MainActivity.this, "Hodit X", Toast.LENGTH_LONG).show();
            turn = 1;
        }
        endGame();
    }
    private void endGame() {
        a = b1.getText().toString();
        b = b2.getText().toString();
        c = b3.getText().toString();
        d = b4.getText().toString();
        e = b5.getText().toString();
        f = b6.getText().toString();
        g = b7.getText().toString();
        h = b8.getText().toString();
        i = b9.getText().toString();
        checkWinner(a, b, c);
        checkWinner(a, e, i);
        checkWinner(a, d, g);
        checkWinner(b, e, h);
        checkWinner(c, f, i);
        checkWinner(d, e, f);
        checkWinner(g, h, i);
    }
    private void checkWinner(String a1, String b1, String c1) {
        if (a1.equals("X") && b1.equals("X") && c1.equals("X")) {
            Toast.makeText(MainActivity.this, WinX, Toast.LENGTH_LONG).show();
            end = true;
        } else if (a1.equals("O") && b1.equals("O") && c1.equals("O")) {
            Toast.makeText(MainActivity.this, WinO, Toast.LENGTH_LONG).show();
            end = true;
        } else if (!a.isEmpty() && !b.isEmpty() && !c.isEmpty() && !d.isEmpty() && !e.isEmpty() && !f.isEmpty() && !g.isEmpty() && !h.isEmpty() && !i.isEmpty()) {
            Toast.makeText(MainActivity.this, "Nichia", Toast.LENGTH_LONG).show();
            end = true;
        }
    }
}