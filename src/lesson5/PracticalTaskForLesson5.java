package lesson5;

public class PracticalTaskForLesson5 {

    public static void main(String[] args) {

        Employee[] arrayEmployee = new Employee[5];
        arrayEmployee[0] = new Employee("Иванов", "Иван", "Иванович", "Директор", "ivan.ivanov.1954@mail.ru","+7-928-213-23-42",120000,64);
        arrayEmployee[1] = new Employee("Пупкин", "Василий", "Андреевич", "Заместитель директора","pupkin.vasilii.a@yandex.ru", "+7-993-213-26-00", 95000, 50);
        arrayEmployee[2] = new Employee("Терентьева","Анастасия", "Алексеевна", "Руководитель отдела продаж","terent.a.a.work@mail.ru","+7-980-039-33-33",80000, 42);
        arrayEmployee[3] = new Employee("Долбня","Петр","Сергеевич","Старший менеджер","dps.petr.ss@mail.ru","+7-929-331-15-67",50000,31);
        arrayEmployee[4] = new Employee("Шарова","Екатерина", "Анатольевна","Менеджер","e.anatolevna.1996.@rambler.ru","+7-937-294-44-68",44000,25);

        infoEmployeesOlderNumber(arrayEmployee,40);

    }

    private static void infoEmployeesOlderNumber(Employee[] arrayEmployee,int number) {
        System.out.println("Информация о сотрудниках старше " + number);
        for (int i = 0; i < arrayEmployee.length; i++) {
            if(arrayEmployee[i].getAge()>=number){
                arrayEmployee[i].showFullInfoAboutEmployee();
            }
        }
    }

}
