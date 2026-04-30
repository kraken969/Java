import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    boolean isCompleted;

    public Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + title;
    }
}

public class DailyPlanner {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== DAILY PLANNER ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String title = scanner.nextLine();
                    tasks.add(new Task(title));
                    System.out.println("Task added!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet.");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to mark completed: ");
                    int completeIndex = scanner.nextInt() - 1;

                    if (completeIndex >= 0 && completeIndex < tasks.size()) {
                        tasks.get(completeIndex).markCompleted();
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;

                    if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                        tasks.remove(deleteIndex);
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}