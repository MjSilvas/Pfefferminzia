

import java.math.BigDecimal;
import java.nio.file.Paths;

public class Calculator {

    JsonLoader loader;

    public Calculator() {

    }





    public static BigDecimal calculateInsurance(AnimalType animal, float tariff) {
        String type = animal.type();
        BigDecimal basis = animal.baseSum();
        return basis.multiply(BigDecimal.valueOf(tariff));
    }
}
