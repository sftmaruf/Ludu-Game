package com.shafayetmaruf.assignment.assignment1.question4.enums;

public enum Colors {
    RED("\033[0;31m"),
    GREEN("\033[0;32m"),
    YELLOW("\033[0;33m"),
    BLUE("\033[0;34m"),
    RESET("\033[0m");

    private String code;

    private Colors(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
