public class StudentScore {

}
class Students{
    String name;
    String StudentsID;
    double[] Scores;
    Students(String name, String StudentsID, double[] Scores){
        try{
        if(name.length() == 0)
            throw new InputFormatException();
        this.name = name;
        if(StudentsID.length() == 0 || StudentsID.length() > 20)
            throw new InputFormatException();
        this.StudentsID = StudentsID;
        this.Scores = Scores;
        }catch(InputFormatException ex){
            System.out.println("输入格式错误");
        }
    }
}
class InputFormatException extends RuntimeException{
    InputFormatException(){super();}
    InputFormatException(String Message){super(Message);}
}
