public class CommercialPremises extends Immovables{
    private String typeRoom;

    public CommercialPremises(String name, String underground, String address, float square, float price, float rating, String typeRoom) {
        super(name, underground, address, square, price, rating);
        this.typeRoom = typeRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }
    @Override
    public String toString() {
        return "Название - " + getName() + ", цена - "+ getPrice() + ", оценка - "+ getRating();
    }

    @Override
    public String getClassName() {
        return "Коммерческие помещения";
    }
}
