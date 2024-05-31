import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            System.out.println("To-Do List");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Remover tarefa");
            System.out.println("4. Marcar tarefa como concluída");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (choice) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    toDoList.listTasks();
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa a ser removida: ");
                    int removeId = scanner.nextInt();
                    toDoList.removeTask(removeId);
                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa a ser marcada como concluída: ");
                    int completeId = scanner.nextInt();
                    toDoList.markTaskAsCompleted(completeId);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}