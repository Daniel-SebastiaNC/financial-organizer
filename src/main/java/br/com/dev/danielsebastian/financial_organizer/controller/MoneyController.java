package br.com.dev.danielsebastian.financial_organizer.controller;

import br.com.dev.danielsebastian.financial_organizer.dtos.MoneyDto;
import br.com.dev.danielsebastian.financial_organizer.model.Money;
import br.com.dev.danielsebastian.financial_organizer.service.MoneyService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    //All History

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

    //MONTH

    @GetMapping("/showMonthAll/{id}")
    public List<Money> showMonthAll(@PathVariable("id") Long id, @RequestBody LocalDate date) {
        return moneyService.showMonthAll(id, date);
    }

    @GetMapping("/showMonthPositive/{id}")
    public List<Money> showMonthPositive(@PathVariable("id") Long id, @RequestBody LocalDate date) {
        return moneyService.showMonthPositive(id, date);
    }

    @GetMapping("/showMonthNegative/{id}")
    public List<Money> showMonthNegative(@PathVariable("id") Long id, @RequestBody LocalDate date) {
        return moneyService.showMonthNegative(id, date);
    }

    //HELLO

    @GetMapping("/hello")
    String helloWorld(){
        return "Hello World";
    }
}
