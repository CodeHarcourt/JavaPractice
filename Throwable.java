public class Throwable {
    // 编译时异常：在编译阶段抛出，必须手动处理
    // 运行时异常，在运行期间抛出
    // throw new RuntimeException()抛出异常
    // 异常的作用：1.查询bug的关键参考信息
    //           2.作为方法内部一种特殊的返回值，以便通知调用者底层的执行情况
    // 异常的处理方式：
    // 1.JVM默认的处理方式：把异常的名称，异常原因，异常出现的位置等信息输出在控制台，程序停止执行
    // 2.自己处理异常（捕获异常）：当代码出现异常时，可以继续执行程序
    //          格式：try{可能出现异常的代码;}
    //      注意：当try中有多个会发生的异常时，底层只会创建一个Exception对象，抛出第一个异常后，剩余try中代码段停止运行，直接执行catch的捕获
    //         写多个catch与之try中的异常对应，异常中存在父子关系时，父类catch写在下面
    //              catch(异常类名 变量名){异常的处理代码;}
    //              finally{}无论是否发生异常均会运行，适用于执行清理操作(关闭文件、断开数据库连接等)
    // catch部分代码块
    // throwable的成员方法：
    //              1.getMessage()：返回此throwable的详细消息字符串
    //              2.toString()：返回此可抛出的简短描述
    //              3.printStackTrace()：把异常的错误信息输出在控制台(仅打印信息，程序继续执行)
    // 3.抛出处理：throws:写在方法定义处，表示声明一个异常，告诉调用者，使用本方法可能会有哪些异常(编译时异常必须要写，运行时异常可以不写)
    public void Throws() throws Exception{
        // 函数体
    }
    //           throw：写在方法内，结束方法，手动抛出异常对象，交给调用者，方法中之后的代码不再执行
    public void Throw(){
        // 手动抛出空指针异常
        throw new NullPointerException();
        // 后面方法体不再执行
    }
}