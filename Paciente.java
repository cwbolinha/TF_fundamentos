package TFinal;
public class Paciente {
private String nome, cpf, telefone, nomer;
private int diagnostico, qntcxs;
private Medicamento remed = new Medicamento(nomer, qntcxs);

public Paciente (String nome, String cpf, String telefone, int diagnostico, int qntcxs){ //referencia um atributo fora do método
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.diagnostico = diagnostico;
    this.qntcxs = qntcxs;
    switch(diagnostico){ //atribuição dos medicamentos recomendados
        case 1: remed.setNome("CovixUltra");
        break;
        case 2: remed.setNome("Zicox");
        break;
        case 3: remed.setNome("ChikTop");
        break;
        case 4: remed.setNome("Denguenit");
        break;
    }
} //métodos getters
public String getNome(){ 
    return nome;
}
public String getCPF(){
    return cpf;
}
public String getTele(){
    return telefone;
}
public int getDiagn(){
    return diagnostico;
}
public int getQntcxs(){
    return qntcxs;
}
// métodos setters
public void setNome(String nome){
    this.nome = nome;
}
public void setCpf(String cpf){
    this.cpf = cpf;
}
public void setTele(String telefone){
    this.telefone = telefone;
}
public void setDiagn(int diagnostico){
    this.diagnostico = diagnostico;
}
public void setQntcxs(int qntcxs){
    this.qntcxs = qntcxs;
}
public String stringDiagn(){ //atribuição dos diagnósticos
    String diag = "";
    switch (diagnostico){
        case 1: diag += "Covid";
        break;
        case 2: diag+= "Zica";
        break;
        case 3: diag += "Chikungunya";
        break;
        case 4: diag += "Dengue";
        break;
    }
    return diag;
}

public String toString(){ //método toString, retorna a representação do string
    return "Nome do paciente: " + nome + "\nCPF: " + cpf + "\nTelefone: "+telefone +"\nDiagnóstico: " + stringDiagn() + "\nMedicamento: " + remed.getNome() +"\nQuantidade de caixas prescritas: "+ qntcxs;
}
}