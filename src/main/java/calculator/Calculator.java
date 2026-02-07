package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Calculator {

    RecordsHandler recordsHandler;

    public Calculator() {
        recordsHandler = RecordsHandler.getInstance();
    }



    public BigDecimal calculateSum(String type, String tariff) {
        BigDecimal baseSum = recordsHandler.getBaseSum(type);
        BigDecimal factor = recordsHandler.getTariffFactor(tariff);
        if(baseSum==null||factor==null) {
            return BigDecimal.ZERO;
        }
        return baseSum.multiply(factor).setScale(2, RoundingMode.HALF_UP);

    }


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
