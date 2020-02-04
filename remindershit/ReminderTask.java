package remindershit;

import java.time.LocalTime;
import java.util.Set;

public class ReminderTask implements Runnable{
    private Set<Reminder> reminderSet;

    public ReminderTask(Set<Reminder> reminderSet) {
        this.reminderSet = reminderSet;
    }

    public Set<Reminder> getReminderSet() {
        return reminderSet;
    }

    public void setReminderSet(Set<Reminder> reminderSet) {
        this.reminderSet = reminderSet;
    }

    private boolean isReminderTrue(Reminder reminder){
        return LocalTime.now().isAfter(reminder.getStart()) && LocalTime.now().isBefore(reminder.getEnd()) && !reminder.isSeen();
    }


    @Override
    public void run() {
        while (true){
            for (Reminder reminder:reminderSet) {
                if (isReminderTrue(reminder)){
                    System.out.println(reminder.getMessage());
                    reminder.setSeen(true);
                }
            }
        }
    }
}
