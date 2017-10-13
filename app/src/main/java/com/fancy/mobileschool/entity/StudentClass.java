package com.fancy.mobileschool.entity;

import java.util.List;

/**
 * Created by Jackie on 2017/10/12.
 */

public class StudentClass {

    private int startClassNum;

    private int classNum;

    private String className;

    private int day;

    public StudentClass(int day, int startClassNum, int classNum, String className) {
        this.startClassNum = startClassNum;
        this.classNum = classNum;
        this.className = className;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStartClassNum() {
        return startClassNum;
    }

    public void setStartClassNum(int startClassNum) {
        this.startClassNum = startClassNum;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
