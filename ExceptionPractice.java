import java.util.Scanner;

public class ExceptionPractice {
    // 抛出异常写在方法体中，告知调用者出错
    // 捕获异常写在方法调用处，保证程序不会停止
    static class MyGirlfriend{
        String name;
        int age;
        MyGirlfriend(String name, int age) throws Exception{
            if(name.length() >= 3 && name.length()<= 10)
                this.name = name;
            else throw new Exception();
            if(age >= 18 && age<= 40)
                this.age = age;
            else throw new Exception();
//            this.name = name;
//            this.age = age;
        }
        public String toString(){
            return ("女朋友的姓名为" + this.name + "女朋友的年龄为" + this.age);
        }
    }
    public static void main(String args[]){
        boolean flag = true;
        while(flag) {
            System.out.print("请输入心仪女朋友的姓名与年龄(输入格式为：姓名，年龄)：");
            Scanner sc = new Scanner(System.in);
            String com = sc.nextLine();
            String[] parts = com.split("，");
            String name = parts[0].trim();
            try {
                int age = Integer.parseInt(parts[1].trim());
                MyGirlfriend myGirlfriend= new MyGirlfriend(name, age);
                flag = false;
                System.out.println(myGirlfriend.toString());
            } catch (Exception e) {
                System.out.println("年龄格式错误");
            }
        }

    }
}
