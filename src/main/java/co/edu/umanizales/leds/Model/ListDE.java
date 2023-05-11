package co.edu.umanizales.leds.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ListDE {
    private NodeDE head;
    private int size;

    public ListDE() {

    }

    public void addLed(Led led) {
        if (this.head != null) {
            NodeDE temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            NodeDE newLed = new NodeDE(led);
            temp.setNext(newLed);
            newLed.setPrevious(temp);
        } else {
            this.head = new NodeDE(led);
        }
    }

    public void addToStart(Led led) {
        if (head != null) {
            NodeDE newNodeDE = new NodeDE(led);
            newNodeDE.setNext(head);
            head.setPrevious(newNodeDE);
            head = newNodeDE;
        } else {
            head = new NodeDE(led);
        }
        size++;
    }

    public void lightLedInMiddle() {
        if (this.head == null) {
            return;
        }
        int middle = this.size / 2;
        NodeDE temp = this.head;
        for (int i = 0; i < middle; i++) {
            temp = temp.getNext();
        }
        NodeDE next = temp;
        while (next != null) {
            next.getData().setState(true);
            next.getData().setDateON(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            next.getData().setState(false);
            next.getData().setDateOff(LocalTime.now());
            next = next.getNext();
        }
        NodeDE previous = temp.getPrevious();
        while (previous != null) {
            previous.getData().setState(true);
            previous.getData().setDateON(LocalTime.now());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        previous.getData().setState(false);
        previous.getData().setDateOff(LocalTime.now());
        previous = previous.getPrevious();

        next =temp .getNext();
        while (next !=null){
            next.getData().setState(true);
            next.getData().setDateON(LocalTime.now());
            try{Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            next.getData().setState(false);
            next.getData().setDateOff(LocalTime.now());
            next = next.getNext();
        }
        previous = temp.getPrevious();
        while (previous != null){
            previous.getData().setState(true);
            previous.getData().setDateON(LocalTime.now());
            try{Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            previous.getData().setState(false);
            previous.getData().setDateOff(LocalTime.now());
        }

    }

    public void resetLeds (){
        if (this.head != null){
            NodeDE temp = this.head;
            while (temp != null){
                temp.setState(false);

            }
        }

    }
}
