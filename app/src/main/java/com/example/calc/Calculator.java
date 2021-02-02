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
                case "\u002B": //Add character unicode
                    result = add(operand1, operand2);
                    break;
                case "\u2212":
                    result = subtract(operand1, operand2);
                    break;
                case "\u00D7":
                    result = multiply(operand1, operand2);
                    break;
                case "\u00F7":
                    if (operand2.equals(R.string.txt0)) {
                        result = "Cannot divide by 0";
                    }
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
