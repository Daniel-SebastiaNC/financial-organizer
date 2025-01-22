package br.com.dev.danielsebastian.financial_organizer.dtos;

import java.time.LocalDate;

public record MoneyDto(String name,
                       Double money,
                       boolean isPositive,
                       Long idUser
                       ) {
}
