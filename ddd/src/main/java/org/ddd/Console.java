package org.ddd;

import org.ddd.applications.DDDApplication;
import org.ddd.entities.Ddd;
import org.ddd.facede.DDDFacede;
import org.ddd.repositories.DDDRepository;
import org.ddd.services.DDDService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static DDDRepository dddRepository;
    private static DDDService dddService;
    private static DDDApplication dddApplication;
    private static DDDFacede dddFacede;
    private static Scanner scanner;

    public static void resolverDependencias() {
        dddRepository = new DDDRepository();
        dddService = new DDDService();
        dddApplication = new DDDApplication(dddRepository, dddService);
        dddFacede = new DDDFacede(dddApplication);
        scanner = new Scanner(System.in);
    }

    public static void inicializarProdutos() {
        dddFacede.adicionar(new Ddd(71, "Salvador", "C:\\Users\\aluno\\Downloads\\Salvador.jpg"));
        dddFacede.adicionar(new Ddd(11, "São Paulo", "C:\\Users\\aluno\\Downloads\\Bandeira_do_estado_de_São_Paulo.svg.png"));
    }

    public static void listarDDD() {
        System.out.println("Codigo    |    Estado   |   Bandeira");
        ArrayList<Ddd> ddd = dddFacede.buscarTodos();
        ddd.forEach(c -> {
            System.out.println(c.getCodigo() + "   |     " + c.getEstado() + "   |     " + c.getImagemBandeira());
        });
    }

    public static void cadastrarDDD() {
        int id = 0;
        while (true) {
            System.out.print("Informe o código do DDD: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpa o buffer
            }
        }

        System.out.print("Informe o nome do estado: ");
        String descricao = scanner.nextLine();

        System.out.print("Informe o caminho da imagem da bandeira do estado: ");
        String imagem = scanner.nextLine();

        Ddd ddd = new Ddd(id, descricao, imagem);
        dddFacede.adicionar(ddd);
        System.out.println("DDD cadastrado com sucesso!");
    }

    public static void exibirMenu() {
        System.out.println("\n1 - Novo estado");
        System.out.println("2 - Atualizar estado");
        System.out.println("3 - Listar estados");
        System.out.println("4 - Buscar estado pelo DDD");
        System.out.println("5 - Remover estado");
        System.out.println("6 - Sair");
    }

    public static int solicitarInputUsuario() {
        int opcao = 0;
        while (true) {
            System.out.print("Informe a opção do menu desejado: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine();
            }
        }
        return opcao;
    }

    public static void buscarDDDinID() {
        int codigo = 0;
        while (true) {
            System.out.print("Informe o código do DDD que deseja buscar: ");
            try {
                codigo = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine();
            }
        }

        Ddd ddd = dddFacede.buscarPorId(codigo);
        if (ddd != null) {
            System.out.println(ddd.getCodigo() + "   |     " + ddd.getEstado() + "   |     " + ddd.getImagemBandeira());
        } else {
            System.out.println("O código digitado não está cadastrado!");
        }
    }

    private static void atualizarDDD() {
        int id = 0;
        while (true) {
            System.out.print("Informe o DDD do estado que deseja atualizar: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine();
            }
        }

        System.out.print("Informe o novo estado do DDD: ");
        String descricao = scanner.nextLine();

        System.out.print("Informe o novo caminho da imagem da bandeira: ");
        String imagem = scanner.nextLine();

        Ddd ddd = new Ddd(id, descricao, imagem);
        dddFacede.atualizarProduto(id, ddd);
        System.out.println("DDD atualizado com sucesso!");
    }

    public static void removerDDD() {
        int id = 0;
        while (true) {
            System.out.print("Informe o código do DDD que deseja remover: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine();
            }
        }

        dddFacede.remover(id);
        System.out.println("DDD removido com sucesso!");
    }

    public static void rodar() {
        int opcaoMenu = 0;

        do {
            exibirMenu();
            opcaoMenu = solicitarInputUsuario();
            switch (opcaoMenu) {
                case 1:
                    cadastrarDDD();
                    break;
                case 2:
                    atualizarDDD();
                    break;
                case 3:
                    listarDDD();
                    break;
                case 4:
                    buscarDDDinID();
                    break;
                case 5:
                    removerDDD();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção do menu.");
                    break;
            }

        } while (opcaoMenu != 6);
    }

    public static void main(String[] args) {
        resolverDependencias();
        inicializarProdutos();
        rodar();
    }
}
