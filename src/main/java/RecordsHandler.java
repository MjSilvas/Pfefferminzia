import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.Instant;
import java.util.List;

public class RecordsHandler {
    private static RecordsHandler instance;
    JsonLoader loader;
    List<AnimalBaseRec> animalBaseRecs;
    List<TariffRec> tariffRecs;
    List<AgeFactorRec> ageFaktorRecs;


    private RecordsHandler() {
        loadRecords();
    }


    public void loadRecords() {
        loader = new JsonLoader();

        animalBaseRecs = loader.readJson(Path.of("src/main/java/json/AnimalBase.json"), AnimalBaseRec.class);
        tariffRecs = loader.readJson(Path.of("src/main/java/json/TariffFactor.json"), TariffRec.class);
        ageFaktorRecs = loader.readJson(Path.of("src/main/java/json/AgeFactor.json"), AgeFactorRec.class);
    }

    public BigDecimal getBaseSum(String type) {

        for(AnimalBaseRec animalBaseRec : animalBaseRecs) {
            if(animalBaseRec.type().equalsIgnoreCase(type)) {
                return animalBaseRec.baseValue();
            }
        }
        return null;
    }

    public Double getTariffFactor(String tariff) {
        for(TariffRec tariffRec : tariffRecs) {
            if(tariffRec.type().equalsIgnoreCase(tariff)) {
                return tariffRec.factor();
            }
        }
        return null;
    }
    public Double getAgeFactorFactor(int age) {
        int minAge =Integer.MAX_VALUE;
        Double ageFactor = 0d;
        for(AgeFactorRec ageFactorRec : ageFaktorRecs) {
            if(age<= ageFactorRec.max()&& ageFactorRec.max() <= minAge) {
                minAge = ageFactorRec.max();
                ageFactor = ageFactorRec.factor();
            }
        }
        return ageFactor;
    }

    public static RecordsHandler getInstance() {
        if(instance == null) {
            instance = new RecordsHandler();
        }
        return instance;
    }

}
