package Task5.model;

public class MyException extends  Exception {
    public MyException(String str, Throwable err){
        super(str,err);
    }
}
