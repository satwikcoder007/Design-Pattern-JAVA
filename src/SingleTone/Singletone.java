package SingleTone;

import java.util.ArrayList;

class User{
    String name;
    int age;
    User(String n,int a){
        this.name = n;
        this.age = a;
    }
}
class Singleton{

    private static Singleton instance=null; //This is declared static because getInstance is using this
    ArrayList<User> list;

    private Singleton(){
        list = new ArrayList<>();
    }
    public synchronized void addUser(String n,int a){
        User u = new User(n,a);
        list.add(u);
    }
    public static synchronized Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
            System.out.println("creatig the only instance");
        }
        return instance;
    }
}

class Main{
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        obj.addUser("satwik",20);
        obj.addUser("indra",19);
        obj.addUser("mrinmoy",20);
        for(int i=0;i<obj.list.size();i++){
            User u = obj.list.get(i);
            System.out.println(u.name+" "+u.age);
        }
    }
}