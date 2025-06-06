import java.util.*;

class ReptileMorphCalculator {
    public static void main(String[] args) {
        reptileMorphCalculator();
    }

    public static void reptileMorphCalculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nKyle.Exotic Reptile Morph Calculator");
        System.out.println("\nThis Tool can help the Reptile World to calculate the potential offspring from parents reptile.\n");

        String species = "";
        Map<String, Double> morphPrices = new HashMap<>();
        List<String> possibleMorphs = new ArrayList<>();
        double basePrice = 0.0;

        System.out.print("Enter the reptile species (e.g., Ball Python, Leopard Gecko, Reticulated Python): ");
        species = scanner.nextLine();

        if (species.toLowerCase().contains("ball python")) {
            possibleMorphs = Arrays.asList("Normal", "Albino", "Piebald", "Pastel", "Spider", "Clown", "Banana");
            basePrice = 1000.0;
        } else if (species.toLowerCase().contains("leopard gecko")) {
            possibleMorphs = Arrays.asList("Normal", "Tangerine", "Hypo", "Super Hypo", "Albino", "Blizzard");
            basePrice = 2000.0;
        } else if (species.toLowerCase().contains("reticulated python")) {
            possibleMorphs = Arrays.asList("Albino", "Tiger", "Golden Child", "Motley");
            basePrice = 20000.0;
        } else {
            possibleMorphs = Arrays.asList("Normal", "Albino", "Patternless", "Wild Type");
            basePrice = 1500.0;
        }

        System.out.println("\nAvailable morphs for " + species + ":");
        for (int i = 0; i < possibleMorphs.size(); i++) {
            String morph = possibleMorphs.get(i);
            System.out.println((i + 1) + ". " + morph);
            morphPrices.put(morph, basePrice * (1 + ((i + 1) * 0.5)));
        }

        String parent1 = "";
        String parent2 = "";

        while (!possibleMorphs.contains(parent1)) {
            System.out.print("\nEnter morph for Parent 1: ");
            parent1 = scanner.nextLine();
            if (!possibleMorphs.contains(parent1)) {
                System.out.println("Invalid morph. Please choose from the list above.");
            }
        }

        while (!possibleMorphs.contains(parent2)) {
            System.out.print("Enter morph for Parent 2: ");
            parent2 = scanner.nextLine();
            if (!possibleMorphs.contains(parent2)) {
                System.out.println("Invalid morph. Please choose from the list above.");
            }
        }

        System.out.println("\nCalculating possible offspring morphs...Please wait Hehe!");

        Set<String> offspringMorphs = new HashSet<>();

        if (parent1.equals(parent2)) {
            offspringMorphs.add(parent1);
            if (!parent1.equals("Normal")) {
                offspringMorphs.add("Normal");
            }
        } else {
            offspringMorphs.add(parent1);
            offspringMorphs.add(parent2);
            offspringMorphs.add("Normal");
        }

        // Special combo ni Kyle mag breed hehe.
        if ((parent1.equals("Albino") || parent2.equals("Albino")) &&
                (parent1.equals("Piebald") || parent2.equals("Piebald")) &&
                species.toLowerCase().contains("ball python")) {
            offspringMorphs.add("Albino Piebald");
        }

        // Display results
        System.out.println("\nPossible Offspring Morphs:");
        List<String> sortedMorphs = new ArrayList<>(offspringMorphs);
        Collections.sort(sortedMorphs);

        for (String morph : sortedMorphs) {
            double price = morphPrices.getOrDefault(morph, basePrice);
            System.out.printf("- %s (Estimated value: ₱%.2f)%n", morph, price);
        }

        // Calculate average value
        if (!offspringMorphs.isEmpty()) {
            double totalValue = 0.0;
            for (String morph : offspringMorphs) {
                totalValue += morphPrices.getOrDefault(morph, basePrice);
            }
            double avgValue = totalValue / offspringMorphs.size();
            System.out.printf("%nAverage offspring value: ₱%.2f%n", avgValue);
        }

        System.out.println("\nThank you for using Kyle.Exotic Reptile Morph Calculator!");
        scanner.close();
    }
}