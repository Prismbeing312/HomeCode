package remindershit;

import java.time.LocalTime;
import java.util.Scanner;

public class Mainmain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ReminderSystem reminderSystem = ReminderSystem.getInstance();
        reminderSystem.getThread().start();
        String action = "";
        String get = "get";
        String exit = "exit";
        String add = "add";

        while (!action.equalsIgnoreCase(exit)){
            System.out.println("Enter an action: (exit, get, add)");
            action = input.nextLine();

            if (action.equalsIgnoreCase(get)){
                System.out.println("------Reminders-------");
                System.out.println(reminderSystem.getList());
            }

            if (action.equalsIgnoreCase(add)){
                System.out.println("Enter start hour ");
                int hour = input.nextInt();
                System.out.println("Enter start minute ");
                int minute = input.nextInt();
                System.out.println("Enter end hour ");
                int endhour = input.nextInt();
                System.out.println("Enter end minute ");
                int endminute = input.nextInt();
                input.nextLine();
                System.out.println("Enter messege: ");
                String messege = input.nextLine();
                reminderSystem.add(new Reminder(LocalTime.of(hour, minute), LocalTime.of(endhour,endminute), messege));
            }
        }
        input.close();
    }
}
