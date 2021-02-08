package com.example.calc;

public class Calculator {

    public Calculator() {
    }

    //Separate methods to perform calculations (as specified in requirements)
    public String add(String operand1, String operand2) {
        return String.valueOf(Double.parseDouble(operand1) + Double.parseDouble(operand2));
    }
    public String subtract(String operand1, String operand2) {
        return String.valueOf(Double.parseDouble(operand1) - Double.parseDouble(operand2));
    }
    public String multiply(String operand1, String operand2) {
        return String.valueOf(Double.parseDouble(operand1) * Double.parseDouble(operand2));
    }
    public String divide(String operand1, String operand2) {
        return String.valueOf(Double.parseDouble(operand1) / Double.parseDouble(operand2));
    }

    //equals method
    public String equals(String operator, String operand1, String operand2) {
        String result = "";
            switch (operator) {
                case "\u002B": //If operator is +, add
                    result = add(operand1, operand2);
                    break;
                case "\u2212": //If operator is −, subtract
                    result = subtract(operand1, operand2);
                    break;
                case "\u00D7": //If operator is ×, multiply
                    result = multiply(operand1, operand2);
                    break;
                case "\u00F7": //If operator is ÷
                    //If operand 2 is 0, give divide by zero error
                    if (operand2.equals("0")) {
                        result = "NaN";
                    }
                    //If operand 2 is not 0, divide
                    else {
                        result = divide(operand1, operand2);
                    }
                    break;
            }
        //Remove trailing 0 from float value if result is an integer.
        if (result.charAt(result.length() - 1) == '0' && result.charAt(result.length() - 2) == '.') {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }//end calculate method

}//end Class
