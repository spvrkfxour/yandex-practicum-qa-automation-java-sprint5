package ru.yandex.praktikum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class AnimalFarm {
    private final List<String> farmAnimals;

    public AnimalFarm(List<String> farmAnimals) {
        this.farmAnimals = new ArrayList<>(farmAnimals);
    }

    private boolean isNotValidString(String animalString) {
        String[] words = animalString.split(" ");
        if (words.length != 2) {
            System.out.printf("Please correct string [%s]. Incorrect input data. Skip.\n", animalString);
            return true;
        }
        try {
            Animal.valueOf(words[0]);
        } catch (IllegalArgumentException exception) {
            System.out.printf("Please correct string [%s]. Incorrect input data. Skip.\n", animalString);
            return true;
        }
        return false;
    }

    public HashMap<Animal, Integer> countedAnimals() {
        HashMap<Animal, Integer> countedAnimals = new HashMap<>();
        for (String animalString : farmAnimals) {
            String[] words = animalString.split(" ");
            if (isNotValidString(animalString)) {
                continue;
            }
            Animal animal = Animal.valueOf(words[0]);
            countedAnimals.put(animal, countedAnimals.getOrDefault(animal, 0) + 1);
        }
        return countedAnimals;
    }

    public HashSet<String> uniqueNames() {
        HashSet<String> uniqueNames = new HashSet<>();
        for (String animalString : farmAnimals) {
            String[] words = animalString.split(" ");
            if (isNotValidString(animalString)) {
                continue;
            }
            uniqueNames.add(words[1]);
        }
        return uniqueNames;
    }

    public void add(Animal animal, String name) {
        if (name != null && !name.trim().isEmpty()) {
            Animal actualAnimalType = (animal != null) ? animal : Animal.NOT_DEFINED;
            farmAnimals.add(actualAnimalType.name() + " " + name);
        } else {
            System.out.printf("Incorrect input data name-[%s] in add(). Skip.\n", name);
        }
    }

    public void add(Animal animal) {
        if (animal != null) {
            farmAnimals.add(animal.name() + " N");
        } else {
            farmAnimals.add(Animal.NOT_DEFINED.name() + " N");
        }
    }

    public void add(String name) {
        if (name != null && !name.trim().isEmpty()) {
            farmAnimals.add(Animal.NOT_DEFINED.name() + " " + name);
        } else {
            System.out.printf("Incorrect input data name-[%s] in add(). Skip.\n", name);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String animalString : farmAnimals) {
            String[] words = animalString.split(" ");
            if (words.length == 2) {
                sb.append(words[0]).append(" ").append(words[1]).append("\n");
            }
        }
        return sb.toString();
    }
}
