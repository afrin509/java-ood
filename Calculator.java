import java.util.InputMismatchException;

class CustomException extends Exception
{
    @Override
    public String getMessage()
    {
        return "Input should be less than 7000";
    }
}
class CustomInputMismatch extends InputMismatchException
{
    @Override
    public String getMessage()
    {
        return "Input should be less than 7000";
    }
}
class AfrinCalculator
{
    public  int addition(int a,int b)
    {
        return a+b;
    }
    public int subraction(int a ,int b)
    {
        return a-b;
    }
    public int multiplication(int a,int b) throws InputMismatchException
    {
        if(a>7000||b>7000)
        {
           throw new InputMismatchException();
        }
        return a*b;
    }
    public int division(int a,int b) throws Exception
    {
        if(b==0)
        {
            throw new ArithmeticException();
        }
        return a/b;
    }

}
 class Green {
    public void getColor() {
        System.out.println("Green");
    }
     public void getColor1() {
         System.out.println("Green1");
     }
}

 class Blue extends Green {
//    public void getColor() {
//        System.out.println("Blue");
//    }
//     public void getColor1() {
//         System.out.println("Blue1");
//     }
}


public class Calculator {
    public static void main(String args[])
    {
//        AfrinCalculator a1=new AfrinCalculator();
        Green green = new Blue();
//        Blue blue=new Green();

        green.getColor();
//           try {
////              a1.multiplication(8000,7000);
//               a1.division(10,0);
//           }
//           catch (InputMismatchException i)
//           {
//               System.out.println(i);
//           }
//           catch (ArithmeticException r)
//           {
//               System.out.println(r);
//           }
//           catch(Exception e)
//           {
//               System.out.println(e);
//           }
    }
}
