package remindershit;

import java.time.LocalTime;
import java.util.Objects;

public class Reminder implements Comparable<Reminder>{
    private LocalTime start;
    private LocalTime end;
    private String message;
    private boolean seen;

    public Reminder(LocalTime start, LocalTime end, String message) {
        this.start = start;
        this.end = end;
        this.message = message;
        seen = false;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "start=" + start +
                ", end=" + end +
                ", message='" + message + '\'' +
                ", seen=" + seen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return Objects.equals(start, reminder.start) &&
                Objects.equals(end, reminder.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }


    @Override
    public int compareTo(Reminder o) {
        if (this.start.compareTo(o.start) == 0){
           return this.end.compareTo(o.end);
        }
        return this.start.compareTo(o.start);
    }
}
