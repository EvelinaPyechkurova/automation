public abstract class Cat {
    private final String name;
    private final String breed;
    private final int age;
    private final String owner;
    private final String healthCondition;

    public Cat(String name, String breed, int age, String owner, String healthCondition){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
        this.healthCondition = healthCondition;
    }

    public String getName(){
        return new String(name);
    }

    public String getBreed(){
        return new String(breed);
    }

    public int getAge() {
        return age;
    }

    public String getOwner(){
        return new String(owner);
    }

    public String getHealthCondition() {
        return new String(healthCondition);
    }

    @Override
    public String toString(){
        return name+" the cat";
    }
}