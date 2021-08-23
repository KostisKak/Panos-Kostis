package gr.kouretas.first.javafxsimpleproject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javafx.util.Pair;

public class Client {
    String name;
    Date date;
    double price, total_price = 0;
    ArrayList<Pair<Date, Double>> history;

    public Client(String name, double price) {
        this.name = name;
        date = Calendar.getInstance().getTime();
        this.price = price;
        total_price += price;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public void setData(double price) {
        this.price = price;
        total_price += price;
        date = Calendar.getInstance().getTime();
        Pair<Date, Double> data = new Pair<>(date, price);
        history.add(data);
    }

}
