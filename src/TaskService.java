import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

    static ArrayList<Task> arrayOfTasks = new ArrayList<>();
    static ArrayList<Task> tasksOnSpecificDate = new ArrayList<>();

    @Override
    public String toString() {
        return "TaskService{" +
                "mapOfTasks=" + arrayOfTasks +
                '}';
    }


    //Сортировка методов.
    //Методы, относящиеся к добавлению заданий.

    public static void newTask(String title, TaskEnums.Type type, int year, Month month, int dayOfMonth, int hour, int minute, TaskEnums.PeriodicityOfTasks periodicity) {


        arrayOfTasks.add(arrayOfTasks.size(), new Task(title, type, LocalDateTime.of(year, month, dayOfMonth, hour, minute), periodicity));

    }

    //Метод для проверки введённых данных.

    public static void checkInput(String typeInput, String dateInput, String recurrenceInput) throws ImproperInput {
        if (!(Arrays.stream(TaskEnums.Type.values())
                .map(TaskEnums.Type::name)
                .collect(Collectors.toSet())
                .contains(typeInput))) {
            throw new ImproperInput("Данные были введены ошибочно.");
        }

        if (!dateInput.matches("^(0[1-9]|1\\d|2[0-8]|29(?=-\\d\\d-(?!1[01345789]00|2[1235679]00)\\d\\d(?:[02468][048]|[13579][26]))|30(?!-02)|31(?=-0[13578]|-1[02]))-(0[1-9]|1[0-2])-([12]\\d{3})-([01]\\d|2[0-3]):([0-5]\\d)")) {
            throw new ImproperInput("Данные были введены ошибочно.");

        }

        if (!(Arrays.stream(TaskEnums.PeriodicityOfTasks.values())
                .map(TaskEnums.PeriodicityOfTasks::name)
                .collect(Collectors.toSet())
                .contains(recurrenceInput)))

        {
            throw new ImproperInput("Данные были введены ошибочно.");

        }
    }
    public static void addTaskScanned() {

        Scanner sc1 = new Scanner(System.in);


        System.out.println("Введите заголовок новой задачи: ");

        String taskName = sc1.next();

        System.out.println("Введите WORK если задача личная, или РERSONAL, если рабочая. ");

        String taskType = sc1.next();



        System.out.println("Введите дату и время в формате DD-MM-YYYY-HH:MM .");

        String taskDate = sc1.next();



        System.out.println("Введите повторяемость задачи: OneTimeTask, DailyTask, WeeklyTask, MonthlyTask, YearlyTask.");

        String taskRecurrecne = sc1.next();

        try {

            checkInput(taskType, taskDate, taskRecurrecne);
            newTask(taskName, TaskEnums.getType(taskType), Integer.parseInt(taskDate.substring(6, 10)), Month.of(Integer.parseInt(taskDate.substring(3, 5))), Integer.parseInt(taskDate.substring(0, 2)),
                    Integer.parseInt(taskDate.substring(11, 13)), Integer.parseInt(taskDate.substring(14, 16)), TaskEnums.getPeriodicity(taskRecurrecne));

            System.out.println("Введите описание задачи или введите 0, чтобы оставить поле пустым.");

            String taskDescription = sc1.next();


            if (!taskDescription.equals("0")) {



                arrayOfTasks.get(arrayOfTasks.size()-1).setDescription(taskDescription);

            }

            System.out.println("Задание добавлено.");



        } catch (ImproperInput e) {

            System.out.println("Не получилось добавить задачу. " + e.getMessage());

        }
    }

    //Методы, относящиеся к удалению заданий.


    //Метод для проверки того, что задача с указанным id в наличии.

    public static void checkTaskId(int idToCheck, ArrayList<Task> mapInUse) throws TaskNotFoundException {

        ArrayList<Integer> listOfId = new ArrayList<>();

        Iterator<Task> iter = arrayOfTasks.iterator();

        while(iter.hasNext()) {

            listOfId.add(iter.next().getId());

        }


        if ((listOfId.contains(idToCheck)) == false) {
            throw new TaskNotFoundException("Задание с введённым id не найдено. :(");
        }
    }


    public static void removeTask(int idTaskRemove) {       //Если Мап содержит задачу с указанным ID, тогда задача удаляется.


        for (int i = 0; i <= (arrayOfTasks.size() - 1); i++) {

            if (arrayOfTasks.get(i) != null) {

                if (arrayOfTasks.get(i).getId() == idTaskRemove) {
                    arrayOfTasks.remove(i);
                }
            }

        }
    }

    //Методы, относящиеся к выводу заданий.

    public static void checkTasksByDate(String dateToDisplay) {

        //Метод для добавления заданий на указанный день в отдельный список.
        //На ввод поступает дата в формате DD-MM-YYYY.
        //Для каждого отдельного задания (цикл for), получаем информацию о первой дате выполнения.
        //В зависимости от указанной периодичности, к изначальной дате добавляется соответствующие инкремент, пока:
        //1. Дата сравнятся с датой выполнения и добавится в отдельный список на вывод.
        //2. Дата перевалит за указанную и метод продолжится со следующим заданием из основного списка.

        LocalDate checkTasks = LocalDate.of(Integer.parseInt(dateToDisplay.substring(6, 10)), Integer.parseInt(dateToDisplay.substring(3, 5)), Integer.parseInt(dateToDisplay.substring(0, 2)));

        for (int i = 0; i < (arrayOfTasks.size()); i++){

            LocalDate taskTime = arrayOfTasks.get(i).getDateTime().toLocalDate();

                switch (arrayOfTasks.get(i).getPeriodicity()) {

                    case OneTimeTask:

                        do {

                            if (taskTime.isEqual(checkTasks)) {

                                tasksOnSpecificDate.add(arrayOfTasks.get(i));

                            }
                        } while (taskTime.isBefore(checkTasks));

                    case DailyTask:

                        do {

                            taskTime = taskTime.plusDays(1);

                            if (taskTime.isEqual(checkTasks)) {

                                tasksOnSpecificDate.add(arrayOfTasks.get(i));

                            }

                        } while (taskTime.isBefore(checkTasks));

                    case WeeklyTask:

                        do {

                            taskTime = taskTime.plusWeeks(1);

                            if (taskTime.isEqual(checkTasks)) {

                                tasksOnSpecificDate.add(arrayOfTasks.get(i));

                            }

                        } while (taskTime.isBefore(checkTasks));

                    case MonthlyTask:

                        do {

                            taskTime = taskTime.plusMonths(1);

                            if (taskTime.isEqual(checkTasks)) {

                                tasksOnSpecificDate.add(arrayOfTasks.get(i));

                            }

                        } while (taskTime.isBefore(checkTasks));

                    case YearlyTask:

                        do {

                            taskTime = taskTime.plusYears(1);

                            if (taskTime.isEqual(checkTasks)) {

                                tasksOnSpecificDate.add(arrayOfTasks.get(i));

                            }

                        } while (taskTime.isBefore(checkTasks));
            }
        }
    }

    public static void tasksForToday() {       //Выводит все задачи на сегодняшний день, содержащиеся в Мап

        int taskCount = 0;

        for (int i = 0; i < arrayOfTasks.size(); i++) {

            if (arrayOfTasks.get(i).getDateTime().getDayOfYear() == LocalDateTime.now().getDayOfYear() &&
                    arrayOfTasks.get(i).getDateTime().getYear() == LocalDateTime.now().getYear()) {
                System.out.println(arrayOfTasks.get(i).toString());
                taskCount++;
            }

        }

        if (taskCount == 0){

            System.out.println("Задачи на сегодня отсутствуют.");

        }

    }

    //Общий метод для вывода заданий, включающий tasksForToday, с использованием метода checkTasksByDate.

    public static void outputTasksScanned() {

        Scanner sc2 = new Scanner(System.in);

        System.out.println("Для вывода задач на сегодня введите 1. Для вывода задач на другой день нажмите 2.");

        int choice2 = sc2.nextInt();

        if (choice2 == 1) {

            tasksForToday();

        } else if (choice2 == 2) {

            System.out.println("Введите дату в формате DD-MM-YYYY для вывода задач.");

            String taskDisplayDate = sc2.next();

            checkTasksByDate(taskDisplayDate);

            if (tasksOnSpecificDate.size() != 0) {

                for (int i = 0; i < tasksOnSpecificDate.size(); i++) {

                    System.out.println(tasksOnSpecificDate.get(i));

                }

            } else {

                System.out.println("Задачи на указанную дату отсутствуют.");

            }

            tasksOnSpecificDate.clear();

        }
    }

    //Общий метод для запуска программы, объединяющий все остальные.

    public static void manageTasks() {

        int contin = 1;

        do {

            {

                Scanner sc = new Scanner(System.in);

                System.out.println("Здравствуйте! Введите 1 для добавления новой задачи. Введите 2 для вывода списка задач. Введите 3 удаления задачи." +
                        " Введите 4 для остановки работы программы.");

                int choice1 = sc.nextInt(); //Выбор 1


                if (choice1 == 1) {

                    addTaskScanned();

                }

                if (choice1 == 2) {


                    outputTasksScanned();

                }

                if (choice1 == 3) {

                    Scanner sc3 = new Scanner(System.in);

                    Iterator<Task> iter = arrayOfTasks.iterator();

                    while(iter.hasNext()) {

                        System.out.println(iter.next());

                    }

                    System.out.println("Введите id задачи для удаления (777 для возврата)");

                    int idForDelete = sc3.nextInt();

                    if (idForDelete == 777) {

                        continue;

                    }

                    try{

                        checkTaskId(idForDelete, arrayOfTasks);
                        removeTask(idForDelete);


                    } catch (TaskNotFoundException e) {

                        System.out.println(e.getMessage());

                    }
                }

                if (choice1 == 4) {

                    return;

                }

                System.out.println("Для возврата к началу введите любую строку. Для прекращения работы, введите 0");

                Scanner sccontin = new Scanner(System.in);

                contin = sccontin.nextInt();

            }

        }while (contin != 0) ;

    }
}
