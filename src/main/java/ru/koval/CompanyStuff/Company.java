package ru.koval.CompanyStuff;

public class Company {
    private String companyName;
    private CompanyTypes type;

    public Company(String companyName, CompanyTypes type) {
        this.companyName = companyName;
        this.type = type;
    }

    public Company(String companyName, String type) {
        this.companyName = companyName;
        this.type = CompanyTypes.valueOf(type);
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
