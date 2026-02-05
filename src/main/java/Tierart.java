import java.math.BigDecimal;

public enum Tierart {
    Hund(new BigDecimal(2500)),
    Katze(new BigDecimal(2000)),
    Kleintier(new BigDecimal(1000));

    private BigDecimal basisSum;

    private Tierart(BigDecimal basisSum) {}

    public BigDecimal getBasisSum() {
        return basisSum;
    }
}
