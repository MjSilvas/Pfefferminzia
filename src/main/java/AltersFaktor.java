import java.time.LocalDate;

public class AltersFaktor {

    public float calculateFaktor(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthDate.getYear();

        return age;
    }
}
