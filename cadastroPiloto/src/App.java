import java.util.InputMismatchException;
import java.util.Scanner;

import controlePiloto.Impl.Piloto;


public class App {
    private final static int TAMANHO_INICIAL_LISTAS = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static Piloto[] _pilotos = new Piloto[TAMANHO_INICIAL_LISTAS];
    private static int _numeroPilotos = 0;
    
    public static void main(String[] args) throws Exception {
        boolean continuarExecutando = true;
        do {
            try {
                imprimirMenu();
                int opcao = lerOpcao();
                continuarExecutando = executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
                continuarExecutando = true;
            }
        } while (continuarExecutando);
    }

    private static boolean executarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1: {
                cadastrarPiloto();
                break;
            }
            case 2: {
                listarPilotos();
                break;
            }
            case 9: {
                System.out.println("Saindo do sistema...");
                return false;
            }
            
        }

        return true;
    }

    private static void listarPilotos() {
        System.out.println("Lista de Pilotos cadastrados:");
        for (int i = 0; i < _numeroPilotos; i++) {
            System.out.println(_pilotos[i]);
        }
    }

    private static void adicionarPilotoNaLista(Piloto piloto) {
        if (_numeroPilotos == _pilotos.length) {
            Piloto[] novaLista = new Piloto[_pilotos.length * 2];
            
            
            for (int i = 0; i < _pilotos.length; i++) {
                novaLista[i] = _pilotos[i];
            }

            
            _pilotos = novaLista;
        }

        _pilotos[_numeroPilotos] = piloto;
        _numeroPilotos++;
    }

    private static void cadastrarPiloto() throws InputMismatchException {
        System.out.println("Cadastro de Pilotos");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        Piloto piloto = new Piloto(nome, _numeroPilotos, cpf);
        adicionarPilotoNaLista(piloto);
    }

    private static void imprimirMenu() {
        System.out.println("Cadastro de pilotos");
        System.out.println("1 - Cadastrar Piloto");
        System.out.println("2 - Listar pilotos");
        System.out.println("9 - Sair");
    }

    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 1 && opcao <= 9);
    }

    private static int lerOpcao() {
        int opcao = 0;
        do {
            System.out.println("Selecione a opção desejada: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (!validarOpcaoMenu(opcao)) {
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
            }
        } while (!validarOpcaoMenu(opcao));

        return opcao;
    }
}
