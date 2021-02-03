package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextView tvInput;
    private TextView tvResult;
    Calculator calc = new Calculator();
    private String operand1 = "";
    private String operand2 = "";
    private String operator = "";
    private String result = "0";

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
            if (operator.isEmpty()) {
                if (!(operand1.length() == 1 && operand1.charAt(0) == '0')) {
                    operand1 += click;
                }
            }
            else {
                if (!(operand2.length() == 1 && operand2.charAt(0) == '0')) {
                    operand2 += click;
                }
            }
            tvInput.setText(updateTVInput());
            //FOR TESTING
            System.out.println("Current click: " + click);
            System.out.println("Current operator: " + operator);
            System.out.println("Operand1: " + operand1);
            System.out.println("Operand2: " + operand2);
            System.out.println("Input bar: " + tvInput.getText());
            System.out.println("Result: " + tvResult.getText());
            //END TEST
        }
    }; //end numberListener

    //Listener for clear button
    View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            reset();
            tvInput.setText(updateTVInput());
            tvResult.setText(result);
        }
    };// end clearListener

    //Listener for backspace button
    View.OnClickListener backspaceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearError();
            clearAfterEquals();
            if (operator.isEmpty()) {
                if (operand1.length() > 0) {
                    operand1 = operand1.substring(0, operand1.length()-1);
                }
            }
            else {
                if (operand2.length() > 0) {
                    operand2 = operand2.substring(0, operand2.length()-1);
                }
            }
            tvInput.setText(updateTVInput());
            //FOR TESTING
            System.out.println("Current operator: " + operator);
            System.out.println("Operand1: " + operand1);
            System.out.println("Operand2: " + operand2);
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
            if (operator.isEmpty()) {
                if (!operand1.isEmpty()) {
                    if (!operand1.equals("0") && !operand1.equals("0.") && !operand1.contains("-")) {
                        operand1 = "-" + operand1;
                    } else {
                        operand1 = operand1.substring(1);
                    }
                }
            }
            else {
                if (!operand2.isEmpty()) {
                    if (!operand2.equals("0") && !operand2.equals("0.") && !operand2.contains("-")) {
                        operand2 = "-" + operand2;
                    } else {
                        operand2 = operand2.substring(1);
                    }
                }
            }
            tvInput.setText(updateTVInput());
            //FOR TESTING
            System.out.println("Current operator: " + operator);
            System.out.println("Operand1: " + operand1);
            System.out.println("Operand2: " + operand2);
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
            if (operator.isEmpty()) {
                if (!click.equals("\u003D")) {
                    if (hasNoOperands()) {
                        result = "0";
                        operand1 = "0";
                        operator = click;
                    }
                    else if (hasOperand1()) {
                        result = trimResult(operand1);
                        operator = click;
                    }
                }
            }
            else if (operator.equals("\u003D")) {
                if (click.equals("\u003D")) {
                    reset();
                }
                else {
                    if (hasNoOperands()) {
                        result = "0";
                        operand1 = "0";
                        operator = click;
                    }
                    else if (hasOperand1()) {
                        result = trimResult(operand1);
                        operator = click;
                    }
                }
            }
            else {
                if (hasOperand1()) {
                    result = trimResult(operand1);
                }
                else {
                    System.out.println("Calling calculate()");
                    result = calc.equals(operator, operand1, operand2);
                    operand1 = result;
                    operand2 = "";
                }
                operator = click;
            }
            tvInput.setText(updateTVInput());
            tvResult.setText(result);
            //FOR TESTING
            System.out.println("Current click: " + click);
            System.out.println("Current operator: " + operator);
            System.out.println("Operand1: " + operand1);
            System.out.println("Operand2: " + operand2);
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
            clearAfterEquals();
            //If there is no operator, append the appropriate chars to operand1
            if (operator.isEmpty()) {
                if (!operand1.contains(".")) {
                    if (operand1.length() > 0) {
                        operand1 += ".";
                    }
                    else {
                        operand1 += "0.";
                    }
                }
            }
            //If there is an operator, append the appropriate chars to operand2
            else {
                if (!operand2.contains(".")) {
                    if (operand2.length() > 0) {
                        operand2 = operand2 + ".";
                    }
                    else {
                        operand2 = operand2 + "0.";
                    }
                }
            }
            tvInput.setText(updateTVInput());
            //FOR TESTING
            System.out.println("Current operator: " + operator);
            System.out.println("Operand1: " + operand1);
            System.out.println("Operand2: " + operand2);
            System.out.println("Input bar: " + tvInput.getText());
            System.out.println("Result: " + tvResult.getText());
            //END TEST
        }
    };//end decimalListener


    //Helper methods

    private boolean hasNoOperands() {
        return operand1.isEmpty() && operand2.isEmpty();
    }
    private boolean hasOperand1() {
        return (!operand1.isEmpty()) && operand2.isEmpty();
    }

    //Method to trim result
    public String trimResult(String str) {
        if ((!str.isEmpty()) && (str.charAt(str.length()-1) == '.')) {
            str = str.substring(0, str.length()-1);
        }
        return str;
    }

    //Method to update tvInput
    private String updateTVInput() {
        if (operator.isEmpty()) {
            return operand1;
        } else {
            return operator + "   " + operand2;
        }
    }

    //Method to reset variables
    private void reset() {
        operand1 = "";
        operand2 = "";
        operator = "";
        result = "0";
    }

    //Method to clear any errors in result variable and reset calculator
    private void clearError() {
        if (result.equals("Cannot divide by 0")  || result.equals("Error")) {
            reset();
            tvInput.setText(updateTVInput());
            tvResult.setText(result);
        }
    }

    //Method to reset calculator and display
    private void clearAfterEquals() {
        if (operator.equals("\u003D")) {
            reset();
            tvInput.setText(updateTVInput());
            tvResult.setText(result);
        }
    }

}//end class