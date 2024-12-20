//prototype for creating shape and cloning objects
//class Shape{
//
//}
//prototype interface
interface Shape{
    Shape Clone(); // to return shape (instance of the object)
    void Draw();
}
// concrete  prototype let s say it is implmenting above prototype
class Circle implements Shape{
public String r;
    Circle(String radius)
    {
        this.r=radius;
    }
    public Shape Clone()
    {
        return new Circle(this.r);
    }
    public void Draw()
    {
        System.out.println("drawing the circle of radius"+this.r);
    }
}
//concrete prototype providing the rectangle
class Rectangle1 implements Shape{
    public int l, b;
    Rectangle1(int length,int breadth)
    {
        this.l=length;
        this.b=breadth;
    }
    public Shape Clone()
    {
        return new Rectangle1(3,4);
    }
    public void Draw()
    {
        System.out.println("drawing the rectangle of length"+this.l+"breadth"+this.b);
    }
}
class Clientpd {
    private Shape shape1;
    public Clientpd(Shape s)
    {
        this.shape1=s;
    }

    Shape getClone()
    {
        // want to create the clone of shape s then call it method
      return  shape1.Clone();
    }
}
public class PrototypeDesign {
    public static void main (String args[])
    {
        //create a concrete prototype
        Circle c1=new Circle("4");
       // send the proptype for client to get the clone of the concrete prototype
       Shape shape1=new Clientpd(c1).getClone();
       // check the prototype
        shape1.Draw();
    }
}
