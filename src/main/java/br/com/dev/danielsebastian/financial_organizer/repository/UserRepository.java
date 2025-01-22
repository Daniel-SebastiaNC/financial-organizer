package br.com.dev.danielsebastian.financial_organizer.repository;

import br.com.dev.danielsebastian.financial_organizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
