import java.util.Scanner;


public class Agenda {

    static Scanner input = new Scanner(System.in);
    static int indiceDeContagem = 0;
    static int nLinhas = 15;
    static int contadorId = 0;
    static String[][] matriz = new String[nLinhas][7];
    static int numeroDeRegistro = 0;


    public static boolean numeroDeRegistro() {
        if (numeroDeRegistro == 0) {
            System.out.printf(" Nenhum registro armazenado.%n");
            return false;
        }
        return true;
    }

    public static String validacaoDeInt(String question, String messageError) {
        String result;

        while(true) {
            try {
                System.out.printf(question);
                result = input.nextLine();
                // int resultado = Integer.parseInt(result);
                Long.parseLong(result);
                break;
            } catch (Exception e) {
                System.out.printf(messageError);
            }
        }

        return result;
    }

    public static boolean telefoneContaNaBase(String telefone) {
        boolean telefoneJaCadastrado = false;

        for (int i = 0; i < matriz.length; i++) {
            //if (matriz[i][0] != null && !matriz[i][0].isEmpty() && matriz[i][2] != null && matriz[i][2].equals(telefone)) {
            if (matriz[i][2] != null && matriz[i][2].equals(telefone) || matriz[i][3] != null && matriz[i][3].equals(telefone)) {
                telefoneJaCadastrado = true;
                System.out.printf("%n Esse telefone já está cadastrado por outro usuário, por favor disponibilize outro telefone: %n");
                break;
            }

        }

        return telefoneJaCadastrado;
    }

    public static void adicionarContato() {
        int id = contadorId + 1;

        numeroDeRegistro = numeroDeRegistro + 1;

        matriz[contadorId][0] = String.valueOf(id);

        System.out.println("Digite o nome do usuário:");
        matriz[contadorId][1] = input.nextLine();

        boolean telefoneJaCadastrado;
        String telefone;

        do {
            telefone = validacaoDeInt("Informe um número: %n", "Número inválido, digite novamente!");
            telefoneJaCadastrado = telefoneContaNaBase(telefone);
        } while (telefoneJaCadastrado);

        matriz[contadorId][2] = telefone;

        String telefone2 = null;
        System.out.println("Deseja cadastrar outro número de telefone? (S/N)");
        String resposta = input.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            boolean telefoneJaCadastrado2;

            do {
                telefone2 = validacaoDeInt("Informe o telefone adicional: %n", "Número inválido, digite novamente!");
                telefoneJaCadastrado2 = telefoneContaNaBase(telefone2);
            } while (telefoneJaCadastrado2);

            matriz[contadorId][3] = telefone2;
        }
        if (telefone2 != null) matriz[contadorId][3] = telefone2;

        System.out.println("Digite o email:");
        matriz[contadorId][4] = input.nextLine();

        System.out.println("Deseja cadastrar o endereço residencial? (S/N)");
        resposta = input.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            System.out.println("Digite o endereço residencial:");
            matriz[contadorId][5] = input.nextLine();
        }

        matriz[contadorId][6] = "n";

        System.out.printf("%n Registro inserido com sucesso. ID: %s%n ", id);
        contadorId++;
    }

    public static void exibirContatos() {

        if (!numeroDeRegistro())
            return;

        System.out.printf("%n Registros armazenados: %d%n", numeroDeRegistro);
        for (int i = 0; i < matriz.length; i++) {

            if(matriz[i][0] != null && matriz[i][0] != "") {
                System.out.println("ID: " + matriz[i][0] + ", Nome: " + matriz[i][1] +
                        (matriz[i][5] != null ? ", Cidade: " + matriz[i][5] : "") +
                        ", telefone 1: " + matriz[i][2] +
                        (matriz[i][3] != null ? ", Telefone 2: " + matriz[i][3] : "") +
                        ", email: " + matriz[i][4]);
                System.out.println("--------------------------------------------------------------------------");
            }
        }
    }

    public static void buscarContato() {

        if (!numeroDeRegistro()) {
            return;
        }

        String pesquisarTel = validacaoDeInt("%nDigite o Telefone Registrado:  %n", "Número inválido, digite novamente! %n");
        boolean usuarioEncontrado = false;

        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][2] != null && matriz[i][2].equals(pesquisarTel) || matriz[i][3] != null && matriz[i][3].equals(pesquisarTel)) {
                usuarioEncontrado = true;
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("ID: " + matriz[i][0] + ", Nome: " + matriz[i][1] +
                        (matriz[i][5] != null ? ", Cidade: " + matriz[i][5] : "") +
                        ", telefone 1: " + matriz[i][2] +
                        (matriz[i][3] != null ? ", Telefone 2: " + matriz[i][3] : "") +
                        ", email: " + matriz[i][4]);
                System.out.println("--------------------------------------------------------------------------");
                break;
            }

        }
        if (!usuarioEncontrado) {
            System.out.println();
            System.out.println("Registro com o telefone " + pesquisarTel + " não encontrado.");
            System.out.println();
        }
    }

    public static void editarContato() {

        if (!numeroDeRegistro()) {
            return;
        }

        String pesquisarTelefone = validacaoDeInt("Digite o Telefone do registro a ser editado: ", "Número incorreto");
        boolean telefoneJaCadastrado;
        boolean usuarioEncontrado = false;
        String telefone;
        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][2] != null && matriz[i][2].equals(pesquisarTelefone) || matriz[i][3] != null && matriz[i][3].equals(pesquisarTelefone)) {
                usuarioEncontrado = true;

                System.out.print("Novo Nome: ");
                matriz[i][1] = input.nextLine();

                do {
                    telefone = validacaoDeInt("Novo número: %n", "Número inválido, digite novamente!");
                    telefoneJaCadastrado = telefoneContaNaBase(telefone);
                }while(telefoneJaCadastrado);

                matriz[i][2] = telefone;

                String telefone2 = null;
                System.out.println("Deseja cadastrar outro número de telefone? (S/N)");
                String resposta = input.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    boolean telefoneJaCadastrado2;

                    do {
                        telefone2 = validacaoDeInt("Informe o telefone adicional: %n", "Número inválido, digite novamente!");
                        telefoneJaCadastrado2 = telefoneContaNaBase(telefone2);
                    } while (telefoneJaCadastrado2);

                    matriz[contadorId][3] = telefone2;
                }
                if (telefone2 != null) matriz[contadorId][3] = telefone2;

                System.out.print("Novo Email: ");
                matriz[i][4] = input.nextLine();

                System.out.println("Deseja cadastrar o endereço residencial? (S/N)");
                resposta = input.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    System.out.println("Digite o endereço residencial:");
                    matriz[contadorId][5] = input.nextLine();
                }

                System.out.printf("%n Registro atualizado com sucesso.");
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.printf("%n Esse usuário não está registrado. %n");
            System.out.println("--------------------------------------");
        }
    }

    public static void removerContato() {

        if (!numeroDeRegistro()) {
            return;
        }

        String pesquisarTel = validacaoDeInt("Digite o número a ser removido: ", "Número inválido");
        boolean usuarioEncontrado = false;

        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][2] != null && matriz[i][2].equals(pesquisarTel) || matriz[i][3] != null && matriz[i][3].equals(pesquisarTel)) {
                usuarioEncontrado = true;
                String[] tempContato = matriz[i];
                matriz[i] = new String[]{"","","",""};
                System.out.printf(" %n Usuário deletado com sucesso");
                numeroDeRegistro--;
                break;
            }

        }
        if (!usuarioEncontrado) {
            System.out.println();
            System.out.println("Registro com o telefone " + pesquisarTel + " não encontrado.");
            System.out.println();
        }
    }

    public static void buscarPorNomeInicio() {
        if (!numeroDeRegistro()) {
            return;
        }

        System.out.print("Digite o início do nome a ser buscado: ");
        String inicioNome = input.nextLine().toLowerCase();
        boolean usuarioEncontrado = false;

        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][1] != null && matriz[i][1].toLowerCase().startsWith(inicioNome)) {
                usuarioEncontrado = true;
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("ID: " + matriz[i][0] + ", Nome: " + matriz[i][1] +
                        ", telefone: " + matriz[i][2] + ", Email: " + matriz[i][4]);
                System.out.println("--------------------------------------------------------------------------");
            }
        }

        if (!usuarioEncontrado) {
            System.out.println();
            System.out.println("Nenhum registro encontrado com o início do nome: " + inicioNome);
            System.out.println();
        }
    }

    public static void alterarFavoritoContato() {
        if (!numeroDeRegistro())
            return;

        String pesquisarTel = validacaoDeInt("Digite o número do contato que deseja favoritar/desfavoritar: ", "Número inválido");
        boolean usuarioEncontrado = false;

        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][2] != null && matriz[i][2].equals(pesquisarTel)) {
                usuarioEncontrado = true;
                if (matriz[i][6].equals("s")) {
                    matriz[i][6] = "n";
                    System.out.printf("Contato com telefone %s foi removido dos favoritos.%n", pesquisarTel);
                } else {
                    matriz[i][6] = "s";
                    System.out.printf("Contato com telefone %s foi marcado como favorito.%n", pesquisarTel);
                }
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.printf("Contato com telefone %s não encontrado.%n", pesquisarTel);
        }
    }

    public static void listarCostatosFavoritos() {
        if (!numeroDeRegistro()) {
            return;
        }
        boolean encontrado = false;

        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][6] == "s") {
                encontrado = true;
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("ID: " + matriz[i][0] + ", Nome: " + matriz[i][1] +
                        ", telefone: " + matriz[i][2] + ", Email: " + matriz[i][4]);
                System.out.println("--------------------------------------------------------------------------");
            }
        }
        if (!encontrado) {
            System.out.println("Não há contatos favoritados.");
        }
    }
}
