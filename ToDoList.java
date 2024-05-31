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
        System.out.println("Tarefa adicionada: " + task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void removeTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                System.out.println("Tarefa removida: " + task);
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
                System.out.println("Tarefa marcada como concluída: " + task);
                return;
            }
        }
        System.out.println("Tarefa com ID " + id + " não encontrada.");
    }
}