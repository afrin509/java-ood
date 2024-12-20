import java.util.Scanner;
 //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Rectangle{
    public  int length,breadth;
    Rectangle()
    {
        this.length=2;
        this.breadth=3;
    }
    Rectangle(int l,int b)
    {
        this.length=l;
        this.breadth=b;
    }
    public double area()
    {
        return this.length*this.breadth;
    }
    public double permieter()
    {
        return 2*(this.length+this.breadth);
    }


 }
 class Cubiod extends Rectangle{
    public int height=0;
    Cubiod(int h)
    {
        super(4,5);
        this.height=h;
    }
    public double volume1()
    {
        return length*breadth*height;
    }




 }
 interface BasicAnimal{

      void eat();
      void sleep();
 }
 class Monkey {
    void jump()
    {
        System.out.println("Monkey Jumping ....");
    }
    void bite()
    {
        System.out.println("Monkey Biting ....");
    }
 }
  class HumanBeing extends Monkey implements BasicAnimal{
//    @Override
    public void eat()
    {
        System.out.println("HumanBeing Eating ....");
    }
     public void sleep()
     {
         System.out.println("HumanBeing Sleeping ....");
     }

 }
// class HumanV1 extends HumanBeing
// {
//     @Override
//    public void eat1()
//     {
//         System.out.println("eat1 Eating ....");
//
//     }
// }

abstract  class Pen {

    abstract void write();
    abstract void refill();

}
abstract class TelePhone{
    abstract void ring();
    abstract void lift();
    abstract void disconnect();
}
class SmartPhone extends TelePhone
{
    void ring()
    {
        System.out.println("Smartphone Ringing ...");
    }
    void lift()
    {
        System.out.println("Smartphone Lifting ...");
    }
    void disconnect() {
        System.out.println("Smartphone Disconnecting ...");
    }
    void calling()
    {
        System.out.println("Smartphone Calling ...");
    }

}


class ButterFlow extends Pen{

    @Override
    void write()
    {
        System.out.println("Smooth Writing ....");
    }
    void refill()
    {
        System.out.println("Smooth Refilling ....");
    }
    void changeNib()
    {
        System.out.println("Changing Nib ....");
    }


 }
 interface TVRemote {
       void turnOn();
       void turnOff();
 }
 interface SmartTvRemote extends TVRemote
 {
       void voiceControllerOn();
       void voiceControllerOff();
 }

public class Main {
    public static void main(String[] args) {
        ButterFlow pen1=new ButterFlow();
        pen1.write();
        pen1.refill();
        pen1.changeNib();
        HumanBeing human = new HumanBeing();
        human.jump();   // Outputs: Monkey Jumping ....
        human.bite();   // Outputs: Monkey Biting ....
        human.eat();    // Outputs: HumanBeing Eating ....
        human.sleep();
        TelePhone nokia=new SmartPhone();
        nokia.ring();
        nokia.lift();
        nokia.disconnect();

//        nokia.calling()  though this is present in smartphone object but the type you have defined it does not have this method so leave it


    }
}