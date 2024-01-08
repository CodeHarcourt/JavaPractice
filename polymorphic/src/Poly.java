class Animal{
    // 方法名与类名一致
    // 构造方法在创建时不需要返回值，返回值默认为创建一个类
    // 可以通过不同的传入参数，进行方法重写
    public Animal(){
        System.out.println("Animal");
    }
    public void cry(){
        System.out.println("动物叫");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
}

class dog extends Animal{
    public dog(){
        System.out.println("dog");
    }
    public void cry(){
        System.out.println("狗叫");
    }
    public void keepHouse(){
        System.out.println("狗看家");
    }
}

class cat extends Animal{
    public void cry(){
        System.out.println("猫叫");
    }

    public void play(){
        System.out.println("猫玩耍");
    }
}

// 局部变量调用时 具有就近一致原则
public class Poly {
    public static void main(String[] args) {
        Animal dog = new dog();
        Animal cat = new cat();
        // 此时由于多态性，只会使用父类中的方法（当调用子类中重写父类的方法时，会使用子类的方法）
        cat.cry();
        dog.cry();
        // 创建子类对象时，先创建父类对象，调用父类对象构造方法
        dog Dog = new dog();
        System.out.println("Hello world!");
        System.out.flush();
    }
}

