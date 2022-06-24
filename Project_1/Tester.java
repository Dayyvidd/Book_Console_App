package Project_1;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to my catalog of books!");

        Prompt prompt = new Prompt();

        while(running) {
            prompt.printPrompt();

            int selectedOption = menu.nextInt();

            switch(selectedOption) {
                case 1:
                    prompt.viewBooks();
                    break;
                case 2:
                    prompt.addBook();
                    break;
                case 3:
                    prompt.removeBook();
                    break;
                case 4:
                    prompt.viewBookOptions();
                    break;
                case 5:
                    prompt.viewBookOptions();
                case 6:
                    running = false;
                    break;
            }
        }

    }
}
