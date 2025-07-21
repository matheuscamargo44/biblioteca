package model;

public class Livro {
    private int id;
    private String nome;
    private static int proximoId = 1;
    private boolean emprestado;
    public Livro(String nome){
        this.id = proximoId++;
        this.nome = nome;
        this.emprestado = false;
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
    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}
