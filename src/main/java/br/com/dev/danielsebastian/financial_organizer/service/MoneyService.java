package br.com.dev.danielsebastian.financial_organizer.service;

import br.com.dev.danielsebastian.financial_organizer.dtos.MoneyDto;
import br.com.dev.danielsebastian.financial_organizer.model.Money;
import br.com.dev.danielsebastian.financial_organizer.repository.MoneyRepository;
import br.com.dev.danielsebastian.financial_organizer.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class MoneyService {

    private MoneyRepository moneyRepository;
    private UserRepository userRepository;

    public MoneyService(MoneyRepository moneyRepository, UserRepository userRepository) {
        this.moneyRepository = moneyRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Money saveMoney(MoneyDto moneyDto) {
        Money money = new Money();


        money.setName(moneyDto.name());

        money.setMoney(moneyDto.money());
        money.setDate(LocalDate.now());
        money.setPositive(moneyDto.isPositive());
        money.setUser(userRepository.findById(moneyDto.idUser()).get());

        return moneyRepository.save(money);
    }
}
