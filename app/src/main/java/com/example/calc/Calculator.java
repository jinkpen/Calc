package com.example.calc;

public class Calculator {
    private String operand1;
    private String operand2;
    private String operator;
    private String result;

    public Calculator() {
        this.result = "";
    }
    public String getOperand1() {return  operand1;}
    public String getOperand2() {return operand2;}
    public String getOperator(){return operator;}
    public String getResult(){return result;}
    public void setOperand1(String operand1) {this.operand1 = operand1;}
    public void setOperand2(String operand2) {this.operand2 = operand2;}
    public void setOperator(String operator){this.operator = operator;}
    public void setResult(String result){this.result = result;}

    //Method that returns display string for EditText teInput
    public String displayTEInput() {
        if (!operator.isEmpty()) {
            return operator + "   " + operand2;
        }
        else return operand2;
    }

    public void calculate (String operand1, String operand2, String operator){
        if (!operator.isEmpty() && !operand2.isEmpty()) {
            switch (operator) {
                case "\u002B":
                    result = String.valueOf(Double.parseDouble(operand1) + Double.parseDouble(operand2));
                case "\u2212":
                    result = String.valueOf(Double.parseDouble(operand1) - Double.parseDouble(operand2));
                case "\u00D7":
                    result = String.valueOf(Double.parseDouble(operand1) * Double.parseDouble(operand2));
                case "\u00F7":
                    if (operand2.equals("0")) result = "Cannot divide by 0";
                    else result = String.valueOf(Double.parseDouble(operand1) / Double.parseDouble(operand2));
            }
        }
        else result = "Error";
    }
}
