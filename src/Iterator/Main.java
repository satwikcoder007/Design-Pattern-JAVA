package Iterator;

interface Iterator{
    public Boolean hasNext();
    public User Next();
}



 class IteratorImple implements Iterator
{
    User[] arr;
    private int pos=0;
    IteratorImple(User[] arr){
        this.arr = arr;
    }
    public Boolean hasNext(){
        if(pos<arr.length) return true;
        return false;
    }
    public User Next(){
        User u =  arr[pos];
        pos++;
        return u;
    }
}


 class UserManagement{
    User[] arr = new User[5];
    int pos = 0;
    public void addUser(String name,int age){
        User u = new User(name,age);
        arr[pos] = u;
        pos++;
    }
    public IteratorImple getIterator(){
        return new IteratorImple(arr);
    }

}

 class User{
    String name;
    int age;
    User(String name,int age){
        this.name = name;
        this.age = age;
    }
}
public class Main{
    public static void main(String[] args) {
        UserManagement obj = new UserManagement();
        obj.addUser("satwik",20);
        obj.addUser("priyosi",19);
        obj.addUser("modak",19);
        obj.addUser("diptashi",20);
        obj.addUser("piyam",20);
        Iterator it = obj.getIterator();
        while(it.hasNext()){
            User u = it.Next();
            System.out.println(u.name+"     "+u.age);
        }
    }
}

