package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CalculatorTest {

Calculator calc = new Calculator();

    @Test
    public void calculateSum_with_valid_Input(){

        BigDecimal result1 = calc.calculateSum("hund", "premium");
        BigDecimal result2 = calc.calculateSum("katze", "optimal");
        BigDecimal result3 = calc.calculateSum("kleintier", "kompakt");

        assertEquals(new BigDecimal(3500).setScale(2,RoundingMode.HALF_UP), result1);
        assertEquals(new BigDecimal(2400).setScale(2, RoundingMode.HALF_UP), result2);
        assertEquals(new BigDecimal(1000).setScale(2, RoundingMode.HALF_UP), result3);
    }

    @Test
    public void calculateSum_with_invalid_Input(){

        BigDecimal result1 = calc.calculateSum("pferd", "premium");
        BigDecimal result2 = calc.calculateSum("hund", "super");
        BigDecimal result3 = calc.calculateSum("","");

        assertEquals(BigDecimal.ZERO, result1);
        assertEquals(BigDecimal.ZERO, result2);
        assertEquals(BigDecimal.ZERO, result3);
    }

    @Test
    public void calculatePremium_with_valid_Input(){

        BigDecimal result1 = calc.calculatePremium("hund", "premium", LocalDate.of(2019, 1, 1));
        BigDecimal result2 = calc.calculatePremium("katze", "optimal", LocalDate.of(2023, 1, 1));
        BigDecimal result3 = calc.calculatePremium("kleintier", "kompakt", LocalDate.of(2025, 1, 1));
        BigDecimal result4 = calc.calculatePremium("Hund", "premium", LocalDate.of(2000, 1, 1));

        assertEquals(new BigDecimal(980).setScale(2, RoundingMode.HALF_UP), result1);
        assertEquals(new BigDecimal(600).setScale(2, RoundingMode.HALF_UP), result2);
        assertEquals(new BigDecimal(200).setScale(2, RoundingMode.HALF_UP), result3);
        assertEquals(new BigDecimal(1050).setScale(2, RoundingMode.HALF_UP), result4);

    }

    @Test
    public void calculatePremium_with_invalid_Input(){

        BigDecimal result1 = calc.calculatePremium("hund", "premium", LocalDate.of(2050, 1, 1));
        BigDecimal result2 = calc.calculatePremium("hund", "super", LocalDate.of(2019, 1, 1));
        BigDecimal result3 = calc.calculatePremium("pferd", "premium", LocalDate.of(2019, 1, 1));


        assertEquals(new BigDecimal(700).setScale(2, RoundingMode.HALF_UP), result1);
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), result2);
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), result3);


    }
}
