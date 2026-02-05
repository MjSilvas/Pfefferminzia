import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;


public class Main {
    static Calculator calc=new Calculator();
    public static void main(String[] args) {

        registerNewAnimal("Hund", "Premium", LocalDate.of(2019, 1, 1) );
        registerNewAnimal("katze", "optimal", LocalDate.of(2023, 1, 1) );
        registerNewAnimal("Hund", "Premium", LocalDate.of(2006, 1, 1) );
        registerNewAnimal("kleintier", "kompakt", LocalDate.of(2025, 1, 1) );
        registerNewAnimal("kleintier", "kompakt", LocalDate.of(2028, 1, 1) );

    }

    private static void registerNewAnimal(String type, String tariff, LocalDate birthDate) {
        BigDecimal insSum = calc.calculateInsurenceSum(type, tariff);
        BigDecimal insPrem = calc.calculateInsurencePremium(type, tariff, birthDate);

        System.out.println("Dein Haustier: " + type +" hat eine Versicherungssumme von "+ insSum+"€ und eine Jährliche Versicherungspremie von "+insPrem+"€ \n");
    }
}