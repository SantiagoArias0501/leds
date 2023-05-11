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
    /*
    Verificamos si  head está vacío. Si lo está, retorno sin hacer nada.
    Calculo el índice del nodo en la posición media de la lista doblemente enlazada size/2.
    Crear un ayudante temp y lo apuntamos  al head.
    el ayudante se mueve hacia adelante hasta el nodo en la posición media.
    Creamos un puntero next y lo apuntamos al nodo en la posición media.
    se enciende  LED en el nodo actual y establecer su fecha y hora de encendido.
            Espera de  1 segundo.
    luego se Apaga el LED en el nodo actual y establecemos  su fecha y hora de apagado.
    Movemos el puntero next hacia adelante al siguiente nodo y repetir los pasos 6-8 hasta el final de la lista.
    Creamos un puntero previous y lo apuntamos  al nodo anterior al nodo en la posición media.
    Movemos el puntero previous hacia atrás hasta el inicio de la lista.
    encendemos el LED en el nodo actual y establecer su fecha y hora de encendido.
            Esperar 1 segundo.

        */

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
