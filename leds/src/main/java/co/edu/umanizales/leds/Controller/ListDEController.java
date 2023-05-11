package co.edu.umanizales.leds.Controller;

import co.edu.umanizales.leds.Controller.dto.LedDTO;
import co.edu.umanizales.leds.Controller.dto.ResponseDTO;
import co.edu.umanizales.leds.Model.Led;
import co.edu.umanizales.leds.Service.ListDEService;
import co.edu.umanizales.leds.exception.ListDEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/list")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;


    @GetMapping(path = "/getlistde")
    public ResponseEntity<ResponseDTO> getleds() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listDEService.putToString(), null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> addLed(@RequestBody LedDTO ledDTO) {
        listDEService.addLed(new Led(ledDTO.getIdentification(), ledDTO.getState(), ledDTO.getOn(), ledDTO.getOff()));
        return new ResponseEntity<>(new ResponseDTO(200, "led añadido", null),
                HttpStatus.OK);
    }

    @PostMapping(path = "/addtostart")
    public ResponseEntity<ResponseDTO> addToStart(@RequestBody Led led) throws ListDEException {
        return listDEService.addToStart(led);
    }

    @PostMapping(path = "/lightledinmiddle")
    public ResponseEntity<ResponseDTO> lightLedInMiddle() {
        listDEService.lightLedInMiddle();
        return new ResponseEntity<>(new ResponseDTO(200, "el led esta en la mitad ", null),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> resetLeds() {
        listDEService.resetLeds();
        return new ResponseEntity<>(new ResponseDTO(200, "la lista ya esta reiniciada", null), HttpStatus.OK);
    }
}
