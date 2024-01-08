import static java.lang.Math.sqrt;

public abstract class Geometric {
    String color;
    Boolean filled;
    Geometric(){}
    Geometric(String color, Boolean filled){
        this.color = color;
        this.filled = filled;
    }
    abstract double  getArea();
    abstract double getPerimeter();
    public String toString(){
        return ("圆的颜色为" + color + "，圆是否被填充" + filled);
    }
}

class Circle1 extends Geometric{
    private double radius;
    Circle1(){}
    Circle1(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }

    public double getArea(){
        return (3.14 * radius * radius);
    }

    public double getPerimeter(){
        return (2 * 3.14 * radius);
    }

    public String toString(){
        return ("圆的半径为" + getRadius() + "，圆的面积为" + getArea() + "圆的周长为" + getPerimeter());
    }
}

class Rectangle extends Geometric{
    double side1;
    double side2;
    Rectangle(){}
    Rectangle(double side1, double side2){
        this.side1 = side1;
        this.side2 = side2;
    }
    double getSide1(){
        return side1;
    }
    double getSide2(){
        return side2;
    }
    double getArea(){
        return side1 * side2;
    }
    double getPerimeter(){
        return 2 * (side1 + side2);
    }
    public String toString(){
        return ("矩形的周长为" + getPerimeter() + "矩形的面积为" + getArea() + "矩形的边长分别为" + side1 + "、" +side2);
    }
}

class Triangle1 extends Geometric{
    double side1;
    double side2;
    double side3;
    Triangle1(){

    }
    Triangle1(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    double getSide1(){
        return side1;
    }
    double getSide2(){
        return side2;
    }
    double getSide3(){
        return side3;
    }
    boolean isTriangle(){
        if((side1 + side2 > side3) && (side2 + side3 > side1) && (side1 + side3 > side2))
            return true;
        return false;
    }
    public String toString(){
        double min = side1;
        if(min > side2){
            min = side2;
        }
        if(min > side3){
            min = side3;
        }
        return ("三角形较小的边长度为" + min);
    }
    double getPerimeter(){
        return (side1 + side2 + side3);
    }
    double getArea(){
        double p = getPerimeter() / 2;
        return sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
}
