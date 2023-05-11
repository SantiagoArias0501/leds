package co.edu.umanizales.leds.Controller.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class LedDTO {
    private int identification;
    private Boolean state;
    private LocalTime on;
    private LocalTime off;
}
