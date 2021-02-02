package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextView tvInput;
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

        tvInput = findViewById(R.id.tvInput);
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
            clearError();
            clearAfterEquals();
            Button thisButton = findViewById(v.getId());
            String click = thisButton.getText().toString();
            calc.number(click);
            tvInput.setText(calc.updateTVInput());
            //FOR TESTING
            System.out.println("Current click: " + click);
            System.out.println("Current operator: " + calc.getOperator());
            System.out.println("Operand1: " + calc.getOperand1());
            System.out.println("Operand2: " + calc.getOperand2());
            System.out.println("Input bar: " + tvInput.getText());
            System.out.println("Result: " + tvResult.getText());
            //END TEST
        }
    }; //end numberListener

    //Listener for clear button
    View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calc.reset();
            tvInput.setText(calc.updateTVInput());
            tvResult.setText(calc.getResult());
        }
    };// end clearListener

    //Listener for backspace button
    View.OnClickListener backspaceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearError();
            clearAfterEquals();
            calc.backspace();
            tvInput.setText(calc.updateTVInput());
            //FOR TESTING
            System.out.println("Current operator: " + calc.getOperator());
            System.out.println("Operand1: " + calc.getOperand1());
            System.out.println("Operand2: " + calc.getOperand2());
            System.out.println("Input bar: " + tvInput.getText());
            System.out.println("Result: " + tvResult.getText());
            //END TEST
        }
    };//end backspaceListener

    //Listener for positive/negative toggle button
    View.OnClickListener posNegListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearError();
            clearAfterEquals();
            calc.posNegToggle();
            tvInput.setText(calc.updateTVInput());
            //FOR TESTING
            System.out.println("Current operator: " + calc.getOperator());
            System.out.println("Operand1: " + calc.getOperand1());
            System.out.println("Operand2: " + calc.getOperand2());
            System.out.println("Input bar: " + tvInput.getText());
            System.out.println("Result: " + tvResult.getText());
            //END TEST
        }
    };//end posNegListener

    //Listener for operator buttons
    View.OnClickListener operatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearError();
            Button thisButton = findViewById(v.getId());
            String click = thisButton.getText().toString();
            calc.operation(click);
            tvInput.setText(calc.updateTVInput());
            tvResult.setText(calc.getResult());
            //FOR TESTING
            System.out.println("Current click: " + click);
            System.out.println("Current operator: " + calc.getOperator());
            System.out.println("Operand1: " + calc.getOperand1());
            System.out.println("Operand2: " + calc.getOperand2());
            System.out.println("Input bar: " + tvInput.getText());
            System.out.println("Result: " + tvResult.getText());
            //END TEST
        }
    }; //end operatorListener

    //Listener for decimal button
    View.OnClickListener decimalListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearError();
            calc.decimal();
            tvInput.setText(calc.updateTVInput());
            //FOR TESTING
            System.out.println("Current operator: " + calc.getOperator());
            System.out.println("Operand1: " + calc.getOperand1());
            System.out.println("Operand2: " + calc.getOperand2());
            System.out.println("Input bar: " + tvInput.getText());
            System.out.println("Result: " + tvResult.getText());
            //END TEST
        }
    };//end decimalListener

    //Method to clear any errors in result variable and reset calculator
    private void clearError() {
        if (calc.checkError()) {
            calc.reset();
            tvResult.setText(calc.updateTVInput());
            tvResult.setText(calc.getResult());
        }
    }

    //Method to reset calculator and display
    private void clearAfterEquals() {
        if (calc.getOperator().equals("\u003D")) {
            calc.reset();
            tvInput.setText(calc.updateTVInput());
            tvResult.setText(calc.getResult());
        }
    }

}//end class