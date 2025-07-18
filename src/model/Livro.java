package model;

public class Livro {
    private int id;
    private String nome;
    private static int proximoId = 1;
    public Livro(String nome){
        this.id = proximoId;
        proximoId++;
        this.nome = nome;

    }

    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
