/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgenerator;

import java.util.ArrayList;
import java.util.Scanner;
import model.MoneyBr;
import model.Student;
import mysearchjavafx.StudentsFile;
import model.Parent;

/**
 *
 * @author Vlad
 */

public class StudentsGenerator {
    final private ArrayList<String> manFirstNamesArray  = new ArrayList(){{
        add("Николай"); add("Валентин"); add("Александр"); add("Максим");
        add("Святослав"); add("Даниил"); add("Владислав"); add("Вячеслав");
        add("Георгий"); add("Григорий"); add("Иван"); add("Иннокентий");
        add("Евгений"); add("Валентин"); add("Эдуард"); add("Игорь");
        add("Юрий"); add("Вадим"); add("Алексей"); add("Борис");
        add("Роман"); add("Виталий"); add("Сергей"); add("Андрей");
        add("Дмитрий"); add("Михаил"); add("Филипп"); add("Фёдор");
    }};
    final private ArrayList<String> manSurnamesArray = new ArrayList(){{
        add("Николаевич"); add("Валентинович"); add("Александрович");
        add("Максимович"); add("Святославович"); add("Даниилович");
        add("Владиславович"); add("Вячеславович"); add("Георгиевич");
        add("Григорьевич"); add("Иванович"); add("Иннокентьевич");
        add("Евгеньевич"); add("Валентинович"); add("Эдуардович"); 
        add("Игоревич"); add("Юрьевич"); add("Вадимович"); 
        add("Алексеевич"); add("Борисович"); add("Романович");
        add("Витальевич"); add("Сергевич"); add("Андреевич");
        add("Дмитрьевич"); add("Михайлович"); add("Филиппович"); 
        add("Фёдорович");
    }};
    final private ArrayList<String> manLastNamesArray = new ArrayList(){{
        add("Кижеватов"); add("Новицкий"); add("Волат"); add("Петровский");
        add("Василевский"); add("Мазуров"); add("Гагарин"); add("Титов");
        add("Жуков"); add("Мирный"); add("Шестаков"); add("Иванов");
        add("Рокоссовский"); add("Невский"); add("Суворов"); add("Медведь");
        add("Брусилов"); add("Попов"); add("Третьяк"); add("Харламов");
        add("Кутозов"); add("Поддубный"); add("Пономорёв"); add("Фетисов");
        add("Машеров"); add("Карпов"); add("Королёв"); add("Каспаров");
    }};
    final private ArrayList<String> womenFirstNamesArray = new ArrayList(){{
        add("Любовь"); add("Мария"); add("Надежда"); add("Вера");
        add("Ольга"); add("Кира"); add("Валентина"); add("Роза");
        add("Нина"); add("Анастасия"); add("Евгения"); add("Виктория");
        add("Елизавета"); add("Екатерина"); add("Ирина"); add("Светлана");
        add("Елена"); add("Яна"); add("Полина"); add("Александра");
        add("Владислава"); add("Лолита"); add("Алла"); add("Ангелина");
        add("Инна"); add("Карина"); add("Маргарита"); add("Лариса");
    }};
    final private ArrayList<String> womenSurnamesArray = new ArrayList(){{
        add("Николаевна"); add("Валентиновна"); add("Александровна");
        add("Максимовна"); add("Святославовна"); add("Данииловна");  
        add("Владиславовна"); add("Вячеславовна"); add("Георгиевна"); 
        add("Григорьевна"); add("Ивановна"); add("Иннокентьевна"); 
        add("Евгеньевна"); add("Валентиновна"); add("Эдуардовна"); 
        add("Игоревна"); add("Юрьевна"); add("Вадимовна"); add("Алексеевна");   
        add("Борисовна"); add("Романовна"); add("Витальевна"); 
        add("Сергьевна"); add("Андреевна"); add("Дмитрьевна");  
        add("Михайловна"); add("Филипповна"); add("Фёдоровна");
    }};
    final private ArrayList<String> womenLastNamesArray = new ArrayList(){{
        add("Голубева"); add("Новицкая"); add("Волат"); add("Петровская");
        add("Василевская"); add("Пригара"); add("Сацук"); add("Титова");
        add("Жукова"); add("Мирная"); add("Покатова"); add("Иванова");
        add("Рокоссовская"); add("Невская"); add("Сидоренко"); add("Медведь");
        add("Брусилова"); add("Попова"); add("Третьякова"); add("Харламова");
        add("Кутозова"); add("Поддубная"); add("Пономорёва"); add("Фетисова");
        add("Машерова"); add("Карпова"); add("Королёва"); add("Каспарова");
    }};
    final private ArrayList<String> rublesArray = new ArrayList(){{
        add("400"); add("2000"); add("120"); add("700");
        add("550"); add("300"); add("450"); add("750");
        add("800"); add("850"); add("900"); add("350");
        add("1000"); add("950"); add("200"); add("1500");
    }};
    final private ArrayList<String> pennyArray = new ArrayList(){{
        add("0"); add("10"); add("20"); add("30"); add("80");
        add("40"); add("50"); add("60"); add("70"); add("90"); 
    }};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        StudentsGenerator generator = new StudentsGenerator();
        System.out.println("Please, input number of new students: ");
        Scanner input = new Scanner(System.in);
        int numberOfStudents = input.nextInt();
        ArrayList<Student> studentsArray = generator.makeNewStudentsArray(numberOfStudents);
        String path = "stud_s.xml";
        StudentsFile parserDOM = new StudentsFile(path); // + "students.xml"
        parserDOM.saveDocument(studentsArray, path);
    }
    
    private ArrayList<Student> makeNewStudentsArray(int numberOfStudents){
        ArrayList<Student> studentsArray = new ArrayList();
        for(int iter = 0; iter < numberOfStudents; iter++){
            int sex = (int)(Math.random() * 2);
            int numberOfManFirstNames = manFirstNamesArray.size();
            int numberOfManSurnames = manSurnamesArray.size();
            int numberOfManLastNames = manLastNamesArray.size();
            int numberOfWomenFirstNames = womenFirstNamesArray.size();
            int numberOfWomenSurnames = womenSurnamesArray.size();
            int numberOfWomenLastNames = womenLastNamesArray.size();
            int numberOfRubles = rublesArray.size();
            int numberOfPenny = pennyArray.size();
            int firstNameRandomNumber;
            int surnameRandomNumber = 0;
            int lastNameRandomNumber = 0;
            int rublesRandomNumber;
            int pennyRandomNumber;
            String studentFirstName = null;
            String studentSurname = null;
            String studentLastName = null;
            
            if(sex == 0){
                firstNameRandomNumber = (int)(Math.random() * numberOfManFirstNames);
                surnameRandomNumber = (int)(Math.random() * numberOfManSurnames);
                lastNameRandomNumber = (int)(Math.random() * numberOfManLastNames);
                studentFirstName = manFirstNamesArray.get(firstNameRandomNumber);
                studentSurname = manSurnamesArray.get(surnameRandomNumber);
                studentLastName = manLastNamesArray.get(lastNameRandomNumber);
            }
            else if(sex == 1){
                firstNameRandomNumber = (int)(Math.random() * numberOfWomenFirstNames);
                surnameRandomNumber = (int)(Math.random() * numberOfWomenSurnames);
                lastNameRandomNumber = (int)(Math.random() * numberOfWomenLastNames);
                studentFirstName = womenFirstNamesArray.get(firstNameRandomNumber);
                studentSurname = womenSurnamesArray.get(surnameRandomNumber);
                studentLastName = womenLastNamesArray.get(lastNameRandomNumber);
            }
            
            firstNameRandomNumber = surnameRandomNumber;
            surnameRandomNumber = (int)(Math.random() * numberOfManSurnames);
            rublesRandomNumber = (int)(Math.random() * numberOfRubles);
            pennyRandomNumber = (int)(Math.random() * numberOfPenny);
            String fatherFirstName = manFirstNamesArray.get(firstNameRandomNumber);
            String fatherSurname = manSurnamesArray.get(surnameRandomNumber);
            String fatherLastName = manLastNamesArray.get(lastNameRandomNumber);
            int fatherRubles = Integer.parseInt(rublesArray.get(rublesRandomNumber));
            int fatherPenny = Integer.parseInt(pennyArray.get(pennyRandomNumber));
            MoneyBr fSalary = new MoneyBr(fatherRubles,fatherPenny);
            
            firstNameRandomNumber = (int)(Math.random() * numberOfWomenFirstNames);
            surnameRandomNumber = (int)(Math.random() * numberOfWomenSurnames);
            rublesRandomNumber = (int)(Math.random() * numberOfRubles);
            pennyRandomNumber = (int)(Math.random() * numberOfPenny);
            String motherFirstName = womenFirstNamesArray.get(firstNameRandomNumber);
            String motherSurname = womenSurnamesArray.get(surnameRandomNumber);
            String motherLastName = womenLastNamesArray.get(lastNameRandomNumber);
            int motherRubles = Integer.parseInt(rublesArray.get(rublesRandomNumber));
            int motherPenny = Integer.parseInt(pennyArray.get(pennyRandomNumber));
            MoneyBr mSalary = new MoneyBr(motherRubles,motherPenny);
                 
            Parent father = new Parent(fatherFirstName, fatherSurname, fatherLastName, fSalary);
            Parent mother = new Parent(motherFirstName, motherSurname, motherLastName, mSalary);
            
            int numOfBrothers = (int)(Math.random() * 6);
            int numOfSisters = (int)(Math.random() * 6);     
            
            Student student = new Student(
                    studentFirstName,
                    studentSurname,
                    studentLastName,
                    father,
                    mother,
                    numOfBrothers,
                    numOfSisters
            );
            studentsArray.add(student);
        }
        return studentsArray;
    }
}
