package org.example;

enum Status {STOP, RUNNING, REGULAR}

public class PublicTransport {
    int number;
    int fuelVolumn = 100;
    int velocity = 0;
    int maxClient;
    int client;
    int fare;
    int money;

    Status status;



    protected int getVelocity() {
        return this.velocity;
    }

    protected void setVelocity(int value) {
        this.velocity = value;
    }

    protected int getClient() {
        System.out.println("승객의 수는 "+ this.client + "명 입니다.");
        return this.client;
    }

    protected void setClient(int value) {
        this.client = value;
    }

    protected int getMaxClient() {
        return this.maxClient;
    }

    protected void setMaxClient(int value) {
        this.maxClient = value;
    }


    protected int getFuelVolumn() {
        return this.fuelVolumn;
    }

    protected void setFuelVolumn(int value) {
        this.fuelVolumn = value;
    }

    protected Status getStatus() {
        return this.status;
    }

    protected void setStatus(Status value) {
        this.status = value;
    }

    protected int getFare() {
        return this.fare;
    }

    protected void setFare(int value) {
        this.fare = value;
    }

    protected int getMoney() {
        return this.money;
    }

    protected void setMoney(int value) {
        this.money = value;
    }

}
