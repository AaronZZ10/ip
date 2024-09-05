import java.util.*;

public class Taylor {
    public static void main(String[] args) {
        // Create a Scanner to read user input from the console
        Scanner sc = new Scanner(System.in);

        // Print a line for formatting
        final String line = "____________________________________________________________";

        // Greet the user and ask what they want to do
        System.out.println(line);
        System.out.println("Hello! I'm Taylor");
        System.out.println("What can I do for you?");
        System.out.println(line);

        // Read the user's input
        String input = sc.nextLine();

        // Create a list to store the tasks
        List<Task> tasks = new ArrayList<>();

        // Continue looping until the user types "bye"
        while(!input.equals("bye")) {
            // If the user types "list", show all tasks
            if(input.equals("list")) {
                System.out.println(line);
                System.out.println("Here are the tasks in your list:");

                // Loop through tasks and print them with their index
                for(int i = 0; i < tasks.size(); i++) {
                    System.out.println(i+1 + "." + tasks.get(i));
                }
                System.out.println(line);
                input = sc.nextLine();
                continue;
            }

            // Handle marking a task as completed
            if(input.startsWith("mark")){
                String[] words = input.split(" ");
                int index = Integer.parseInt(words[1])-1; // Parse the index of the task to mark

                // Validate the index to ensure it is within bounds
                if(index<0 || index>=tasks.size()) {
                    System.out.println(line);
                    System.out.println("Invalid index"); // Error message if index is invalid
                    System.out.println(line);
                } else {
                    // Mark the task as completed
                    tasks.get(index).setCompleted(true);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(tasks.get(index));
                    System.out.println(line);
                }
                input = sc.nextLine();
                continue;
            }

            // Handle unmarking a task (set it as incomplete)
            if(input.startsWith("unmark")){
                String[] words = input.split(" ");
                int index = Integer.parseInt(words[1])-1; // Parse the index of the task to unmark

                // Validate the index to ensure it is within bounds
                if(index<0 || index>=tasks.size()) {
                    System.out.println(line);
                    System.out.println("Invalid index"); // Error message if index is invalid
                } else {
                    // Mark the task as incomplete
                    tasks.get(index).setCompleted(false);
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(tasks.get(index));
                    System.out.println(line);
                }
                input = sc.nextLine();
                continue;
            }

            // Handle adding a Todo task
            if(input.startsWith("todo")){
                Todo todo = new Todo(input.substring(4)); // Extract the description of the task
                tasks.add(todo);
                System.out.println(line);
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + todo);
                System.out.println("Now you have "+ tasks.size() +" tasks in the lists");
                System.out.println(line);
                input = sc.nextLine();
                continue;
            }

            // Handle adding an Event task
            if(input.startsWith("event")){
                int from = input.indexOf("/from");
                int to = input.indexOf("/to");
                String description = input.substring(6,from); // Extract the event description
                String _from = input.substring(from+6,to); // Extract the "from" time
                String _to = input.substring(to+4); // Extract the "to" time
                Event event = new Event(description,_from,_to); // Create a new Event object
                tasks.add(event); // Add the event to the tasks list
                System.out.println(line);
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + event);
                System.out.println("Now you have "+ tasks.size() +" tasks in the lists");
                System.out.println(line);
                input = sc.nextLine();
                continue;
            }

            // Handle adding a Deadline task
            if(input.startsWith("deadline")){
                int by = input.indexOf("/by");
                String description = input.substring(9,by); // Extract the task description
                String _by = input.substring(by+4);
                Task task = new Deadline(description,_by); // Create a new Deadline object
                tasks.add(task); // Add the deadline task to the list
                System.out.println(line);
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + task);
                System.out.println("Now you have "+ tasks.size() +" tasks in the lists");
                System.out.println(line);
                input = sc.nextLine();
                continue;
            }

            // Default case for adding a simple task (just add whatever the user types)
            System.out.println(line);
            System.out.println("added: " + input);
            System.out.println(line);
            input = sc.nextLine();
        }

        // Exit message when user types "bye"
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);
    }
}