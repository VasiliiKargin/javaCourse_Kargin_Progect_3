abstract class Immovables {
    private String name;
    private String underground;
    private String address;
    private float square;
    private float price;
    private float rating;

    public Immovables(String name, String underground, String address, float square, float price, float rating) {
        this.name = name;
        this.underground = underground;
        this.address = address;
        this.square = square;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnderground() {
        return underground;
    }

    public void setUnderground(String underground) {
        this.underground = underground;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    public abstract String getClassName();
}
