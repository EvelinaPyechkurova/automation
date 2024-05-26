public class BadCat extends Cat{

    BadCat(String name, String breed, int age, String owner, String healthCondition){
        super(name, breed, age, owner, healthCondition);
    }

    @Override
    public boolean equals(Object that) {
        return true;
    }

    @Override
    public int hashCode() {
        return 17;
    }

}
