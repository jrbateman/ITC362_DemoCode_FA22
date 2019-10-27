package com.bateman.paintcalculator;


public class InteriorRoom {
    //ROOM CONSTANTS
    static final int WINDOW_AREA = 16;
    static final int DOOR_AREA = 21;
    static final int SQR_FEET_PER_GAL = 275;


    // DATA MEMBERS FOR ROOM DIMENSIONS
    private double mLength;
    private double mWidth;
    private double mHeight;

    // DATA MEMBERS FOR WINDOWS AND DOORS
    private int mDoors;
    private int mWindows;

    public void setWidth(double width){
        mWidth = width;
    }
    public void setHeight(double height){
        mHeight = height;
    }
    public void setLength(double length){
        mLength = length;
    }

    public void setDoors(int doors){
        mDoors = doors;
    }

    public void setWindows(int windows){
        mWindows = windows;
    }

    public double wallSurface() {
        return 2*mLength*mHeight + 2*mWidth*mHeight + mLength*mWidth;
    }

    public int doorWindowArea (){
        return mDoors*DOOR_AREA + mWindows*WINDOW_AREA;
    }

    public double surfaceArea() {
        return wallSurface() - doorWindowArea();
    }

    public int gallons(){
         return (int) Math.ceil(surfaceArea()) / 100;
    }
}
