

import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    RecordsHandler recordsHandler;

    public Calculator() {
        recordsHandler = RecordsHandler.getInstance();
    }



    public BigDecimal calculateInsurenceSum(String type, String tariff) {
        BigDecimal baseSum = recordsHandler.getBaseSum(type);
        double factor = recordsHandler.getTariffFactor(tariff);

        return baseSum.multiply(BigDecimal.valueOf(factor));

    }


    public BigDecimal calculateInsurencePremium(String type, String tariff, LocalDate birthDate) {
        BigDecimal insSum = calculateInsurenceSum(type, tariff);
        int age = LocalDate.now().getYear() - birthDate.getYear();
        if (age < 0) {return  BigDecimal.ZERO;}
        double factor = recordsHandler.getAgeFactorFactor(age);

        return insSum.multiply(BigDecimal.valueOf(factor));
    }



}
