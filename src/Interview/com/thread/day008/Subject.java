package Thread.day008;

/**
 * 观察者模式未完
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Subject
{

    private List<Obsever> obsever = new ArrayList<>();
    private int state;
    public int getState(){
        return this.state;
    }

    public void setState(int state){
        if(state == this.state){
            return;
        }
        this.state=state;
        notifyAllObsever();

    }
    public void attach(Obsever obsevers ){
        obsever.add(obsevers);

    }

   private void notifyAllObsever(){
        obsever.stream().forEach(Obsever::update);

   }

}
