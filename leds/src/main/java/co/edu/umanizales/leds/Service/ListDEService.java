package co.edu.umanizales.leds.Service;

import co.edu.umanizales.leds.Controller.dto.ResponseDTO;
import co.edu.umanizales.leds.Model.Led;
import co.edu.umanizales.leds.Model.ListDE;
import co.edu.umanizales.leds.exception.ListDEException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ListDEService {
private ListDE leds;

    public ListDEService() {
        leds = new ListDE();
    }
    public String putToString() {
        return leds.toString();
    }

    public void addLed(Led led) {
        leds.addLed(led);}

    public ResponseEntity<ResponseDTO> addToStart(Led led){leds.addToStart(led);
        return null;
    }
    public void lightLedInMiddle(){leds.lightLedInMiddle();}

    public void resetLeds(){leds.resetLeds();}
}
