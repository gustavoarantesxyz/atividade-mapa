import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.println("");
                    System.out.print("Digite a descrição da tarefa: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    toDoList.listTasks();
                    break;
                case 3:
                    System.out.println("");
                    System.out.print("Digite o ID da tarefa a ser removida: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    toDoList.removeTask(removeId);
                    break;
                case 4:
                    System.out.println("");
                    System.out.print("Digite o ID da tarefa a ser marcada como concluída: ");
                    int completeId = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    toDoList.markTaskAsCompleted(completeId);
                    break;
                case 5:
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
        System.out.println("");
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
}