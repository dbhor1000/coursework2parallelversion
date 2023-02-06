import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        TaskService.newTask("Eat", Task.Type.PERSONAL, 2023, Month.FEBRUARY, 25, 18, 20, Task.PeriodicityOfTasks.MonthlyTask);
        TaskService.newTask("Sleep", Task.Type.PERSONAL, 2023, Month.FEBRUARY, 23, 20, 20, Task.PeriodicityOfTasks.DailyTask);
        TaskService.newTask("Rave", Task.Type.PERSONAL, 2023, Month.JANUARY, 23, 18, 20, Task.PeriodicityOfTasks.YearlyTask);
        TaskService.newTask("Kursovaya", Task.Type.PERSONAL, 2023, Month.FEBRUARY, 06, 18, 20, Task.PeriodicityOfTasks.YearlyTask);

        TaskService.manageTasks();

        //В классе таск содержится шаблон для задач в ежидневнике. В ежидневник можно заносить задачи, удалять их, получать список задач на предстоящий день.


        //Класс TaskService позволяет организовать работу с задачами. В нём хранится коллекция задач и методы по работе с задачами.
        //Управление задачами осуществляется через консоль и класс Scanner.


        //02.02 Добавить функционал: добавление/удаление задач по id, получение задач на определённый день, на завтрашний день
        //Каждая задача обязательно имеет: заголовок, тип(личная или рабочая), дата и время, id, повторяемость.
        //Дополнительно: поле для описания.


        //Добавить функционал: обработка ошибок при вводе некорректных данных.


        //---->
        //добавить отлов ошибок при попытке удалить задачу по id, если таковая отсутствует.


        //--->Применить итератор для вывода задач при удалении


    }
}