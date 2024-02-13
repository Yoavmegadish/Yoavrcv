package com.example.myapplication;

public class cardmodel {
    String text;
    int imag;

    public cardmodel(String text, int imag) {
        this.text = text;
        this.imag = imag;
    }

    public String getText() {
        return text;
    }

    public int getImag() {
        return imag;
    }
}
