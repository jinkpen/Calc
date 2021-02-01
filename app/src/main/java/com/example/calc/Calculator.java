package com.example.calc;

public class Calculator {
    private String operand1;
    private String operand2;
    private String operator;
    private String result;

    public Calculator() {
        this.operand1 = "";
        this.operand2 = "";
        this.operator = "";
        this.result = "0";
    }
    public String getOperand1() {return  operand1;}
    public String getOperand2() {return operand2;}
    public String getOperator(){return operator;}
    public String getResult(){return result;}
    public void setOperand1(String operand1) {this.operand1 = operand1;}
    public void setOperand2(String operand2) {this.operand2 = operand2;}
    public void setOperator(String operator){this.operator = operator;}
    public void setResult(String result){this.result = result;}

    //Method that resets calculator values to empty strings
    public void reset() {
        this.operand1 = "";
        this.operand2 = "";
        this.operator = "";
        this.result = "0";
    }

    //Method that returns display string for EditText teInput
    public String updateTVInput() {
        if (operator.isEmpty()) {
            return operand1;
        } else {
           return operator + "   " + operand2;
        }
    }

    //Method to perform simple calculations
    public void calculate (){
        if (!operator.isEmpty() && !operand2.isEmpty()) {
            switch (operator) {
                case "\u002B":
                    result = String.valueOf(Double.parseDouble(operand1) + Double.parseDouble(operand2));
                    System.out.println("Adding"); //TEST
                    break;
                case "\u2212":
                    result = String.valueOf(Double.parseDouble(operand1) - Double.parseDouble(operand2));
                    System.out.println("Subtracting");
                    break;
                case "\u00D7":
                    result = String.valueOf(Double.parseDouble(operand1) * Double.parseDouble(operand2));
                    System.out.println("Multiplying");
                    break;
                case "\u00F7":
                    if (operand2.equals("0")) {
                        result = "Cannot divide by 0";
                    }
                    else {
                        result = String.valueOf(Double.parseDouble(operand1) / Double.parseDouble(operand2));
                        System.out.println("Dividing");
                    }
                    break;
            }
        }
        else {
            result = "Error";
        }
        //Remove trailing 0 from float value if result is an integer.
        if (result.charAt(result.length() - 1) == '0' && result.charAt(result.length() - 2) == '.') {
            result = result.substring(0, result.length() - 2);
        }
        operand1 = result;
        operand2 = "";
    }

    public boolean checkError() {
        return result == "Cannot divide by 0" || result == "Error";
    }

    public boolean hasNoOperands() {
        return operand1 == "" && operand2 == "";
    }
    public boolean hasOperand1() {
        return operand1 != "" && operand2 == "";
    }
}
