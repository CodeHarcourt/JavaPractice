public class readCode {
//    public static void main(String[] args) {
//    int  x=1,y=1,z=1;
//    if (--x==0 && y++==1||z++==1)
//        // 这里要注意||是短路运算符，而--x==0 && y++==1部分恒为真，所以z++==1不会执行
//        System.out.println("x="+x+",y="+y+",z="+z);
//    }
    public static void main(String[] args){
        for(int i = 10; i < 21 ; i++)
            if(i % 3 != 0 && i % 5 != 0 )
                System.out.print(i + "\t、");
        System.out.println();
        outer:
        for (int i=1;i<3;i++)
            for (int j=1;j<4;j++)
            {
                if (i==1 && j==2)
                    continue outer;
                System.out.println("i="+i+"  j="+j);
            }
        // 这里的outer是一个标签，用于标记外部循环
        // 上述语句的运行过程为：当内层循环中的值i = 1, j = 2时，跳出内部循环，进行下一次外部循环的迭代
        // Java中的自动类型转换方法默认从较小类型到较大类型的转换
        A m1 = new A(25);
        System.out.println(m1.v);
        System.out.println(A.name);
        A m2 = new A();
        System.out.println(m2.v);
    }

}
class A {
    int v=0;
    {   v=v+1;
        // 初始化块的作用在于当未创建对象时，初始化块在每一个类进行声明后都会自动运行
        // （在创建对象之前执行的一段代码，用于对对象的初始状态进行设置）
    }
    // 类中的静态变量可以直接通过类名进行访问，而无需创建类的对象
    static String name;
    static {
        name = "hhh";
        // 静态初始化块只在类初次加载时按顺序运行一次，并自动存放至静态存储区中
    }
    public A( ) {   }
    public A(int x ) {   v=x;   }

}

class Test5 {
    int k = 8;
    public  void doSome() {
        System.out.println("k1="+k);
    }
}
class Sub extends Test6 {
    int k = 66;
    public  void doSome() {
        k=k-2;
        System.out.println("k2="+k);
    }
    public static void main(String args []) {
        Test6 obj = new Sub();
        // Java中多态的一种体现形式,obj是父类的引用，指向子类的对象
        // 当调用子类与父类中相同名字的方法是，会调用子类中重载的方法
        // 而当调用对象中的属性是会调用父类的属性
        obj.doSome();
        System.out.println("k3="+obj.k);
    }
}

class Foo {
    public static void main (String [ ] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);
        System.out.println(a + "," +b);
    }
    static void operate (StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
        // operate函数的形式参数x，y都是引用数据类型，x指向a，y指向b，当使用x.append(y)函数时，是在x指向的a上进行操作
        // 当使用 y = x时，是将y的指向由开始的指向b修改为指向x所指向的a，而这个操作并不会修改b中的值以及b的引用
    }
}

abstract class  P{
    public P() { System.out.println("parent"); }
    abstract void m();
}
class S extends P {
    public S() {  System.out.println("child"); }
    public static void main(String a[ ]) {
        P  x= new S();
        // 父类引用指向子类对象
        // 在创建子类对象时应先加载父类中的构造方法
        // 随后加载子类构造方法
        x.m();
    }
    void m()  {System.out.println("m()"); }
}

