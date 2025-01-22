package br.com.dev.danielsebastian.financial_organizer.repository;

import br.com.dev.danielsebastian.financial_organizer.model.Money;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<Money,Long> {

}
