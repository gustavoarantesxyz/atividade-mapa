import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            clearScreen();
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    clearScreen();
                    System.out.println("");
                    System.out.print("Digite a descrição da tarefa: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    pauseForEnter(scanner);
                    break;
                case 2:
                    clearScreen();
                    toDoList.listTasks();
                    pauseForEnter(scanner);
                    break;
                case 3:
                    clearScreen();
                    System.out.println("");
                    System.out.print("Digite o ID da tarefa a ser removida: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    toDoList.removeTask(removeId);
                    pauseForEnter(scanner);
                    break;
                case 4:
                    clearScreen();
                    System.out.println("");
                    System.out.print("Digite o ID da tarefa a ser marcada como concluída: ");
                    int completeId = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    toDoList.markTaskAsCompleted(completeId);
                    pauseForEnter(scanner);
                    break;
                case 5:
                    clearScreen();
                    System.out.println("");
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("");
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("");
        System.out.println("+---------------------------------+");
        System.out.println("|            To-Do List           |");
        System.out.println("|---------------------------------|");
        System.out.println("| 1. Adicionar tarefa             |");
        System.out.println("| 2. Listar tarefas               |");
        System.out.println("| 3. Remover tarefa               |");
        System.out.println("| 4. Marcar tarefa como concluída |");
        System.out.println("| 5. Sair                         |");
        System.out.println("+---------------------------------+");
        System.out.print("Escolha uma opção: ");
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 5) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("");
                System.out.print("Opção inválida. Digite um número entre 1 e 5: ");
            }
        }
        return choice;
    }

    private static void pauseForEnter(Scanner scanner) {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Erro ao limpar a tela: " + ex.getMessage());
        }
    }
}