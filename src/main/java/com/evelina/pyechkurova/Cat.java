package com.evelina.pyechkurova;

public class Cat {
    private final String name;
    private final String breed;

    @Range(max = 20)
    private final int age;
    private final String owner;

    @Range(min = 18, max = 65)
    private final int ownerAge;
    private final String healthCondition;

    public Cat(String name, String breed, int age, String owner, int ownerAge, String healthCondition) throws IllegalAccessException {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
        this.ownerAge = ownerAge;
        this.healthCondition = healthCondition;
        RangeChecker.checkMinMaxValue(this);
    }

    public String getName() {
        return new String(name);
    }

    public String getBreed() {
        return new String(breed);
    }

    public int getAge() {
        return age;
    }

    public String getOwner() {
        return new String(owner);
    }

    public String getHealthCondition() {
        return new String(healthCondition);
    }

    @Override
    public String toString() {
        return name + " the cat";
    }

}