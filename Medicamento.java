package TFinal;
public class Medicamento{
private String nome;
private int qntcx;

public Medicamento (String nome, int qntcx){
    this.nome = nome;
    this.qntcx = qntcx;
}
//métodos getters
public String getNome(){
    return nome;
}
public int getQntcx(){
    return qntcx;
}
//métodos setters
public void setNome(String nomen){
    nome = nomen;
}
public void setQntcx(int qntcxn){
    qntcx = qntcxn;
}
public String toString(){ //método to string
    String a = "Nome do medicamento: " + nome + "."+ "\nEstoque: " + qntcx;
    if (qntcx==1){
        a += " caixa.";
    }
    else { a += " caixas.";}
    return a;
}
}
