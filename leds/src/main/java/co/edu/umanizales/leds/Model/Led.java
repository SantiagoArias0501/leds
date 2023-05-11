package co.edu.umanizales.leds.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Led {
    private int identification;
    private Boolean state;
    private LocalTime DateON;
    private LocalTime DateOff;

}
