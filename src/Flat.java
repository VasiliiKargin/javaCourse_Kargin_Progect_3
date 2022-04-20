import java.util.Objects;

public class Flat extends Immovables{
    private int numberOfRooms;

    public Flat(String name, String underground, String address, float square, float price, float rating, int numberOfRooms) {
        super(name, underground, address, square, price, rating);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "Название - " + getName() + ", цена - "+ getPrice() + ", оценка - "+ getRating();
    }

    @Override
    public String getClassName() {
        return "Квартиры";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        Flat flat = (Flat) o;
        return Objects.equals(super.getName(), flat.getName());
    }
}
