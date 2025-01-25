package br.com.dev.danielsebastian.financial_organizer.service;

import br.com.dev.danielsebastian.financial_organizer.dtos.MoneyDto;
import br.com.dev.danielsebastian.financial_organizer.model.Money;
import br.com.dev.danielsebastian.financial_organizer.model.User;
import br.com.dev.danielsebastian.financial_organizer.repository.MoneyRepository;
import br.com.dev.danielsebastian.financial_organizer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoneyService {

    private final MoneyRepository moneyRepository;
    private final UserRepository userRepository;

    public MoneyService(MoneyRepository moneyRepository, UserRepository userRepository) {
        this.moneyRepository = moneyRepository;
        this.userRepository = userRepository;
    }

    public void saveMoney(MoneyDto dto) {
        //System.out.println(dto);

        Optional<User> userOptional = userRepository.findById(dto.idUser());

        if (userOptional.isEmpty()) {
            return;
        }

        var user = userOptional.get();
        Money money = new Money(dto, user);


        userRepository.save(user);
        moneyRepository.save(money);

        //return ResponseEntity.ok("ok"); //status(HttpStatus.CREATED).build();//.body();

    }

    public List<Money> showAll(Long id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new RuntimeException();
        }

        return userOptional.get().getMoney();
    }

    public List<Money> showAllPositive(Long id) {
        var all = showAll(id);

        List<Money> positive = new ArrayList<>();
        for (Money money : all) {
            if (money.isPositive()) {
                positive.add(money);
            }
        }

        return positive;
    }

    public List<Money> showAllNegative(Long id) {
        var all = showAll(id);

        List<Money> negative = new ArrayList<>();
        for (Money money : all) {
            if (!money.isPositive()) {
                negative.add(money);
            }
        }

        return negative;
    }

    //Teste
    public void delete(Long id){
        moneyRepository.deleteById(id);
    }


}
