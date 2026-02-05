import java.nio.file.Path;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        JsonLoader loader = new JsonLoader();
        List animals;
        animals = loader.readJson(Path.of("src/main/java/json/AnimalBase.json"), AnimalBaseRec.class);
        System.out.println(animals);
        List tarifs;
        tarifs = loader.readJson(Path.of("src/main/java/json/TariffFactor.json"), TariffRec.class);
        System.out.println(tarifs);
        List ageFaktors;
        ageFaktors = loader.readJson(Path.of("src/main/java/json/AgeFactor.json"), AgeFactorRec.class);
        System.out.println(ageFaktors);

    }
}