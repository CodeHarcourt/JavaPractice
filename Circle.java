public class Circle {
    double radius;
    Circle(){}
    Circle(double radius){
        this.radius = radius;
    }
    void setRadius(double radius){
        if(radius < 0)
            throw new InvalidRadiusException();
        this.radius = radius;
    }
}
class InvalidRadiusException extends RuntimeException{
    InvalidRadiusException(){super();}
    InvalidRadiusException(String message){super(message);}
}
