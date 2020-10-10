package com.example.notas.models;

public class Nota {
    int id;
    String text;

    public Nota(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Nota(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
