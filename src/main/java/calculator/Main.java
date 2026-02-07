package calculator;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {
    static Calculator calc=new Calculator();
    public static void main(String[] args) {

        registerNewAnimal("katze", "Premium", LocalDate.of(2019, 1, 1) );

    }

    private static void registerNewAnimal(String type, String tariff, LocalDate birthDate) {
        BigDecimal insSum = calc.calculateSum(type, tariff);
        BigDecimal insPrem = calc.calculatePremium(type, tariff, birthDate);

        System.out.println("Dein Haustier: " + type +" hat eine Versicherungssumme von "+ insSum+"€ und eine Jährliche Versicherungsprämie von "+insPrem+"€ \n");
    }
}