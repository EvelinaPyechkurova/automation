public class GoodCat extends Cat{

    GoodCat(String name, String breed, int age, String owner, String healthCondition){
        super(name, breed, age, owner, healthCondition);
    }

    @Override
    public boolean equals(Object that) {
        if(that == this)
            return true;

        if(!that.getClass().equals(GoodCat.class))
            return false;

        GoodCat cat = (GoodCat) that;
        return (this.getName().equals(cat.getName()) &&
                this.getBreed().equals(cat.getBreed()) &&
                this.getAge() == cat.getAge() &&
                this.getOwner().equals(cat.getOwner()) &&
                this.getHealthCondition().equals(cat.getHealthCondition()));
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + this.getName().hashCode();
        result = 31 * result + this.getBreed().hashCode();
        result = 31 * result + Integer.hashCode(this.getAge());
        result = 31 * result + this.getOwner().hashCode();
        result = 31 * result + this.getHealthCondition().hashCode();

        return result;
    }
}