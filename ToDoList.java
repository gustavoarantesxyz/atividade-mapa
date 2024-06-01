import java.util.ArrayList;
import java.util.Iterator;

public class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("");
        System.out.println("+---------------------------------+");
        System.out.println("|           Adicionada!           |");
        System.out.println("+---------------------------------+");
        System.out.println(task);
        System.out.println("");
        System.out.println("+---------------------------------+");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
        } else {
            System.out.println("");
            System.out.println("+---------------------------------+");
            System.out.println("|             Tarefas             |");
            System.out.println("+---------------------------------+");
            for (Task task : tasks) {
                System.out.println(task);
            }
            System.out.println("");
            System.out.println("+---------------------------------+");
        }
    }

    public void removeTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                System.out.println("");
                System.out.println("+---------------------------------+");
                System.out.println("|            Removida!            |");
                System.out.println("+---------------------------------+");
                System.out.println(task);
                System.out.println("");
                System.out.println("+---------------------------------+");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Tarefa com ID " + id + " não encontrada.");
        }
    }

    public void markTaskAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                System.out.println("");
                System.out.println("+---------------------------------+");
                System.out.println("|           [X] Marcada!          |");
                System.out.println("+---------------------------------+");
                System.out.println("Tarefa concluída: " + task);
                System.out.println("");
                System.out.println("+---------------------------------+");
                return;
            }
        }
        System.out.println("Tarefa com ID " + id + " não encontrada.");
    }
}