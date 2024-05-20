import java.util.Scanner;

public class Farmacia {

  private static GereUtilizador gereUtilizador = new GereUtilizador();

  public static void main(String[] args) {
    if (gereUtilizador.isEmpty()) {
        System.out.println("Nenhum utilizador encontrado. Crie um gestor.");
        criarContaGestor();
    }

    int op;
    do {
      op = leDadosInt("=============================================\n" +
                      "                   FARMACIA\n" +
                      "=============================================\n" +
                      "Selecione uma opcao:\n" +
                      "1. Autenticar Conta\n" +
                      "2. Criar Conta\n" +
                      "3. Encerrar Aplicacao\n" +
                      "=============================================\n");

      switch (op) {
        case 1:
          Utilizador logado = autenticarConta();
          if (logado instanceof Gestor) {
            do{
              op = leDadosInt("1- Gerir Registos \n2- Gerir Pedidos de Servicos\n3- Historico de Servicos\n0-Encerrar sessao");
              switch (op) {
                
                case 0: 
                  System.out.println("Adeus " + logado.getNome());
                  
              }
            }
            while(op!=0);
          }
          break;
        case 2:
          criarConta();
          break;
        case 3:
          System.out.println("Adeus!");
          break;
        default:
          System.out.println("Opcao invalida. Tente novamente.");
      }
    } while (op != 3);
  }

  private static Utilizador autenticarConta() {
    String login = leDadosString("Escreva o login: ");
    String password = leDadosString("Escreva a password: ");

    Utilizador utilizadorAutenticado = gereUtilizador.autenticarUtilizador(login, password);
    if (utilizadorAutenticado != null) {
      System.out.println("Bem-vindo " + utilizadorAutenticado.getNome());
      return utilizadorAutenticado;
    }
    else{
      System.out.println("Utilizador não encontrado. Verifique o seu login e password.");
      return null;
    }
  }

  private static void criarConta() {
    String login = leDadosString("Escreva o login: ");
    String password = leDadosString("Escreva a password: ");
    String nome = leDadosString("Escreva o nome: ");
    String email = leDadosString("Escreva o email: ");

    int opTipo = leDadosInt("=============================================\n" + 
                            "Selecione o tipo de utilizador:\n" +
                            "1. Cliente\n" +
                            "2. Farmacêutico\n" +
                            "3. Gestor\n" + 
                            "=============================================");

    switch (opTipo) {
        case 1:
            String nifCliente = leDadosString("Escreva o NIF do cliente: ");
            String moradaCliente = leDadosString("Escreva a morada do cliente: ");
            String contactoCliente = leDadosString("Escreva o contacto do cliente: ");
            Cliente novoCliente = new Cliente(login, password, nome, true, email, nifCliente, moradaCliente, contactoCliente);
            gereUtilizador.registarUtilizador(novoCliente);
            break;
        case 2:
            String nifFarmaceutico = leDadosString("Escreva o NIF do farmacêutico: ");
            String moradaFarmaceutico = leDadosString("Escreva a morada do farmacêutico: ");
            String contactoFarmaceutico = leDadosString("Escreva o contacto do farmacêutico: ");
            Farmaceutico novoFarmaceutico = new Farmaceutico(login, password, nome, true, email, nifFarmaceutico, moradaFarmaceutico, contactoFarmaceutico);
            gereUtilizador.registarUtilizador(novoFarmaceutico);
            break;
        case 3:
            Gestor novoGestor = new Gestor(login, password, nome, true, email);
            gereUtilizador.registarUtilizador(novoGestor);
            break;
        default:
            System.out.println("Opção inválida. O utilizador não foi criado.");
    }
  }

  private static void criarContaGestor() {
    String login = leDadosString("Escreva o login do gestor: ");
    String password = leDadosString("Escreva a password do gestor: ");
    String nome = leDadosString("Escreva o nome do gestor: ");
    String email = leDadosString("Escreva o email do gestor: ");
    Gestor novoGestor = new Gestor(login, password, nome, true, email);
    gereUtilizador.registarUtilizador(novoGestor);
  }

  private static int leDadosInt(String aMensagem) {
    System.out.println(aMensagem);
    Scanner teclado = new Scanner(System.in);
    return teclado.nextInt();
  }

  private static String leDadosString(String aMensagem) {
    System.out.println(aMensagem);
    Scanner teclado = new Scanner(System.in);
    return teclado.nextLine();
  }
}
