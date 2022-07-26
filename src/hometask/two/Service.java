package hometask.two;

public abstract class Service {
    private double cost;
    private String date;

    public Service(String date, double cost) {
        this.date = date;
        setCost(cost);
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }
}

