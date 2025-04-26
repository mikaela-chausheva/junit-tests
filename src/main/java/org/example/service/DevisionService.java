package org.example.service;

import model.Calculator;
import org.example.repo.IDevisionRepo;

public class DevisionService {
    private IDevisionRepo devisionRepo;

    public DevisionService(IDevisionRepo devisionRepo) {
        this.devisionRepo = devisionRepo;
    }

    public String result(final String name, final double x, final double y) {

        final String errorMessages = validateInputs(name, x, y);

        if (!errorMessages.isBlank()){
            return errorMessages;
        }

        // Return the result of the division
        double devisionResult =  x / y;

        // Return result
        return "Hello "+name + " devision(:) of "
                + x + " and "
                + y + " is(=) "
                + devisionResult;
    }

    private String validateInputs(String name, double x, double y) {

        final StringBuilder builder = new StringBuilder();

        validateName(name, builder);
        validateX(x, builder);
        validateY(y, builder);
        return builder.toString();
    }

    private static void validateX(double x, StringBuilder builder) {
        if (x == 0){
            builder.append("X cannot be zero");
        }

        if (Double.isNaN(x)){
            builder.append("X cannot be NaN");
        }
    }

    private static void validateY(double y, StringBuilder builder) {
        if (y == 0){
            builder.append("Y cannot be zero");
        }

        if (Double.isNaN(y)){
            builder.append("Y cannot be NaN");
        }
    }

    private static void validateName(String name, StringBuilder builder) {
        if (name == null || name.length() < 3){
            builder.append("Invalid name");
        }
    }



}
