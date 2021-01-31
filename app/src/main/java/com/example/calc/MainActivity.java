package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;


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

        //Set listeners for UI
        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);

        btnClear.setOnClickListener(clearListener);
        btnBackspace.setOnClickListener(backspaceListener);
        btnPosNeg.setOnClickListener(posNegListener);
        btnDivide.setOnClickListener(operatorListener);
        btnMultiply.setOnClickListener(operatorListener);
        btnSubtract.setOnClickListener(operatorListener);
        btnAdd.setOnClickListener(operatorListener);
        btnEquals.setOnClickListener(operatorListener);
        btnDecimal.setOnClickListener(decimalListener);

    } //end onCreate

    //Listener for buttons with digits
    View.OnClickListener numberListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String click = thisButton.getText().toString();
            System.out.println(click);
            System.out.println(calc.getOperand1());
            //If operator is =, reset calculator and UI display
            if (calc.getOperator().equals("\u003D")) {
                calc.reset();
                teInput.setText(calc.updateTEInput());
                tvResult.setText("0");
            }
            if (calc.getOperator().isEmpty()) {
                //If 0 is not the only element in operand1, append click to operand1
                if (!(calc.getOperand1().length() == 1 && calc.getOperand1().charAt(0) == '0')) {
                        calc.setOperand1(calc.getOperand1() + click);
                        teInput.setText(calc.updateTEInput());
                }
            }
            else {
                //If 0 is not the only element in operand2, append click to operand2
                if (!(calc.getOperand2().length() == 1 && calc.getOperand2().charAt(0) == '0')) {
                    calc.setOperand2(calc.getOperand2() + click);
                    teInput.setText(calc.updateTEInput());
                }
            }
        }
    }; //end numberListener

    //Listener for clear button
    View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String click = thisButton.getText().toString();
            //Reset calculator and update UI
            calc.reset();
            teInput.setText(calc.updateTEInput());
            tvResult.setText("0");
        }
    };// end clearListener

    //Listener for backspace button
    View.OnClickListener backspaceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String click = thisButton.getText().toString();
            //If there is no operator and operand1 is longer than 0, remove the last
            //Else if operator

            //If the operator is equals, reset the calculator variables to empty strings
                //Update tvResult to display "0"
            //(Else) if
        }
    };//end backspaceListener

    //Listener for positive/negative toggle button
    View.OnClickListener posNegListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (calc.getOperator().isEmpty()) {
                if (calc.getOperand1().contains("-")) {
                    calc.setOperand1(calc.getOperand1().substring(1));
                }
                else {

                }
            }

        }
    };//end posNegListener

    //Listener for operator buttons
    View.OnClickListener operatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String click = thisButton.getText().toString();
        }
    }; //end operatorListener

    //Listener for decimal button
    View.OnClickListener decimalListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button thisButton = findViewById(v.getId());
            String click = thisButton.getText().toString();
        }
    };//end decimalListener


}//end class