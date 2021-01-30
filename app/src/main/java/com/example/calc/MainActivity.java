package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private EditText teInput;
    private TextView tvResult;
    Calculator calc = new Calculator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create UI
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        Button btnClear = findViewById(R.id.btnClear);
        Button btnBackspace = findViewById(R.id.btnBackspace);
        Button btnPosNeg = findViewById(R.id.btnPosNeg);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnEquals = findViewById(R.id.btnEquals);
        Button btnDecimal = findViewById(R.id.btnDecimal);

        teInput = findViewById(R.id.teInput);
        tvResult = findViewById(R.id.tvResult);
    } //end onCreate

    //Listener for buttons with digits 1 - 9
    View.OnClickListener numberListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String btnClick = thisButton.getText().toString();
        }
    }; //end numberListener

    //Listener for 0 button
    View.OnClickListener zeroListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String btnClick = thisButton.getText().toString();
        }
    }; //end zeroListener

    //Listener for operator buttons
    View.OnClickListener operatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String btnClick = thisButton.getText().toString();
        }
    }; //end operatorListener

    //Listener for decimal button
    View.OnClickListener decimalListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String btnClick = thisButton.getText().toString();
        }
    };

    //Listener for positive/negative toggle button
    View.OnClickListener posNegListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String btnClick = thisButton.getText().toString();
        }
    };//end posNegListener

    View.OnClickListener backspaceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String btnClick = thisButton.getText().toString();
        }
    };//end backspaceListener

    View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String btnClick = thisButton.getText().toString();
        }
    };// end clearListener
}