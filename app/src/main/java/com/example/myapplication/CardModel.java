package com.example.myapplication;

public class CardModel {
    String text;
    int imag;
    String text2;

    public CardModel(String text, int imag , String text2) {

        this.text = text;
        this.imag = imag;
        this.text2 = text2;
    }

    public String getText() {
        return text;
    }

    public int getImag() {
        return imag;
    }
    public String getText2() {
        return text2;
    }
}
