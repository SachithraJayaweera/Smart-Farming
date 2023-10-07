package com.example.smartfarming;

public class Customer {
    String nic;
    String name;
    String email;
    String password;
    String address;
    String tel;

    public Customer(String nic, String name, String email, String password, String address, String tel){
        this.nic = nic;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.tel = tel;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }
}
