package com.laoliu.team.domain;

import com.laoliu.team.service.Status;

public class Designer extends Programmer {
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer() {
        super();
    }

    public Designer(int id, String name, int age, double salary,
                    Equipment equipment, double bonus) {
        super(id, name, age, salary,equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails()+"\t\t设计师\t\t"+getStatus()+"\t\t"+bonus+"\t\t\t\t"+getEquipment().getDescription();
    }
}
