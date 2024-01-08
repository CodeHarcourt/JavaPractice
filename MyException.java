public class MyException extends RuntimeException{
    // 运行时异常：继承RuntimeException
    // 编译时异常：直接继承Exception 核心：提醒程序员检查本地信息

    // 自定义异常时需注意将，重写空参构造和带参构造
    public MyException(){}
    public MyException(String message){
        super(message);
    }
}
