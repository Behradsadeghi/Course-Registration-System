import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static String AdminUsername = "admin";
    public static String AdminPassword = "1234";

    public static ArrayList<Student> students;
    public static ArrayList<Professor> professors ;
    public static ArrayList<Course> courses ;
    public static ArrayList<Field> fields ;

    public static String PATH = "C:\\Users\\O_O\\Desktop\\Behrad\\Behrad\\professors.txt";
    public static String PATH2 = "C:\\Users\\O_O\\Desktop\\Behrad\\Behrad\\courses.txt";
    public static String PATH3 = "C:\\Users\\O_O\\Desktop\\Behrad\\Behrad\\fields.txt";
    public static String PATH4 = "C:C:\\Users\\O_O\\Desktop\\Behrad\\Behrad\\students.txt";

    public static File professorsList=new File(PATH);
    public static File coursesList=new File(PATH2);
    public static File fieldsList=new File(PATH3);
    public static File studentsList=new File(PATH4);

    public static void init() throws IOException, ClassNotFoundException {
        students = new ArrayList<>();
        professors = new ArrayList<>();
        courses = new ArrayList<>();
        fields = new ArrayList<>();
        readFromMemory();
    }

    public static void readFromMemory() throws IOException, ClassNotFoundException {
        System.out.println("**************");
        if (professorsList.length() == 0){
            System.out.println("professorsList Size = " + professors.size());
        }
        else {
            FileInputStream fis=new FileInputStream(professorsList);
            ObjectInputStream ois=new ObjectInputStream(fis);
            professors=(ArrayList<Professor>)ois.readObject();
            System.out.println("professorsList Size = " + professors.size());
            ois.close();
        }

        if (coursesList.length() == 0){
            System.out.println("coursesList Size = " + courses.size());
        }
        else {
            FileInputStream fis=new FileInputStream(coursesList);
            ObjectInputStream ois=new ObjectInputStream(fis);
            courses=(ArrayList<Course>)ois.readObject();
            System.out.println("coursesList Size = " + courses.size());
            ois.close();
        }

        if (fieldsList.length() == 0){
            System.out.println("fieldsList Size = " + fields.size());
        }
        else {
            FileInputStream fis=new FileInputStream(fieldsList);
            ObjectInputStream ois=new ObjectInputStream(fis);
            fields=(ArrayList<Field>)ois.readObject();
            System.out.println("fieldsList Size = " + fields.size());
            ois.close();
        }

        if (studentsList.length() == 0){
            System.out.println("studentsList Size = " + students.size());
        }
        else {
            FileInputStream fis=new FileInputStream(studentsList);
            ObjectInputStream ois=new ObjectInputStream(fis);
            students=(ArrayList<Student>)ois.readObject();
            System.out.println("studentsList Size = " + students.size());
            ois.close();
        }
    }

    public static void writeFromMemory(int i) throws IOException {
        switch (i){
            case 1:{
                FileOutputStream fos=new FileOutputStream(professorsList);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(professors);
                oos.close();
                fos.close();
            }break;
            case 2:{
                FileOutputStream fos=new FileOutputStream(studentsList);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(students);
                oos.close();
                fos.close();
            }break;
            case 3:{
                FileOutputStream fos=new FileOutputStream(coursesList);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(courses);
                oos.close();
                fos.close();
            }break;
            case 4:{
                FileOutputStream fos=new FileOutputStream(fieldsList);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(fields);
                oos.close();
                fos.close();
            }break;
        }
    }

    public static void showMenu() throws IOException {
        while (true){
            System.out.println("Menu");
            System.out.println("***************");
            System.out.println("1.Admin");
            System.out.println("2.Course");
            System.out.println("3.Student");
            System.out.println("4.Professor");
            System.out.println("***************");
            int n;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of selected : ");
            n = scanner.nextInt();
            switch (n){
                case 1: {
                    Scanner adminScanner = new Scanner(System.in);
                    String pass , username;
                    System.out.print("Enter username : ");
                    username = adminScanner.nextLine();
                    System.out.print("Enter password : ");
                    pass = adminScanner.nextLine();
                    if (username.equals(AdminUsername) && pass.equals(AdminPassword)){
                        //admin login in system
                        boolean r1 = true;
                        while (r1){
                            System.out.println("Menu");
                            System.out.println("***************");
                            System.out.println("1.Professor");
                            System.out.println("2.Course");
                            System.out.println("3.Field");
                            System.out.println("4.Student");
                            System.out.println("5.Exit");
                            System.out.println("***************");
                            int num2;
                            System.out.print("Enter number : ");
                            num2 = adminScanner.nextInt();
                            // zir-menu
                            switch (num2){
                                case 1: {
                                    boolean r11 = true;
                                    while (r11){
                                        System.out.println("Menu");
                                        System.out.println("***************");
                                        System.out.println("1.Add");
                                        System.out.println("2.Show");
                                        System.out.println("3.Exit");
                                        System.out.println("***************");
                                        int num3;
                                        System.out.print("Enter number : ");
                                        num3 = adminScanner.nextInt();
                                        switch (num3){
                                            case 1:{
                                                adminScanner = new Scanner(System.in);
                                                System.out.println("1.HiredProfessor");
                                                System.out.println("2.TemporaryProfessor");
                                                System.out.print("Enter number : ");
                                                int num5 = adminScanner.nextInt();
                                                adminScanner = new Scanner(System.in);
                                                String name,family,password;
                                                int id;
                                                System.out.print("Enter name : ");
                                                name = adminScanner.nextLine();
                                                System.out.print("Enter family : ");
                                                family = adminScanner.nextLine();
                                                System.out.print("Enter professorCode : ");
                                                id = adminScanner.nextInt();
                                                adminScanner = new Scanner(System.in);
                                                System.out.print("Enter password : ");
                                                password = adminScanner.nextLine();
                                                if (num5 == 1){
                                                    HiredProfessor professor = new HiredProfessor(name,family,id,password);
                                                    professors.add(professor);
                                                    writeFromMemory(1);
                                                }else {
                                                    TemporaryProfessor professor= new TemporaryProfessor(name,family,id,password);
                                                    professors.add(professor);
                                                    writeFromMemory(1);
                                                }
                                            }break;
                                            case 2:{
                                                adminScanner = new Scanner(System.in);
                                                if (professors.size() > 0){
                                                    for (int i=0 ; i<professors.size() ;i++){
                                                        System.out.println((i+1) + "." + professors.get(i).getName() + professors.get(i).getFamily());
                                                    }
                                                    int num4;
                                                    System.out.print("Enter number : ");
                                                    num4 = adminScanner.nextInt();
                                                    System.out.println(professors.get(num4-1));
                                                }else {
                                                    System.out.println("List is Empty!!!");
                                                }
                                            }break;
                                            case 3:{
                                                r11 = false;
                                            }break;
                                        }
                                    }
                                }break;
                                case 2: {
                                    boolean r12 = true;
                                    while (r12){
                                        System.out.println("AdminMenu(Course)");
                                        System.out.println("***************");
                                        System.out.println("1.Add");
                                        System.out.println("2.Show");
                                        System.out.println("3.Exit");
                                        System.out.println("***************");
                                        int num3;
                                        System.out.print("Enter number : ");
                                        num3 = adminScanner.nextInt();
                                        switch (num3){
                                            case 1:{
                                                adminScanner = new Scanner(System.in);
                                                System.out.println("1.create with Id and name");
                                                System.out.println("2.create with all parameters");
                                                System.out.print("Enter number : ");
                                                int num5 = adminScanner.nextInt();
                                                if (num5 == 1){
                                                    adminScanner = new Scanner(System.in);
                                                    System.out.print("Enter name : ");
                                                    String name = adminScanner.nextLine();
                                                    System.out.print("Enter id ( size = 2 ) : ");
                                                    int id = adminScanner.nextInt();
                                                    Course course = new Course(id,name);
                                                    courses.add(course);
                                                    writeFromMemory(3);
                                                }else {
                                                    adminScanner = new Scanner(System.in);
                                                    System.out.print("Enter name : ");
                                                    String name = adminScanner.nextLine();
                                                    System.out.print("Enter id ( size = 2 ) : ");
                                                    int id = adminScanner.nextInt();
                                                    System.out.print("Enter weight : ");
                                                    int weight = adminScanner.nextInt();
                                                    System.out.print("Enter courseTime ( 1 to 8 ) : ");
                                                    int courseTime = adminScanner.nextInt();
                                                    System.out.print("Enter capacity : ");
                                                    int capacity = adminScanner.nextInt();
                                                    System.out.print("Enter inputYear : ");
                                                    int inputYear = adminScanner.nextInt();
                                                    for (int i=0 ; i<professors.size() ;i++){
                                                        System.out.println((i+1) + "." + professors.get(i).getName()+"-"+professors.get(i).getFamily());
                                                    }
                                                    int num4;
                                                    System.out.print("Enter number : ");
                                                    num4 = adminScanner.nextInt();
                                                    Course course = new Course(id,name,weight,courseTime,capacity,inputYear,professors.get(num4-1));
                                                    courses.add(course);
                                                    writeFromMemory(3);
                                                }
                                            }break;
                                            case 2:{
                                                adminScanner = new Scanner(System.in);
                                                if (courses.size() > 0){
                                                    for (int i=0 ; i<courses.size() ;i++){
                                                        System.out.println((i+1) + "." + courses.get(i).getName());
                                                    }
                                                    int num4;
                                                    System.out.print("Enter number : ");
                                                    num4 = adminScanner.nextInt();
                                                    System.out.println(courses.get(num4-1));
                                                }else {
                                                    System.out.println("List is Empty!!!");
                                                }
                                            }break;
                                            case 3:{
                                                r12 = false;
                                            }break;
                                        }
                                    }
                                }break;
                                case 3: {
                                    boolean r13 = true;
                                    while (r13){
                                        System.out.println("AdminMenu(Field)");
                                        System.out.println("***************");
                                        System.out.println("1.Add");
                                        System.out.println("2.Show");
                                        System.out.println("3.Add Course");
                                        System.out.println("4.Exit");
                                        System.out.println("***************");
                                        int num3;
                                        System.out.print("Enter number : ");
                                        num3 = adminScanner.nextInt();
                                        switch (num3){
                                            case 1:{
                                                adminScanner = new Scanner(System.in);
                                                String name , collage;
                                                int currentTerm ;
                                                double average;
                                                System.out.print("Enter name : ");
                                                name = adminScanner.nextLine();
                                                System.out.print("Enter collage : ");
                                                collage = adminScanner.nextLine();
                                                System.out.print("Enter currentTerm : ");
                                                currentTerm = adminScanner.nextInt();
                                                System.out.print("Enter avarage : ");
                                                average = adminScanner.nextDouble();
                                                Field field = new Field(name,currentTerm,average,collage);
                                                fields.add(field);
                                                writeFromMemory(4);
                                            }break;
                                            case 2:{
                                                adminScanner = new Scanner(System.in);
                                                if (fields.size() > 0){
                                                    for (int i=0 ; i<fields.size() ;i++){
                                                        System.out.println((i+1) + "." + fields.get(i).getName());
                                                    }
                                                    int num4;
                                                    System.out.print("Enter number : ");
                                                    num4 = adminScanner.nextInt();
                                                    System.out.println(fields.get(num4-1));
                                                }else {
                                                    System.out.println("List is Empty!!!");
                                                }
                                            }break;
                                            case 3:{
                                                adminScanner = new Scanner(System.in);
                                                if (fields.size() > 0){
                                                    for (int i=0 ; i<fields.size() ;i++){
                                                        System.out.println((i+1) + "." + fields.get(i).getName());
                                                    }
                                                    int num4;
                                                    System.out.print("Enter number : ");
                                                    num4 = adminScanner.nextInt();
                                                    Field field = fields.get(num4-1);
                                                    adminScanner = new Scanner(System.in);
                                                    if (courses.size() > 0){
                                                        for (int i=0 ; i<courses.size() ;i++){
                                                            System.out.println((i+1) + "." + courses.get(i).getName());
                                                        }
                                                        int num5;
                                                        System.out.print("Enter number : ");
                                                        num5 = adminScanner.nextInt();
                                                        Course course = courses.get(num5-1);
                                                        System.out.println("1.Mandatory");
                                                        System.out.println("2.Voluntary");
                                                        int num6;
                                                        System.out.print("Enter number : ");
                                                        num6 = adminScanner.nextInt();
                                                        if (num6 == 1){
                                                            field.addToCompulsoryCourses(course);
                                                        }else {
                                                            field.addToVoluntaryCourses(course);
                                                        }
                                                        writeFromMemory(4);
                                                    }else {
                                                        System.out.println("Course List is Empty!!!");
                                                    }
                                                }else {
                                                    System.out.println("List is Empty!!!");
                                                }
                                            }break;
                                            case 4:{
                                                r13 = false;
                                            }break;
                                        }
                                    }
                                }break;
                                case 4: {
                                    boolean r14 = true;
                                    while (r14){
                                        System.out.println("AdminMenu(Student)");
                                        System.out.println("***************");
                                        System.out.println("1.Add");
                                        System.out.println("2.Show");
                                        System.out.println("3.Take Course");
                                        System.out.println("4.Add student subject score");
                                        System.out.println("5.Edit semester");
                                        System.out.println("6.Exit");
                                        System.out.println("***************");
                                        int num3;
                                        System.out.print("Enter number : ");
                                        num3 = adminScanner.nextInt();
                                        switch (num3){
                                            case 1:{
                                                adminScanner = new Scanner(System.in);
                                                System.out.println("1.NormalStudent");
                                                System.out.println("2.TalentedStudent");
                                                System.out.println("3.SeniorStudent");
                                                System.out.print("Enter number : ");
                                                int num5 = adminScanner.nextInt();

                                                adminScanner = new Scanner(System.in);
                                                String name,family,nationalCode;
                                                int term , studentNumber;
                                                System.out.print("Enter name : ");
                                                name = adminScanner.nextLine();
                                                System.out.print("Enter family : ");
                                                family = adminScanner.nextLine();
                                                System.out.print("Enter nationalCode : ");
                                                nationalCode = adminScanner.nextLine();
                                                System.out.print("Enter term : ");
                                                term = adminScanner.nextInt();
                                                System.out.print("Enter studentNumber : ");
                                                studentNumber = adminScanner.nextInt();
                                                for (int i=0 ; i<fields.size() ;i++){
                                                    System.out.println((i+1) + "." + fields.get(i).getName());
                                                }
                                                int num4;
                                                System.out.print("Enter number : ");
                                                num4 = adminScanner.nextInt();
                                                Field field = fields.get(num4-1);

                                                if (num5 == 1){
                                                    NormalStudent normalStudent = new NormalStudent(name,family,studentNumber,nationalCode,field,term);
                                                    students.add(normalStudent);
                                                    writeFromMemory(2);
                                                }else if (num5 == 2){
                                                    TalentedStudent talentedStudent = new TalentedStudent(name,family,studentNumber,nationalCode,field,term);
                                                    students.add(talentedStudent);
                                                    writeFromMemory(2);
                                                }else {
                                                    SeniorStudent seniorStudent = new SeniorStudent(name,family,studentNumber,nationalCode,field,term);
                                                    students.add(seniorStudent);
                                                    writeFromMemory(2);
                                                }
                                            }break;
                                            case 2:{
                                                adminScanner = new Scanner(System.in);
                                                if (students.size() > 0){
                                                    for (int i=0 ; i<students.size() ;i++){
                                                        System.out.println((i+1) + "." + students.get(i).getName() + students.get(i).getFamily());
                                                    }
                                                    int num4;
                                                    System.out.print("Enter number : ");
                                                    num4 = adminScanner.nextInt();
                                                    System.out.println(students.get(num4-1));
                                                }else {
                                                    System.out.println("List is Empty!!!");
                                                }
                                            }break;
                                            case 3:{
                                                adminScanner = new Scanner(System.in);
                                                if (students.size() > 0){
                                                    for (int i=0 ; i<students.size() ;i++){
                                                        System.out.println((i+1) + "." + students.get(i).getName() + students.get(i).getFamily());
                                                    }
                                                    int num4;
                                                    System.out.print("Enter number : ");
                                                    num4 = adminScanner.nextInt();
                                                    Student student = students.get(num4-1);
                                                    adminScanner = new Scanner(System.in);
                                                    if (courses.size() > 0){
                                                        for (int i=0 ; i<courses.size() ;i++){
                                                            System.out.println((i+1) + "." + courses.get(i).getName());
                                                        }
                                                        int num6;
                                                        System.out.print("Enter number : ");
                                                        num6 = adminScanner.nextInt();
                                                        Course course = courses.get(num6-1);
                                                        boolean result = student.addCourse(course);
                                                        if (result){
                                                            student.addSelectedCourse(course);
                                                            course.ReduceCapacity(1);
                                                            course.addStudent(student);
                                                            writeFromMemory(2);
                                                            writeFromMemory(3);
                                                        }else {
                                                            System.out.println("Add Course Error!!!");
                                                        }
                                                    }else {
                                                        System.out.println("Course List is Empty!!!");
                                                    }

                                                }else {
                                                    System.out.println("List is Empty!!!");
                                                }
                                            }break;
                                            case 4:{
                                                adminScanner = new Scanner(System.in);
                                                if (students.size() > 0){
                                                    for (int i=0 ; i<students.size() ;i++){
                                                        System.out.println((i+1) + "." + students.get(i).getName() + students.get(i).getFamily());
                                                    }
                                                    int num4;
                                                    System.out.print("Enter number : ");
                                                    num4 = adminScanner.nextInt();
                                                    Student student = students.get(num4-1);

                                                    adminScanner = new Scanner(System.in);
                                                    if (student.getSelected().size() > 0){
                                                        for (int i = 0; i<student.getSelected().size() ; i++){
                                                            System.out.println((i+1) + "." + student.getSelected().get(i).getName());
                                                        }
                                                        int num6;
                                                        System.out.print("Enter number : ");
                                                        num6 = adminScanner.nextInt();
                                                        float mark;
                                                        System.out.print("Enter mark : ");
                                                        mark = adminScanner.nextFloat();
                                                        student.setMark(num6-1,mark);
                                                        writeFromMemory(2);
                                                    }else {
                                                        System.out.println("Selected Course List is Empty!!!");
                                                    }

                                                }else {
                                                    System.out.println("List is Empty!!!");
                                                }
                                            }break;
                                            case 5:{
                                                adminScanner = new Scanner(System.in);
                                                if (students.size() > 0){
                                                    for (int i=0 ; i<students.size() ;i++){
                                                        System.out.println((i+1) + "." + students.get(i).getName() + students.get(i).getFamily());
                                                    }
                                                    int num4;
                                                    System.out.print("Enter number : ");
                                                    num4 = adminScanner.nextInt();
                                                    Student student = students.get(num4-1);
                                                    int term;
                                                    System.out.print("Enter term : ");
                                                    term = adminScanner.nextInt();
                                                    student.setTerm(term);
                                                    writeFromMemory(2);
                                                }else {
                                                    System.out.println("List is Empty!!!");
                                                }
                                            }break;
                                            case 6:{
                                                r14 = false;
                                            }break;
                                        }
                                    }
                                }break;
                                case 5: {
                                    r1 = false;
                                }break;
                            }
                        }
                    }else {
                        System.out.println("username or password incorrect!!!");
                        System.out.println("try again!!!");
                    }
                }break;
                case 2: {
                    Scanner courseScanner = new Scanner(System.in);
                    int ID;
                    boolean found = false;
                    Course course = null;
                    System.out.print("Enter ID Of course : ");
                    ID = courseScanner.nextInt();
                    for (int i=0 ; i<courses.size() ; i++){
                        if (courses.get(i).getId() == ID){
                            course = courses.get(i);
                            found = true;
                        }
                    }
                    if (found){
                        boolean r2 = true;
                        while (r2){
                            System.out.println("Menu");
                            System.out.println("***************");
                            System.out.println("1.Show related student");
                            System.out.println("2.Edit capacity");
                            System.out.println("3.Exit");
                            System.out.println("***************");
                            int num2;
                            courseScanner = new Scanner(System.in);
                            System.out.print("Enter number : ");
                            num2 = courseScanner.nextInt();
                            switch (num2){
                                case 1:{
                                    System.out.println(course.getStudents());
                                }break;
                                case 2:{
                                    int newCapacity;
                                    courseScanner = new Scanner(System.in);
                                    System.out.print("Enter number : ");
                                    newCapacity = courseScanner.nextInt();
                                    course.setCapacity(newCapacity);
                                    writeFromMemory(3);
                                }break;
                                case 3:{r2 = false;}break;
                            }
                        }
                    }else {
                        System.out.println("Course not found!!!");
                    }
                }break;
                case 3: {
                    Scanner studentScanner = new Scanner(System.in);
                    int ID;
                    String studentPassword;
                    boolean found = false;
                    Student student = null;
                    System.out.print("Enter ID : ");
                    ID = studentScanner.nextInt();
                    studentScanner = new Scanner(System.in);
                    System.out.print("Enter password : ");
                    studentPassword = studentScanner.nextLine();

                    for (int i=0 ; i<students.size() ; i++){
                        if (students.get(i).getStudentNumber() == ID && students.get(i).getPassword().equals(studentPassword)){
                            student = students.get(i);
                            found = true;
                        }
                    }

                    if (found){
                        boolean r3 = true;
                        while (r3){
                            System.out.println("StudentMenu");
                            System.out.println("***************");
                            System.out.println("1.Show my course");
                            System.out.println("2.Edit password");
                            System.out.println("3.Exit");
                            System.out.println("***************");
                            int num2;
                            studentScanner = new Scanner(System.in);
                            System.out.print("Enter number : ");
                            num2 = studentScanner.nextInt();
                            switch (num2){
                                case 1:{
                                    studentScanner = new Scanner(System.in);
                                    System.out.println("1.pass course");
                                    System.out.println("2.selected course");
                                    int num = studentScanner.nextInt();
                                    if (num ==1){
                                        System.out.println(student.getPassed());
                                    }else if(num ==2){
                                        System.out.println(student.getSelected());
                                    }
                                }break;
                                case 2:{
                                    String newPassword;
                                    studentScanner = new Scanner(System.in);
                                    System.out.print("Enter new password : ");
                                    newPassword = studentScanner.nextLine();
                                    student.setPassword(newPassword);
                                    writeFromMemory(2);
                                }break;
                                case 3:{r3 = false;}break;
                            }
                        }
                    }else {
                        System.out.println("student not found!!!");
                    }
                }break;
                case 4: {
                    Scanner professorScanner = new Scanner(System.in);
                    int ID;
                    String professorPassword;
                    boolean found = false;
                    Professor professor = null;

                    System.out.print("Enter ID : ");
                    ID = professorScanner.nextInt();
                    professorScanner = new Scanner(System.in);
                    System.out.print("Enter password : ");
                    professorPassword = professorScanner.nextLine();

                    for (int i=0 ; i<professors.size() ; i++){
                        if (professors.get(i).getProfessorCode() == ID && professors.get(i).getPassword().equals(professorPassword)){
                            professor = professors.get(i);
                            found = true;
                        }
                    }

                    if (found){
                        boolean r4 = true;
                        while (r4){
                            System.out.println("ProfessorMenu");
                            System.out.println("***************");
                            System.out.println("1.Show my info");
                            System.out.println("2.Exit");
                            System.out.println("***************");
                            int num2;
                            professorScanner = new Scanner(System.in);
                            System.out.print("Enter number : ");
                            num2 = professorScanner.nextInt();
                            switch (num2){
                                case 1:{
                                    System.out.println(professor);
                                }break;
                                case 2:{r4 = false;}break;
                            }
                        }
                    }else {
                        System.out.println("professor not found!!!!");
                    }
                };break;
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        init();
        showMenu();
    }
}
