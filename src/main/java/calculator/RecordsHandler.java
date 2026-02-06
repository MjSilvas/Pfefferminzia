package calculator;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        String path = "src/main/java/calculator/json/";
        animalBaseRecs = loader.readJson(Path.of(path +"AnimalBase.json"), AnimalBaseRec.class);
        tariffRecs = loader.readJson(Path.of(path +"TariffFactor.json"), TariffRec.class);
        ageFaktorRecs = loader.readJson(Path.of(path +"AgeFactor.json"), AgeFactorRec.class);
    }


    public BigDecimal getBaseSum(String type) {

        for(AnimalBaseRec animalBaseRec : animalBaseRecs) {
            if(animalBaseRec.type().equalsIgnoreCase(type)) {
                return animalBaseRec.baseValue();
            }
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getTariffFactor(String tariff) {
        for(TariffRec tariffRec : tariffRecs) {
            if(tariffRec.type().equalsIgnoreCase(tariff)) {
                return tariffRec.factor();
            }
        }
        return BigDecimal.ZERO;
    }
    public BigDecimal getAgeFactorFactor(int age) {
        int minAge =Integer.MAX_VALUE;
        BigDecimal ageFactor = BigDecimal.ZERO;
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
