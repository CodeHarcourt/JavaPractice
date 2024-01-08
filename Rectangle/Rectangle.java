package Rectangle;


public class Rectangle {
    int width, height;
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    public int C(){
        return (this.width + this.height) * 2;
    }

    public int S(){
        return this.width * this.height;
    }

    public static void main(String args[]){
        Rectangle rec = new Rectangle(10, 20);
        System.out.println("矩形的周长为" + rec.C());
        System.out.println("矩形的面积为" + rec.S());
    }
}
