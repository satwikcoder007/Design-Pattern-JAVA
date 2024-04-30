package Visitor;
interface Animal{
    public String getName();
    public void accept(Visitor ob);// accept function is basically used to call any function we want

}

class Dog implements Animal{
    public String getName(){
        return "DOG";
    }
    public void accept(Visitor ob){  //The accept function take the Concrete Visitor i.e. the functionality as parameter and call it using this
        ob.visit(this);
    }
}
class Cat implements Animal{
    public String getName(){
        return "CAT";
    }
    public void accept(Visitor ob){
        ob.visit(this);
    }
}
class Snake implements Animal{
    public String getName(){
        return "SNAKE";
    }
    public void accept(Visitor ob){
        ob.visit(this);
    }
}

interface Visitor{
    //This interface contain the overloaded version of Visitor that we need to implement
    public void visit(Dog ob);
    public void visit(Cat ob);
    public void visit(Snake ob);
}

class MakeSound implements Visitor{//ConcreteVisitor
    public void visit(Dog ob){
        System.out.println("Bark");
    }
    public void visit(Cat ob){
        System.out.println("Mew");
    }
    public void visit(Snake ob){
        System.out.println("Hiss");
    }

}
class LegCount implements Visitor{//ConcreteVisitor
    public void visit(Dog ob){
        System.out.println("4 legs");
    }
    public void visit(Cat ob){
        System.out.println("4 legs");
    }
    public void visit(Snake ob){
        System.out.println("0 legs");
    }

}

public class Main{
    public static void main(String[] args) {
        Visitor func1 = new MakeSound();   //concreteVisitor1
        Visitor func2 = new LegCount();     //concreteVisitor2

        Cat cat = new Cat();
        Dog dog = new Dog();
        Snake snake = new Snake();

        cat.accept(func1);
        dog.accept(func1);
        snake.accept(func1);

        cat.accept(func2);
        dog.accept(func2);
        snake.accept(func2);



    }
}
