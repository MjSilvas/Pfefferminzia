package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Calculator {

    RecordsHandler recordsHandler;

    public Calculator() {
        recordsHandler = RecordsHandler.getInstance();
    }


    /**
     * Berechnet die Versicherungssumme des Tieres
     * @param type die Tierart des versicherten Tieres
     * @param tariff der Tarif der für die Versicherung gewählt wurde
     * @return Versicherungssumme des Tieres falls alle Eingaben in den Records gefunden wurden. Falls nicht wird der Wert 0 zurückgegeben
     */
    public BigDecimal calculateSum(String type, String tariff) {
        BigDecimal baseSum = recordsHandler.getBaseSum(type);
        BigDecimal factor = recordsHandler.getTariffFactor(tariff);
        if(baseSum==null||factor==null) {
            return BigDecimal.ZERO;
        }
        return baseSum.multiply(factor).setScale(2, RoundingMode.HALF_UP);

    }

    /**
     * Berechnet die jährliche Versicherungsprämie
     * @param type die Tierart des versicherten Tieres
     * @param tariff der Tarif der für die Versicherung gewählt wurde
     * @param birthDate das Geburtsjahr des Tieres
     * @return Jährliche Versicherungsprämie die Anhand des Alters des Tieres berechnet wird. Falls das Geburtsdatum in der Zukunft liegt, wird das Alter als 0 berechnet.
     */
    public BigDecimal calculatePremium(String type, String tariff, LocalDate birthDate) {

        BigDecimal insSum = calculateSum(type, tariff);
        int age = LocalDate.now().getYear() - birthDate.getYear();

        if (age < 0) {
            age = 0;
        }

        BigDecimal factor = recordsHandler.getAgeFactorFactor(age);

        return insSum.multiply(factor).setScale(2, RoundingMode.HALF_UP);
    }



}
