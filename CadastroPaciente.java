package TFinal;
import java.util.Arrays;
public class CadastroPaciente {
private Paciente [] pacientes;
private int tam, maxOcup;

//Escrever os nomes dos pacientes em ordem alfabética crescente
//Percentagem de pacientes com: Covid, Zica, Chikungunya, Dengue acho que pode fazer um void que retorna escrito a porcentagem dos 4
public CadastroPaciente(){
    tam = 10;
    pacientes = new Paciente[tam];
    maxOcup = 0;
}
public void adicionaP(Paciente p){ //Adiciona um paciente no vetor de pacientes.
    if (maxOcup < tam){//só adiciona se o vetor tiver espaço
        pacientes[maxOcup] = p;
        maxOcup++;//aumenta toda vez que é adicionado um paciente novo
    }
    else { System.out.println("Vetor ocupado."); }
}
public void removeP(int index){ //Remove um paciente do vetor de pacientes.
    pacientes[index] = null;//remove o paciente no índice
    for (int i = index; i < maxOcup; i ++){//um for que passa os outros pacientes "para frente" e organiza o vetor
        pacientes[i] = pacientes[i + 1];
    }
    maxOcup --; //agora o ultimo indice ocupado é menor
}
public void imprimeVetor(){ //Imprime os pacientes do vetor de pacientes.
    System.out.println("Lista de Pacientes: ");
    for(int i=0; i<tam; i++){
        if (i < maxOcup - 1){ //se a posição estiver ocupada
        System.out.println("\nPaciente nº" + (i+1) + ":");            
        System.out.println(pacientes[i].toString());
        }
        else if (i == maxOcup - 1){//se for o último paciente pula uma linha
        System.out.println("\nPaciente nº" + (i+1) + ":");            
        System.out.println(pacientes[i].toString() + "\n");
        }
        else { System.out.println("Posição "+(i+1) +" livre.");}
        }        
}
public void posicoesOcupadas(){ //Indica as posições ocupadas do vetor de pacientes.
    System.out.println("Pacientes: ");
    for (int i = 0; i<maxOcup; i++){
        System.out.println("\nPaciente nº"+ (i + 1) + ":");
        System.out.println(pacientes[i].toString());
    }
}
public void ordemAlfabetica(){ //imprime os pacientes conforme a ordem alfabetica de seus nomes. mantem o indice original do paciente
    String[] stringOrd = new String[maxOcup]; //criação de uma lista que será os nomes dos pacientes em ordem
    for (int i = 0; i < maxOcup; i++){ 
        stringOrd[i] = pacientes[i].getNome(); //adiciona os nomes dos pacientes na lista a ser ordenada 
    }
    Arrays.sort(stringOrd); //utiliza o método sort para ordenar o array 
    for (int i=0;i<maxOcup;i++){
        for (int j = 0; j < maxOcup; j++){
        if (stringOrd[i].equals(pacientes[j].getNome())){ //se a string é igual ao nome do paciente na posição equivalente da lista o nome é impresso
        System.out.println("\nPaciente nº" + (j+1) + ":");          
        System.out.println(pacientes[j].toString());
        }
    }
    }
}
public double[] percent(){ //método que retorna um vetor com as 4 porcentagens de diagnósticos
    double [] percent = new double[4];
    int covid, zica, chik, deng; //variáveis que aramzenam a quantidade de pacientes com cada diagnóstico
    covid = 0;
    zica = 0;
    chik = 0;
    deng = 0;
    for (int i = 0; i < maxOcup; i++){
        switch(pacientes[i].getDiagn()){ //switch que conta os diagnósticos
            case 1: covid++;
                    break;
            case 2: zica++;
                    break;
            case 3: chik++;
                    break;
            case 4: deng++;
                    break;
        }
    }
    percent[0] = (covid*100)/maxOcup; //cálculos das porcentagens
    percent[1] = (zica*100)/maxOcup;
    percent[2] = (chik*100)/maxOcup;
    percent[3] = (deng*100)/maxOcup;
    return percent;
}
}