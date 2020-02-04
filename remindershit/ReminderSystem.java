package remindershit;

import java.time.LocalTime;
import java.util.*;

public class ReminderSystem {
    private static ReminderSystem reminderSystem;
    private ReminderTask reminderTask;
    private Thread thread;

    private ReminderSystem() {
        Set<Reminder> reminders = new HashSet<>();
        reminders.add(new Reminder(LocalTime.of(13, 30), LocalTime.of(13, 40), "Hello There! "));
        reminders.add(new Reminder(LocalTime.of(13, 40), LocalTime.of(13, 45), "Hello There!2 "));
        reminders.add(new Reminder(LocalTime.of(14, 30), LocalTime.of(14, 40), "Hello There!3 "));
        reminders.add(new Reminder(LocalTime.of(12, 30), LocalTime.of(13, 20), "Hello There!4 "));
        reminderTask = new ReminderTask(reminders);
        thread = new Thread(reminderTask);
        thread.setDaemon(true);
    }

    public static ReminderSystem getInstance(){
        if (reminderSystem == null){
            return reminderSystem = new ReminderSystem();
        }
        return reminderSystem;
    }

    public ReminderTask getReminderTask() {
        return reminderTask;
    }

    public void setReminderTask(ReminderTask reminderTask) {
        this.reminderTask = reminderTask;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public List<Reminder> getList(){
        List<Reminder> reminderList = new ArrayList<>();
        reminderList.addAll(reminderTask.getReminderSet());
        Collections.sort(reminderList);
        return reminderList;
    }

    public boolean add(Reminder reminder){
        Set<Reminder> reminders = new HashSet<>(reminderTask.getReminderSet());
        boolean isSuccess = reminders.add(reminder);
        reminderTask.setReminderSet(reminders);
        return isSuccess;
    }
}
