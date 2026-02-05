

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    JsonLoader loader;
    List<AnimalBaseRec> animalBaseRecs;
    List<TariffRec> tariffRecs;
    List<AgeFactorRec> ageFaktorRecs;

    public Calculator() {
        loader = new JsonLoader();
        animalBaseRecs = loader.readJson(Path.of("AnimalBase.json"), AnimalBaseRec.class);
        tariffRecs = loader.readJson(Path.of("TariffFactor.json"), TariffRec.class);
        ageFaktorRecs = loader.readJson(Path.of("AgeFactorFactor.json"), AgeFactorRec.class);



    }

}
