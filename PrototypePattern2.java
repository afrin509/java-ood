
interface visualObject
{
    visualObject Clonebject();
    void createObject();
}
class Room implements visualObject
{
    public int length, height;
    public String shape;
    Room(int length,int height,String shape)
    {
        this.length=length;
        this.height=height;
        this.shape=shape;
    }
    public Room Clonebject()
    {
        return new Room(this.length,this.height,this.shape);
    }


    public Room setObject(int length,int height,String shape)
    {
         this.length=length;
         this.height=height;
         this.shape=shape;
         return this.Clonebject();
    }
    public void createObject() {
        System.out.println("Creating Room: " + this.length + " " + this.height+ " "+this.shape);
    }
}

class Ladder implements visualObject
{
   public int steps;
    public String color;
    Ladder(int steps,String color)
    {
        this.steps=steps;
        this.color=color;
    }
    public Ladder Clonebject()
    {
        return new Ladder(this.steps,this.color);
    }
    public Ladder setObject(int steps,String color)
    {
        this.steps=steps;
        this.color=color;
        return this.Clonebject();
    }
    public void createObject() {
        System.out.println("Creating Ladder: " + this.steps + " " + this.color);
    }

}
class Wall implements visualObject
{
    public String type;
    // lets say we have types like wooden,metal,glass

    Wall(String type)
    {
       this.type=type;
    }
    public Wall Clonebject()
    {
        return new Wall(this.type);
    }

    public Wall setObject(String type)
    {
        this.type=type;
        return this.Clonebject();
    }
    public void createObject() {
        System.out.println("Creating Wall: " + this.type );
    }

}
interface MazeInterface{
     Room setRoom(Room room);
     Wall setWall(Wall wall);
     Ladder setLadder(Ladder ladder);
    void displayMaze();
}
class CreateMaze implements MazeInterface{
    private Room room=null;
    private Wall wall=null;
    private Ladder ladder=null;

    //to create a maze with multiple optional parameters we have to use method overloading for constructor for creating different type of combinations
    // which is tidous to right so many constructoes if you want to use this kind of optional paramters for creating maze that can be acheived by builder method
   public CreateMaze(Room room, Wall wall, Ladder ladder) {
       this.room = room.Clonebject();
       this.wall = wall.Clonebject();
       this.ladder = ladder.Clonebject();
    }
    public CreateMaze CloneMaze()
    {
        return new CreateMaze(this.room,this.wall,this.ladder);
    }
    public Room setRoom(Room room)
    {
         return this.room=room.Clonebject();
    }
    public Wall setWall(Wall wall)
    {
        return this.wall=wall.Clonebject();
    }
    public Ladder setLadder(Ladder ladder)
    {
        return this.ladder=ladder.Clonebject();
    }
    public void displayMaze() {
        room.createObject();
        wall.createObject();
        ladder.createObject();
    }

}



public class PrototypePattern2 {
    public static void main (String args[])
    {
//       create concrete prototypes --> room,wall,ladder

        Ladder l1=new Ladder(20,"yellow");
        Room r1=new Room(20,60,"Rectangle");
        Wall w1=new Wall("Lime plaster");
        //create a cleint that gets the clone of each
        CreateMaze prototypeClientMaze=new CreateMaze(r1,w1,l1);
        prototypeClientMaze.displayMaze();

        CreateMaze mazeLevel2=prototypeClientMaze.CloneMaze();
        mazeLevel2.displayMaze();
        mazeLevel2.setRoom(r1.setObject(12,24,"Circle"));
        mazeLevel2.setLadder(l1.setObject(30,"Brown"));
        mazeLevel2.setWall(w1.setObject("plaster of paris"));
        mazeLevel2.displayMaze();



    }
}

