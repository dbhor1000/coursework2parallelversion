public enum PeriodicityOfTasks {
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
