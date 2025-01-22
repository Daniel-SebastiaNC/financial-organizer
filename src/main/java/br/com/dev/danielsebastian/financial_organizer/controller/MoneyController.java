package br.com.dev.danielsebastian.financial_organizer.controller;

import br.com.dev.danielsebastian.financial_organizer.dtos.MoneyDto;
import br.com.dev.danielsebastian.financial_organizer.model.Money;
import br.com.dev.danielsebastian.financial_organizer.service.MoneyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoneyController {

    private MoneyService moneyService;

    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    @PostMapping("/add")
    public ResponseEntity<Money> saveMoney(@RequestBody MoneyDto moneyDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(moneyService.saveMoney(moneyDto));
    }

    @GetMapping("/helloworld")
    String helloWorld(){
        return "Hello World";
    }
}
