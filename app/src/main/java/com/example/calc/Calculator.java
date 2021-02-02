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

    public boolean hasNoOperands() {
        return operand1 == "" && operand2 == "";
    }
    public boolean hasOperand1() {
        return operand1 != "" && operand2 == "";
    }
    public boolean checkError() {
        return result == "Cannot divide by 0" || result == "Error";
    }

    //Method that returns display string for EditText teInput
    public String updateTVInput() {
        if (operator.isEmpty()) {
            return operand1;
        } else {
           return operator + "   " + operand2;
        }
    }

    //Method to trim result
    public String trimResult(String str) {
        if ((!str.isEmpty()) && (str.charAt(str.length()-1) == '.')) {
            System.out.println("FUCK");
            str = str.substring(0, str.length()-1);
        }
        return str;
    }

    //Method that processes number button clicks
    public void number(String click) {
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
    }

    //Method that resets calculator values
    public void reset() {
        this.operand1 = "";
        this.operand2 = "";
        this.operator = "";
        this.result = "0";
    }

    //Method to remove character from operands
    public void backspace() {
        if (operator.equals("")) {
            if (operand1.length() > 0) {
                operand1 = operand1.substring(0, operand1.length()-1);
            }
        }
        else {
            if (operand2.length() > 0) {
                operand2 = operand2.substring(0, operand2.length()-1);
            }
        }
    }

    //Method to toggle input's positive/negative
    public void posNegToggle() {
        if (operator.isEmpty()) {
            if (!operand1.isEmpty() && !operand1.equals("0") && !operand1.contains("-")) {
                operand1 = "-" + operand1;
            }
            else {
                operand1 = operand1.substring(1);
            }
        }
        else {
            if (!operand2.isEmpty() && !operand2.equals("0") && !operand2.contains("-")) {
                operand2 = "-" + operand2;
            }
            else {
                operand2 = operand2.substring(1);
            }
        }
    }//end posNegToggle method

    public void decimal() {
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
    }// end decimal method

    //Method to perform simple calculations
    public void calculate() {
        if (!operator.isEmpty() && !operand2.isEmpty()) {
            switch (operator) {
                case "\u002B":
                    result = String.valueOf(Double.parseDouble(operand1) + Double.parseDouble(operand2));
                    System.out.println("Result in +: " + result);
                    break;
                case "\u2212":
                    result = String.valueOf(Double.parseDouble(operand1) - Double.parseDouble(operand2));
                    System.out.println("Result in -: " + result);
                    break;
                case "\u00D7":
                    result = String.valueOf(Double.parseDouble(operand1) * Double.parseDouble(operand2));
                    System.out.println("Result in : " + result);
                    break;
                case "\u00F7":
                    if (operand2.equals("0")) {
                        result = "Cannot divide by 0";
                    }
                    else {
                        result = String.valueOf(Double.parseDouble(operand1) / Double.parseDouble(operand2));
                        System.out.println("Result in *: " + result);
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
            System.out.println("YO");
        }
        operand1 = result;
        operand2 = "";
    }//end calculate method

    //Method to perform operation when operator is clicked
    public void operation(String click) {
        if (operator.isEmpty()) {
            if (!click.equals(R.string.txtEquals)) {
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
                calculate();
            }
            operator = click;
        }
    }//end operation method

}//end Class
