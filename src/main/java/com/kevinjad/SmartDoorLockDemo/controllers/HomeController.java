package com.kevinjad.SmartDoorLockDemo.controllers;


import com.kevinjad.SmartDoorLockDemo.entities.ControlRequest;
import com.pi4j.io.gpio.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class HomeController {

    private int x;

    private GpioController gpioController = GpioFactory.getInstance();
    final GpioPinDigitalOutput pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
    @Value("${password}")
    private String password;


    @RequestMapping(value = "control-lock",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void onLed(@RequestBody ControlRequest controlRequest){
        if(controlRequest.getPassword().equals(password)){
            if(controlRequest.getLock().equals("on")){
                pin.setShutdownOptions(true, PinState.LOW);
                System.out.println("End point hit for on" + " by: " + controlRequest.getName());
                pin.high();
            }
            else if(controlRequest.getLock().equals("off")){
                pin.setShutdownOptions(true, PinState.LOW);
                System.out.println("End point hit for off" + " by: " + controlRequest.getName());
                pin.low();
            }
            else{
                throw new RuntimeException("Illegal lock status");
            }
        }
    }
}
