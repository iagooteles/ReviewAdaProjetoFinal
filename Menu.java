import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    static String resposta;

    public static void menu() {
        do {

            System.out.println(); //apenas para o menu nao ficar grudado nas resposta.
            System.out.println(">>>> Menu Contato <<<<");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Exibir Todos os Contatos");
            System.out.println("3 - Buscar Contato");
            System.out.println("4 - Buscar Contato por nome");
            System.out.println("5 - Editar Contato");
            System.out.println("6 - Remover Contato");
            System.out.println("7 - Favoritar/Desfavoritar contato");
            System.out.println("8 - Listar contatos favoritos");
            System.out.printf("9 - Sair %n");


            //resposta = Integer.parseInt(Agenda.input.nextLine());
            resposta = Agenda.input.nextLine();

            switch (resposta) {
                case "1":
                    Agenda.adicionarContato();
                    break;
                case "2":
                    Agenda.exibirContatos();
                    break;
                case "3":
                    Agenda.buscarContato();
                    break;
                case "4":
                    Agenda.buscarPorNomeInicio();
                    break;
                case "5":
                    Agenda.editarContato();
                    break;
                case "6":
                    Agenda.removerContato();
                    break;
                case "7":
                    Agenda.alterarFavoritoContato();
                    break;
                case "8":
                    Agenda.listarCostatosFavoritos();
                    break;
                case "9":
                    System.out.printf("%n Saindo...");
                    break;
                default:
                    System.out.printf("%n Insira uma opção válida %n ");

            }
        } while (!resposta.equals("9"));


    }

//    public static void menuEdicao() {
//        Scanner input = new Scanner(System.in);
//        String resposta;
//
//            do {
//
//                System.out.println(); //apenas para o menu nao ficar grudado nas resposta.
//                System.out.println(">>>> Escolha <<<<");
//                System.out.println("1 - Mudança do nome");
//                System.out.println("2 - Mudança do telefone");
//                System.out.println("3 - Mudança do email");
//                System.out.println("4 - Editar todo o contato");
//                System.out.printf("6 - Sair %n");
//
//                resposta = Agenda.input.nextLine();
//
//            } while (!resposta.equals("6"));
//    }

}



