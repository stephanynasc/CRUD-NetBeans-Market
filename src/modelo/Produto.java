
package modelo;

public class Produto {
    private int id;
    private String nome;
    private int valor;
    private int quantidade;

    public Produto(int id, String nome, int valor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Produto(){};

    public Produto(String nome, int valor, int quantidade) {
       this.nome = nome;
       this.valor = valor;
       this.quantidade = quantidade;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
