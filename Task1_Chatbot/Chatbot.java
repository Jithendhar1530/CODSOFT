import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Chatbot: Hello! I am your chatbot. Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            String user = sc.nextLine().toLowerCase();

            // Exit condition
            if (user.equals("bye")) {
                System.out.println("Chatbot: Goodbye! Have a nice day 😊");
                break;
            }

            // Greetings
            else if (user.equals("hi") || user.equals("hello")) {
                System.out.println("Chatbot: Hello! How can I help you?");
            }

            // Asking name
            else if (user.contains("your name")) {
                System.out.println("Chatbot: I am a simple rule-based chatbot.");
            }

            // Asking help
            else if (user.contains("help")) {
                System.out.println("Chatbot: I can answer simple questions like greetings, time, and basic info.");
            }

            // Asking time
            else if (user.contains("time")) {
                System.out.println("Chatbot: Sorry, I can't tell exact time yet, but you can check your device clock 😊");
            }

            // Asking about internship
            else if (user.contains("internship")) {
                System.out.println("Chatbot: This internship helps you learn AI basics through tasks.");
            }

            // Default response
            else {
                System.out.println("Chatbot: Sorry, I don't understand that. Try something else.");
            }
        }

        sc.close();
    }
}
