class Test6 {
    int k = 8;
    public  void doSome() {
        System.out.println("k1="+k);
    }
}
class Sub1 extends Test6 {
    int k = 66;
    public  void doSome() {
        k=k-2;
        System.out.println("k2="+k);
    }
    public static void main(String[] args) {
        Test6 obj = new Sub1();
        // Java中的多态性的体现
        // 父类的引用obj指向创建的子类的对象
        // 当调用方法时会先查看父类中的方法，如果父类的方法在子类中进行了重写，则调用子类对象
        // 当调用属性时，只会查找父类中的属性
        // 注意变量的作用域
        obj.doSome();
        System.out.println("k3="+obj.k);
    }
}
