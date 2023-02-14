import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        TaskService.newTask("Eat", Type.PERSONAL, 2023, Month.FEBRUARY, 18, 20, 20, PeriodicityOfTasks.WeeklyTask);
        TaskService.newTask("Sleep", Type.PERSONAL, 2023, Month.FEBRUARY, 22, 20, 20, PeriodicityOfTasks.DailyTask);
        TaskService.newTask("Rave", Type.PERSONAL, 2021, Month.FEBRUARY, 25, 20, 20, PeriodicityOfTasks.YearlyTask);
        TaskService.newTask("Kursovaya rabota", Type.PERSONAL, 2021, Month.FEBRUARY, 07, 18, 20, PeriodicityOfTasks.DailyTask);

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

    //---> Добавить функционал: при выводе задач на определённую дату, нужно учитывать периодичность задач. (09/02)


    //Представим, что имеется задача на 21/02/2023, недельная. При проверке задач на 07/03/2023 она должна быть выведена. Написать соответствующий код.


    //    LocalDate dateCheckTasks = LocalDate.of(2023,07,12);    //Дата, введённая в поле при проверке задач на определённый день.
    //
    //    LocalDate exampleTaskTime = LocalDate.of(2023, 02, 12);    //Некоторая задача запланирована на 12/02/2023 и выполняется раз в месяц.
    //                                                                                    //Проверяем, выполняется ли указанная задача в день, указанный для проверки.
    //
    //    int n = 0;  //Интервал проверки совпадения даты.
    //
    //    while(exampleTaskTime.isBefore(dateCheckTasks)) {
    //
    //        exampleTaskTime = exampleTaskTime.plusMonths(1);
    //
    //        if (exampleTaskTime.isEqual(dateCheckTasks)) {
    //
    //            System.out.println("+++");
    //
    //        }
    //
    //        System.out.println(exampleTaskTime);
    //
    //    }


    //    System.out.println(TaskService.arrayOfTasks);


    //---> Выполнить указанный метод с входными данными: изначальное время выполнения задачи, периодичность, проверяемая дата для каждой задачи в списке.
    //Занести задачи, проходящие проверку, в отдельный список.
    //Вывести этот список при проверке задач на определённый день.

    //11.02 -> доработан метод вывода заданий на определённый день. Если бы этот код пришлось править и дополнять новыми функциями,
    //то я бы не уверен, что захотел бы этим заниматься. xD


    }
}