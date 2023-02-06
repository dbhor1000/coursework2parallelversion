import java.time.LocalDateTime;
import java.util.Objects;

public class Task {



    enum PeriodicityOfTasks {         //Перечисления с типами для класса Bus

        OneTimeTask,
        DailyTask,
        WeeklyTask,
        MonthlyTask,
        YearlyTask;

    }

    public static PeriodicityOfTasks getPeriodicity(String str){
        if (str.equals("OneTimeTask")) return PeriodicityOfTasks.OneTimeTask;
        if (str.equals("DailyTask")) return PeriodicityOfTasks.DailyTask;
        if (str.equals("WeeklyTask")) return  PeriodicityOfTasks.WeeklyTask;
        if (str.equals("MonthlyTask")) return PeriodicityOfTasks.MonthlyTask;
        if (str.equals("YearlyTask")) return PeriodicityOfTasks.YearlyTask;
        throw new RuntimeException("Unexpected Operator");
    }

    enum Type {

        WORK,
        PERSONAL;

    }

    public static Type getType(String str){
        if (str.equals("WORK")) return Type.WORK;
        if (str.equals("PERSONAL")) return Type.PERSONAL;
        throw new RuntimeException("Unexpected Operator");
    }




    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;
    private PeriodicityOfTasks periodicity;
    private static int idGenerator = 0;

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public Task(String title, Type type, LocalDateTime dateTime, PeriodicityOfTasks periodicity) {
        this.title = title;
        this.type = type;
        this.dateTime = dateTime;
        this.periodicity = periodicity;
        this.id = idGenerator++;
        this.description = null;

    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", periodicity=" + periodicity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task that = (Task) o;
        return idGenerator == that.idGenerator && id == that.id && title.equals(that.title) && type.equals(that.type) && dateTime.equals(that.dateTime) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, type, id, dateTime, description);
    }

    public void appearsIn() {

        switch (periodicity) {
            case OneTimeTask:
                System.out.println("Задача в ежидневнике не повторяется.");
                break;
            case DailyTask:
                System.out.println("Задача в ежидневнике повторяется каждый день. Ближайшее время: " + getDateTime() + "Затем: " + dateTime.plusDays(1));
                break;
            case WeeklyTask:
                System.out.println("Задача в ежидневнике повторяется каждую неделю. Ближайшее время: " + getDateTime() + "Затем: " + dateTime.plusWeeks(1));
                break;
            case MonthlyTask:
                System.out.println("Задача в ежидневнике повторяется каждый день. Ближайшее время: " + getDateTime() + "Затем: " + dateTime.plusMonths(1));
                break;
            case YearlyTask:Task:
            System.out.println("Задача в ежидневнике повторяется каждый день. Ближайшее время: " + getDateTime() + "Затем: " + dateTime.plusYears(1));
                break;
        }
    }

}
