package com.laoliu.team.domain;

import com.laoliu.team.service.Status;

public class Architect extends Designer {
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Architect(){
        super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails()+"\t\t架构师\t\t"+getStatus()+"\t\t"+getBonus()+"\t\t"+stock+
                "\t"+
    getEquipment().getDescription();
    }
}
