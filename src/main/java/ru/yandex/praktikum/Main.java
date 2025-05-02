package ru.yandex.praktikum;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        AnimalFarm animalFarm = new AnimalFarm(
                List.of("", "DOG dog1", "DOG dog2", "DOG dog1 dog1", "FISH test",
                        "CAT cat1", "CAT cat2", "DOG dog3", "DOG"));
        animalFarm.add(Animal.HORSE, "horse1");
        animalFarm.add(Animal.COW);
        animalFarm.add("animal1");

        System.out.println(animalFarm.countedAnimals() + "\n________________________________________");
        System.out.println(animalFarm.uniqueNames() + "\n________________________________________");

        System.out.println(animalFarm);
    }
}
