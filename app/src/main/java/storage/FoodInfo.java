package storage;

public class FoodInfo {

    private String name, date;

    public FoodInfo(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public FoodInfo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
