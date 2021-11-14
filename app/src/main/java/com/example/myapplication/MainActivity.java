package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapplication.R;

public class MainActivity extends Activity {
  boolean isKrestik = true;
  Button sq1, sq2, sq3, sq4, sq5, sq6, sq7, sq8, sq9, more;
  TextView txt;
  Button[][] squares = {{sq1, sq2, sq3}, {sq4, sq5, sq6}, {sq7, sq8, sq9}};
  boolean inGame = true;
  int count = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    sq1 = findViewById(R.id.sq1);
    sq2 = findViewById(R.id.sq2);
    sq3 = findViewById(R.id.sq3);
    sq4 = findViewById(R.id.sq4);
    sq5 = findViewById(R.id.sq5);
    sq6 = findViewById(R.id.sq6);
    sq7 = findViewById(R.id.sq7);
    sq8 = findViewById(R.id.sq8);
    sq9 = findViewById(R.id.sq9);
    more = findViewById(R.id.more);
    txt = findViewById(R.id.txt);
  }

  public void refresh(View v) {
    finish();
    startActivity(getIntent());
  }

  public void setSq1(View v) {
    setZn(sq1);
    //  isVinner();
    // sq1.setBackgroundColor(0xfeefeeee);
  }

  public void setSq2(View v) {
    setZn(sq2);
    // isVinner();
  }

  public void setSq3(View v) {
    setZn(sq3);
    // isVinner();
  }

  public void setSq4(View v) {
    setZn(sq4);
    // s4 = sq4.getText().toString();
    //  isVinner();
  }

  public void setSq5(View v) {
    setZn(sq5);
    // s5 = sq5.getText().toString();
    // isVinner();
  }

  public void setSq6(View v) {
    setZn(sq6);
    //   s6 = sq6.getText().toString();
    // isVinner();
  }

  public void setSq7(View v) {
    setZn(sq7);
  }

  public void setSq8(View v) {
    setZn(sq8);
  }

  public void setSq9(View v) {
    setZn(sq9);
  }

  void setZn(Button sqw) {
    if (sqw.getText().toString().equals(" ") & inGame) {
      count++;
      more.setText("ЕЩЁ?");
      if (isKrestik) {
        sqw.setText("X");

        // sqw.setEnabled(false);
        // sqw.setBackgroundColor(0xfeefeeee);
        isKrestik = false;
      } else {
        sqw.setText("O");
        // sqw.setEnabled(false);
        isKrestik = true;
      }
      // count++;
      isVinner();
    }
  }

  void isVinner() {
    if (vinComb(sq1, sq2, sq3)) { // 1
      vinEffect(sq1, sq2, sq3);
    } else if (vinComb(sq4, sq5, sq6)) { // 2
      vinEffect(sq4, sq5, sq6);
    } else if (vinComb(sq7, sq8, sq9)) { // 3
      vinEffect(sq7, sq8, sq9);
    } else if (vinComb(sq1, sq4, sq7)) { // 1v
      vinEffect(sq1, sq4, sq7);
    } else if (vinComb(sq2, sq5, sq8)) { // 2v
      vinEffect(sq2, sq5, sq8);
    } else if (vinComb(sq3, sq6, sq9)) { // 3v
      vinEffect(sq3, sq6, sq9);
    } else if (vinComb(sq1, sq5, sq9)) { // 1d
      vinEffect(sq1, sq5, sq9);
    } else if (vinComb(sq3, sq5, sq7)) { // 2d
      vinEffect(sq3, sq5, sq7);
    } else if (count == 9) { // ничья
      txt.setText("Ничья");
    }
  }

  boolean vinComb(Button btn1, Button btn2, Button btn3) {
    String bs1 = btn1.getText().toString();
    String bs2 = btn2.getText().toString();
    String bs3 = btn3.getText().toString();

    return bs1.equals(bs2) & bs2.equals(bs3) & !bs3.equals(" ");
  }

  void vinEffect(Button btn1, Button btn2, Button btn3) {
    inGame = false;
    btn1.setBackgroundColor(0xfee000ee);
    btn2.setBackgroundColor(0xfeef00aa);
    btn3.setBackgroundColor(0xfeef0000);

    if (btn1.getText().toString().equals("X")) 
      txt.setText("Крестик выиграл!");
    
    if (btn1.getText().toString().equals("O")) 
      txt.setText("Нолик выиграл");
    
  }
}
