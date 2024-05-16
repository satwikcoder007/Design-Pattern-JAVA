package Command;

class AC{ //here Ac is the receiver to which is the command is connected
    int state;
    int temperature;
    AC(){
        state=-1;
    }
    public void TurnOn()
    {
        if(state==1){
            System.out.println("AC is already on");
            return;
        }
        state=1;
        System.out.println("AC is turned on");
    }
    public void TurnOff(){
        if(state==0){
            System.out.println("AC is already of");
            return;
        }
        state=0;
        System.out.println("AC is turned off");
    }

    public void setTemperature(int x){
        temperature=x;
        System.out.println("Temperature is set to "+x);
    }
}

interface Command{
    public void execute();
}
//These are the concrete command that is basically the command object having the execute operation
//and connected to a receiver which is in this case the AC
class TurnOnAC implements Command{
    AC ob;
    TurnOnAC(AC ob){
        this.ob=ob;
    }
    @Override
    public void execute() {
        ob.TurnOn();
    }
}
class TurnOffAC implements Command{
    AC ob;
    TurnOffAC(AC ob){
        this.ob=ob;
    }
    @Override
    public void execute() {
        ob.TurnOff();
    }
}

//This is basically the remote which have two buttons and the setcommand allow us to set the diffrent
//command object and we have pressbutton operation to execute to the command
class MyRemote{
    Command ob1;
    Command ob2;
    void setCommand(Command ob1,Command ob2){
        this.ob1 = ob1;
        this.ob2=ob2;
    }
    void pressButton1(){
        ob1.execute();
    }
    void pressButton2(){
        ob2.execute();
    }
}

//This is the invoker who set the remote and press the button now any change in the functionality of the
// receiver will not effect this
class Main{
    public static void main(String[] args) {
        AC ac1 = new AC();
        MyRemote remote = new MyRemote();
        remote.setCommand(new TurnOnAC(ac1),new TurnOffAC(ac1));
        remote.pressButton1();
        remote.pressButton2();
        remote.pressButton2();
        remote.pressButton1();
    }
}
