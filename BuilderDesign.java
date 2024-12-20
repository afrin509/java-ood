class Pizza{
    public int doughType=1,toplingType=1,sauceType=1;
    Pizza(int doughType,int toplingType,int sauceType)
    {
        this.doughType=doughType;
        this.toplingType=toplingType;
        this.sauceType=sauceType;
    }
    void setDoughType( int dough)
    {
        this.doughType=dough;
    }
    void setToplingType(int topling)
    {
        this.toplingType=topling;
    }
    void setSauceType(int sauceType)
    {
        this.sauceType=sauceType;
    }
    void displayInfo()
    {
        System.out.println("this pizza consists of"+ doughType + toplingType + sauceType);
    }
}

abstract class BuilderMethod{
    abstract void buildDough();
   abstract  void buildSauce();
   abstract void buildTopling();
   abstract Pizza getPizza();
}
class SpicyChickenPizza extends BuilderMethod
{
    private Pizza pizza;
    SpicyChickenPizza()
    {
        this.pizza=new Pizza(1,1,1);
    }
    @Override
    void buildDough()
    {
        this.pizza.setDoughType(3);
    }
    void buildSauce()
    {
        this.pizza.setSauceType(3);
    }
    void buildTopling()
    {
        this.pizza.setToplingType(3);
    }

    Pizza getPizza()
    {
       return this.pizza;
    }
}

class CheesePizza extends BuilderMethod{
    private Pizza pizza;
    CheesePizza()
    {
        this.pizza=new Pizza(1,1,1);
    }
    @Override
    void buildDough()
    {
        this.pizza.setDoughType(2);
    }
    void buildSauce()
    {
        this.pizza.setSauceType(2);
    }
    void buildTopling()
    {
        this.pizza.setToplingType(2);
    }
    Pizza getPizza()
    {
        return this.pizza;
    }
}
class PizzaDirector{
    PizzaDirector(BuilderMethod builder)
    {
        builder.buildTopling();
        builder.buildDough();
        builder.buildSauce();
    }

}
public class BuilderDesign {
    public static void  main (String []args)
    {
        BuilderMethod generalPizzaCook=new SpicyChickenPizza();
        PizzaDirector p=new PizzaDirector(generalPizzaCook);

        Pizza pizza=generalPizzaCook.getPizza();
        pizza.displayInfo();
        BuilderMethod generalPizza=new CheesePizza();
        generalPizza.buildSauce();
        generalPizza.buildTopling();
        generalPizza.buildTopling();
        Pizza pizza2=generalPizza.getPizza();
        pizza2.displayInfo();
    }
}
