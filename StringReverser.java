import java.util.Scanner;

public class StringReverser {
    public static String reverseString(String waitString){
        if(waitString.equals("null"))
            throw new NullStringException("传入的字符串为空");
        StringBuilder sb = new StringBuilder(waitString);
        return  sb.reverse().toString();
    }
    public static void main(String[] args) throws NullStringException{
        String str;
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                System.out.print("请输入字符串：");
                str = sc.nextLine();
                System.out.println("反转后的字符串为" + reverseString(str));
            }catch(NullStringException e){
                System.out.println("传入的字符串为空");
                break;
            }
        }
    }
}
class NullStringException extends RuntimeException{
    NullStringException(){super();}
    NullStringException(String message){super(message);}
}
