package ru.koval.domain;

import ru.koval.CompanyStuff.CompanyTypes;

import javax.persistence.*;

@Entity
@Table(name = "cmpny")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String companyName;
    private CompanyTypes type;

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setType(CompanyTypes type) {
        this.type = type;
    }

    public String getType() {
        return type.toString();
    }

    public String getCompanyName() {
        return companyName;
    }
}
