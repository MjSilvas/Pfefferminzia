package calculator.records;

import calculator.enums.AnimalTypeEnum;

import java.math.BigDecimal;

public record AnimalBaseRec(AnimalTypeEnum type, BigDecimal baseValue) {
}
