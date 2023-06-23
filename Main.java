package TFinal;
import java.util.*;
public class Main {
    private static Scanner sc = new Scanner(System.in);//criação dos objetos de cada classe
    private static CadastroPaciente listaPac = new CadastroPaciente(); 
    private static Medicamento remed1, remed2, remed3, remed4; 
    private static Medicamento [] listaMedicamentos = new Medicamento[4]; //cria um vetor de cada medicamento
    
public static void main (String [] args){
    remed1 = new Medicamento("CovixUltra", 0);//inicialização de cada medicamento
    remed2 = new Medicamento("Zicox", 0);
    remed3 = new Medicamento("ChikTop", 0);
    remed4 = new Medicamento("Denguenit", 0);
    listaMedicamentos[0] = remed1;//criação de uma lista de medicamentos para facilitar o acesso dos dados
    listaMedicamentos[1] = remed2;
    listaMedicamentos[2] = remed3;
    listaMedicamentos[3] = remed4;
    Scanner sc = new Scanner(System.in);
    int escolha = 10;
    while (escolha != 0){
        try { //try e catch para evitar que o usuário saia do programa ao digitar algo inesperado ou por erro de digitação
        menuOp();
        escolha = sc.nextInt();
        menuAçoes(escolha);
        sc.nextLine();
        }
        catch (Exception e){
        System.out.println("Comando inválido");
        sc.nextLine();
        }
    }
    sc.close();
}
public static void menuOp(){  //método que imprime as opções do menu
    System.out.println("\nMenu de opções:\n" + 
                       "(0) Sair\n" +
                       "(1) Cadastrar paciente\n"+
                       "(2) Remover paciente\n" +
                       "(3) Consultar lista inteira de pacientes\n"+
                       "(4) Verificar posições no cadastro ocupadas\n"+
                       "(5) Consultar registro de pacientes em ordem alfabética\n"+
                       "(6) Verificar porcentagem de diagnósticos\n" +
                       "(7) Verificar estoque de medicamentos\n" +
                       "(8) Alterar estoque de medicamentos");
}
public static void menuAçoes(int escolha){
    try { //esse try catch pega todas as exceções dentro desse switch
    switch (escolha){
        case 0: System.out.println("\nSaindo do programa...");
        break;
        case 1: System.out.print("\nDigite as informações do paciente a ser cadastrado.\n\nNome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                while (!validCPF(cpf)){//validação do cpf do paciente
                        System.out.print("CPF Inválido.\nCPF: ");
                        cpf = sc.nextLine();
                }
                System.out.print("Telefone (DDD + número): ");
                String tel = sc.nextLine();
                while (!validTel(tel)){ // validação do telefone do paciente
                        System.out.print("Telefone Inválido.\nTelefone (DDD + número): ");
                        tel = sc.nextLine();
                }
                System.out.println("Nº do diagnóstico:\n1: Covid\n2: Zica\n3: Chikungunya\n4: Dengue");
                int diag = sc.nextInt();
                System.out.print("Quantidade de caixas de medicamento prescritas: ");
                int cx = sc.nextInt();
                Paciente p = new Paciente(nome, cpf, tel, diag, cx); // criação de um novo objeto paciente; toda vez que o usuário escolher essa opção criará um objeto novo
                listaPac.adicionaP(p);
                sc.nextLine();//fazer o scanner limpar o buffer para evitar que de erro em futuros inputs
                break;
        case 2: listaPac.posicoesOcupadas();//chama o método que identifica as posições ocupadas no vetor de pacientes
                System.out.println("\nDigite a posição do paciente que deseja remover: ");
                int index = sc.nextInt();
                listaPac.removeP(index - 1); //chama o método para remover pacientes do vetor
                sc.nextLine();
                break;
        case 3: listaPac.imprimeVetor(); //chama o método que imprime o vetor de pacientes
                break;
        case 4: listaPac.posicoesOcupadas(); //chama o método que identifica posições ocupadas dentro do vetor
                break;
        case 5: listaPac.ordemAlfabetica();; //chama o método que ordena o nome dos pacientes em ordem alfabética 
                break;
        case 6: System.out.println("\nPorcentagem de diagnósticos:"); //imprime as porcentagens chamando o método para cada medicamento
                System.out.println("Covid: "+listaPac.percent()[0]+"%");
                System.out.println("Zica: "+listaPac.percent()[1] + "%");
                System.out.println("Chikungunya: "+listaPac.percent()[2] + "%");
                System.out.println("Dengue: "+listaPac.percent()[3] + "%");
                break;
        case 7: System.out.println("\n1. "+remed1.toString()+"\n2. "+remed2.toString()+"\n3. "+remed3.toString()+"\n4. "+remed4.toString()); //chama o método de representação de string oara cada remédio
                break;
        case 8: System.out.println("Digite o nº do medicamento que deseja alterar o estoque: ");
                System.out.println("1: CovixUltra"+"\n2: Zicox"+"\n3: ChikTop"+"\n4: Denguenit");
                int r = sc.nextInt();
                System.out.println("\n"+listaMedicamentos[r - 1].toString()); //imprime as informações do medicamento escolhido
                System.out.println("Digite o número do novo estoque");
                int n = sc.nextInt();
                listaMedicamentos[r - 1].setQntcx(n); //Atualiza a contidade do medicamento no estoque
                sc.nextLine();
                break; 
        default: System.out.println("Comando inválido"); 
                sc.nextLine();
                break;
        }}
        catch (Exception e){
        System.out.println("Comando inválido");
        sc.nextLine();
        }
}
public static boolean validCPF(String cpf) { //metodo validador de cpf
    cpf = cpf.replaceAll("-", "");//retira os caracteres nao numericos para que o usuário possa escrever em qualquer formato
    cpf = cpf.replaceAll("\\.", "");
    if (cpf.length() != 11) {//verifica se a string digitada tem 11 numeros
        return false;
    }
    int soma = 0;//calcula o primeiro digito verificador
    for (int i = 0; i < 9; i++) {
        int digito = Character.getNumericValue(cpf.charAt(i));
        soma += digito * (10 - i);
    }
    int resto = soma % 11;
    int veri1;
    if (resto < 2) {
        veri1 = 0;
    } else { veri1 = 11 - resto; }
    if (veri1 != Character.getNumericValue(cpf.charAt(9))) {
        return false;
    }
    soma = 0;//calcula o segundo digito verificador
    for (int i = 0; i < 10; i++) {
        int digito = Character.getNumericValue(cpf.charAt(i));
        soma += digito * (11 - i);
    }
    resto = soma % 11;
    int veri2;
    if (resto < 2) {
        veri2 = 0;
    } else { veri2 = 11 - resto; }

    return veri2 == Character.getNumericValue(cpf.charAt(10));//retorna verdadeiro se o segundo digito verificador for o ultimo digito
}
public static boolean validTel(String tel){//metodo verificador de telefone
    tel = tel.replaceAll("[^0-9]", "");// retira os caracteres nao numericos para que o usuário possa digitar em qualquer formato
    if(tel.length() != 10 && tel.length()!= 11){//verifica se tem 10 ou 11 numeros
        return false;
    }
    String ddd = tel.substring(0, 2);
    String[] dddsVal = { "11", "12", "13", "14", "15", "16", "17", "18", "19", "21",
                                 "22", "24", "27", "28", "31", "32", "33", "34", "35", "37",
                                 "38", "41", "42", "43", "44", "45", "46", "47", "48", "49",
                                 "51", "53", "54", "55", "61", "62", "63", "64", "65", "66",
                                 "67", "68", "69", "71", "73", "74", "75", "77", "79", "81",
                                 "82", "83", "84", "85", "86", "87", "88", "89", "91", "92",
                                 "93", "94", "95", "96", "97", "98", "99" };
    for (int i = 0; i < dddsVal.length; i ++){//verifica se o ddd digitado é valido
        if (ddd.equals(dddsVal[i])){
                return true;
        }
    }
    return false;
}
}
