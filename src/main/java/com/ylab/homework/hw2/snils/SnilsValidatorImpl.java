package com.ylab.homework.hw2.snils;

public class SnilsValidatorImpl implements SnilsValidator{
    @Override
    public boolean validate(String snils) {
        if (snils.length() != 11) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.digit(snils.charAt(i), 10);
            if (digit == -1) {
                return false;
            } else {
                sum += digit * (9 - i);
            }
        }

        int controlNumber;
        if (sum < 100) {
            controlNumber = sum;
        } else if (sum == 100) {
            controlNumber = 0;
        } else {
            int remainder = sum % 101;
            if (remainder == 100) {
                controlNumber = 0;
            } else {
                controlNumber = remainder;
            }
        }

        String snilsTailStr = snils.substring(snils.length() - 2);
        try {
            Integer.parseInt(snilsTailStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return controlNumber == Integer.parseInt(snilsTailStr);
    }
}
