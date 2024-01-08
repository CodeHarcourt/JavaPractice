public class Triangle {
    double side1;
    double side2;
    double side3;
    Triangle(){}
    Triangle(double side1, double side2, double side3){
        if((side1 + side2) <= side3 || (side3 + side2) <= side1 || (side1 + side3) <= side2)
            throw new IllegalTriangleException();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
}
class IllegalTriangleException extends RuntimeException{
    IllegalTriangleException(){super();}
    IllegalTriangleException(String message){super(message);}
}
