package calculator.records;

import calculator.enums.TariffEnum;

import java.math.BigDecimal;

public record TariffRec(TariffEnum type, BigDecimal factor) {
}
