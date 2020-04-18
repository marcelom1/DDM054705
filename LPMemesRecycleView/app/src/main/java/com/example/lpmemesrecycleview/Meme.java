package com.example.lpmemesrecycleview;


public class Meme {
    private String nome;
    private int imagem;
    private int id;

    public Meme(String nome, int imagem, int id){
        this.nome = nome;
        this.imagem = imagem;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}