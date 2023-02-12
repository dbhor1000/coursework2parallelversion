public class TaskEnums {
    enum PeriodicityOfTasks {         //Перечисления с типами для класса Bus
        OneTimeTask("OneTimeTask"),
        DailyTask("DailyTask"),
        WeeklyTask("WeeklyTask"),
        MonthlyTask("MonthlyTask"),
        YearlyTask("YearlyTask");

        String description;

        PeriodicityOfTasks(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description + " ";
        }
    }
    public static PeriodicityOfTasks getPeriodicity(String str){
        if (str.equals(PeriodicityOfTasks.OneTimeTask.name())) return PeriodicityOfTasks.OneTimeTask;
        if (str.equals(PeriodicityOfTasks.DailyTask.name())) return PeriodicityOfTasks.DailyTask;
        if (str.equals(PeriodicityOfTasks.WeeklyTask.name())) return PeriodicityOfTasks.WeeklyTask;
        if (str.equals(PeriodicityOfTasks.MonthlyTask.name())) return PeriodicityOfTasks.MonthlyTask;
        if (str.equals(PeriodicityOfTasks.YearlyTask.name())) return PeriodicityOfTasks.YearlyTask;
        throw new RuntimeException("Unexpected Operator");
    }
    enum Type {

        WORK,
        PERSONAL;

    }
    public static Type getType(String str){
        if (str.equals(Type.WORK.name())) return Type.WORK;
        if (str.equals(Type.PERSONAL.name())) return Type.PERSONAL;
        throw new RuntimeException("Unexpected Operator");
    }
}
