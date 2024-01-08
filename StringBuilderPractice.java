import java.util.Scanner;

public class StringBuilderPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("请输入待反转的字符串：");
            String WaitMessage = sc.nextLine();
            if(WaitMessage.equals(""))
                throw new NoInputException();
            System.out.println("反转后的字符串为：" + StringReverse.reverse(WaitMessage));
        }catch(NoInputException e){
            System.out.println("输入无效");
        }
    }
}
class StringReverse{
    static String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
class NoInputException extends RuntimeException{
    NoInputException(){super();}
    NoInputException(String Message){super(Message);}
}
