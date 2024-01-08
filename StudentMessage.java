import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentMessage {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生个人信息，顺序为（学号、姓名、性别、年龄、成绩）：");
        StringBuilder sb = new StringBuilder(sc.nextLine());
        String str = sb.toString();
        String[] strNum = str.split("、");
        Student st = new Student(strNum[0], strNum[1],  strNum[2], Integer.parseInt(strNum[3]), Double.parseDouble(strNum[4]));
        st.PrintInfo();
    }
}
class Student{
    String StudentID;
    String StudentName;
    int age;
    String gender;
    double grade;
    Student(){}
    Student(String StudentID, String StudentName, String gender, int age, double grade){
        try{
            if(StudentID.equals("") || StudentName.equals("") || age < 18 || age > 25 || grade < 0 || grade > 100 ||
                (!gender.equals("male") & !gender.equals("female")))
                throw new MessageErrorException();
            this.StudentID = StudentID;
            this.StudentName = StudentName;
            this.age = age;
            this.gender = gender;
            this.grade = grade;
        }catch(MessageErrorException e){
            System.out.println("学生信息输入有误，请重新输入");
        }
    }
    void PrintInfo(){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        System.out.printf("学生信息创建的时间为%s\n" +
            "该学生的学号、姓名、年龄、性别、成绩依次为:%s、%s、%d、%s、%s%n", df.format(date), StudentID, StudentName, age, gender, grade);
    }
}
class MessageErrorException extends RuntimeException{
    MessageErrorException(){super();}
    MessageErrorException(String Message){super(Message);}
}
