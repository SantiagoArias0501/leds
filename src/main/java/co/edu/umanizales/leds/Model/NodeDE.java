package co.edu.umanizales.leds.Model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class NodeDE {
    private Led data;
    private NodeDE next;
    private NodeDE previous;
    private LocalTime DateOn;
    private boolean State;


    public NodeDE(Led data) {
        this.data = data;
    }

    public boolean getState() {
        return false;
    }
}
