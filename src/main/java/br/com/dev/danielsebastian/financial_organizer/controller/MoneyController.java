package br.com.dev.danielsebastian.financial_organizer.controller;

import br.com.dev.danielsebastian.financial_organizer.dtos.MoneyDto;
import br.com.dev.danielsebastian.financial_organizer.model.Money;
import br.com.dev.danielsebastian.financial_organizer.model.User;
import br.com.dev.danielsebastian.financial_organizer.service.MoneyService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @GetMapping("/showmonth/{id}")
    public Set<Money> showmonth(@PathVariable("id") Long id){
        return moneyService.showmonth(id);
    }

    @GetMapping("/helloworld")
    String helloWorld(){
        return "Hello World";
    }
}
