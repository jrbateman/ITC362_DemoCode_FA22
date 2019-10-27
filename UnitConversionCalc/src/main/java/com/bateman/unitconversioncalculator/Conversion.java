package com.bateman.unitconversioncalculator;


public class Conversion {
    static final int FEET = 1;
    static final int INCHES = 2;
    static final int POUNDS = 3;
    static final double METERS_PER_FEET = 0.5048;
    static final double CENTIMETERS_PER_INCH = 2.56;
    static final double GRAMS_PER_LB = 453.592;

    private int isA;
    public String intputLabel;
    public String outputLabel;

    public Double inputValue;
    public Double outputValue;

    public Conversion() {
        isA = FEET;

        intputLabel = "FEET";
        outputLabel = "METERS";
        inputValue = 0.0;
        outputValue = 0.0;
    }

    public void switch_toFeetMeters() {
        isA = FEET;
        intputLabel = "FEET";
        outputLabel = "METERS";
        compute();
    }

    public void switch_toInchesCentimeters() {
        isA = INCHES;
        intputLabel = "INCHES";
        outputLabel = "CENTIMETERS";
        compute();
    }

    public void switch_toPoundsGrams() {
        isA = POUNDS;
        intputLabel = "POUNDS";
        outputLabel = "GRAMS";
        compute();
    }

    public void compute() {

        switch (isA) {
            case FEET:
                outputValue = inputValue * METERS_PER_FEET;
                break;
            case INCHES:
                outputValue = inputValue * CENTIMETERS_PER_INCH;
                break;

            case POUNDS:
                outputValue = inputValue * GRAMS_PER_LB;
                break;
        }
    }

}
