package br.com.dev.danielsebastian.financial_organizer.service;

import br.com.dev.danielsebastian.financial_organizer.dtos.MoneyDto;
import br.com.dev.danielsebastian.financial_organizer.model.Money;
import br.com.dev.danielsebastian.financial_organizer.model.User;
import br.com.dev.danielsebastian.financial_organizer.repository.MoneyRepository;
import br.com.dev.danielsebastian.financial_organizer.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

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



        /*


            money.setName(dto.listInput().get(i).name());
            money.setMoney(dto.listInput().get(i).money());
            money.setDate(LocalDate.now());
            money.setPositive(dto.listInput().get(i).isPositive());

            if(money.isPositive()){
                positive += money.getMoney();
            } else {
                negative -= money.getMoney();
            }
            var plus = positive + negative;

            var user = userRepository.findById(dto.listInput().get(i).idUser());
            if (user.isEmpty()){
                ResponseEntity.badRequest();
            }
            user.get().setTotal_Money(plus);
            money.setUser(user.get());

            userRepository.save(user.get());
            moneyRepository.save(money);
        }

        */

        //return ResponseEntity.ok("ok"); //status(HttpStatus.CREATED).build();//.body();

    }

    //Teste
    public void delete(Long id){
        moneyRepository.deleteById(id);
    }

    public Set<Money> showmonth(Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException();
        }

        return user.get().getMoney();


    }
}
