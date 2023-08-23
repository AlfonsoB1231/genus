import java.util.LinkedList;

class Genus {
    private String genusName;

    public Genus(String g) {
        setGenusName(g);
    }

    public void setGenusName(String g) {
        genusName = g;
    }

    public String getGenusName() {
        return genusName;
    }

    public String toString() {
        return "Genus: " + genusName;
    }
}

class Species extends Genus {
    private String speciesName;

    public Species(String s, String g) {
        super(g);
        setSpeciesName(s);
    }

    public void setSpeciesName(String s) {
        speciesName = s;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String toString() {
        return "Species: " + getGenusName() + " " + speciesName;
    }

    public boolean equals(Species s) {
        return speciesName.equals(s.getSpeciesName());
    }
}

class Specimen {
    private String name;
    private int cageNumber;
    private Species toa; // "Type Of Animal"
    private String markings; // Individual markings description

    public Specimen(String a, int c, Species s, String markings) {
        setName(a);
        setCage(c);
        setTOA(s);
        setMarkings(markings);
    }

    public void setName(String a) {
        name = a;
    }

    public void setCage(int c) {
        cageNumber = c;
    }

    public void setTOA(Species s) {
        toa = s;
    }

    public void setMarkings(String markings) {
        this.markings = markings;
    }

    public String getName() {
        return name;
    }

    public int getCage() {
        return cageNumber;
    }

    public Species getTOA() {
        return toa;
    }

    public String getMarkings() {
        return markings;
    }

    public String toString() {
        return name + " is a " + toa + " in cage " + cageNumber + " with markings: " + markings;
    }
}

public class ZooProgram {
    public static void main(String[] args) {
        Species human = new Species("homo", "sapiens");
        Species lion = new Species("Panthera", "leo");

        Specimen[] animals = {
                new Specimen("John", 1, human, "Freckles on face"),
                new Specimen("Jane", 2, human, "Mole on left arm"),
                new Specimen("Simba", 3, lion, "Dark mane"),
                new Specimen("Nala", 4, lion, "No distinct markings"),
                // Add more specimens here
        };

        LinkedList<Specimen> animalList = makeList(animals);
        System.out.println("Animal List:");
        for (Specimen animal : animalList) {
            System.out.println(animal);
        }

        LinkedList<Species> speciesList = makeSpeciesList(animalList);
        System.out.println("\nSpecies List:");
        for (Species species : speciesList) {
            System.out.println(species);
        }

        LinkedList<Species> uniqueSpeciesList = makeSpeciesListUnique(speciesList);
        System.out.println("\nUnique Species List:");
        for (Species species : uniqueSpeciesList) {
            System.out.println(species);
        }
    }

    public static LinkedList<Specimen> makeList(Specimen[] animals) {
        LinkedList<Specimen> linkedList = new LinkedList<>();
        for (Specimen animal : animals) {
            linkedList.add(animal);
        }
        return linkedList;
    }

    public static LinkedList<Species> makeSpeciesList(LinkedList<Specimen> animals) {
        LinkedList<Species> speciesList = new LinkedList<>();
        for (Specimen animal : animals) {
            speciesList.add(animal.getTOA());
        }
        return speciesList;
    }

    public static LinkedList<Species> makeSpeciesListUnique(LinkedList<Species> allSpecies) {
        LinkedList<Species> uniqueSpeciesList = new LinkedList<>();
        for (Species species : allSpecies) {
            if (!uniqueSpeciesList.contains(species)) {
                uniqueSpeciesList.add(species);
            }
        }
        return uniqueSpeciesList;
    }
}
