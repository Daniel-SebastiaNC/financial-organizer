package br.com.dev.danielsebastian.financial_organizer.controller;

import br.com.dev.danielsebastian.financial_organizer.dtos.MoneyDto;
import br.com.dev.danielsebastian.financial_organizer.model.Money;
import br.com.dev.danielsebastian.financial_organizer.service.MoneyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoneyController {

    private MoneyService moneyService;

    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    @PostMapping("/add")
    public void saveMoney(@RequestBody MoneyDto input){
        moneyService.saveMoney(input);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        moneyService.delete(id);

    }

    @GetMapping("/showAll/{id}")
    public List<Money> showAll(@PathVariable("id") Long id){
        return moneyService.showAll(id);
    }

    @GetMapping("/showAllPositive/{id}")
    public List<Money> showAllPositive(@PathVariable("id") Long id){
        return moneyService.showAllPositive(id);
    }

    @GetMapping("/showAllNegative/{id}")
    public List<Money> showAllNegative(@PathVariable("id") Long id){
        return moneyService.showAllNegative(id);
    }

    @GetMapping("/helloworld")
    String helloWorld(){
        return "Hello World";
    }
}
