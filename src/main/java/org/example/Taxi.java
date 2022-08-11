package org.example;

public class Taxi extends PublicTransport {

    static int taxiNumber;


    int defaultDistance;
    int farePerDistance;



    int distance;

    int money;


    Taxi() {
        setNumber(this.taxiNumber++);
        setMaxClient(4);
        setFare(3000);
        setDefaultDistance(1);
        setFuelVolumn(100);
        setStatus(Status.REGULAR);
        setFarePerDistance(1000);
        setVelocity(10);
    }

    private int getDefaultDistance() {
        return defaultDistance;
    }

    private void setDefaultDistance(int defaultDistance) {
        this.defaultDistance = defaultDistance;
    }


    private int getFarePerDistance() {
        return farePerDistance;
    }

    private void setFarePerDistance(int farePerDistance) {
        this.farePerDistance = farePerDistance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void setMoney(int money) {
        this.money = money;
    }

    public void take(int client, int clientDistance) {
        if (getFuelVolumn() < 10) {
            System.out.println("[연료 부족] 연료가 부족합니다.");
            setStatus(Status.STOP);
            return;
        }

        if (getStatus() != Status.REGULAR) {
            System.out.println("[탑승 불가] 탑승할 수 없는 상태입니다.");
            return;
        }

        setMoney(getFare());
        if (getClient() + client > getMaxClient()) {
            System.out.println("최대 승객 수를 초과했습니다");
            return;
        }
        setClient(client);
        System.out.println("승객이 탑승합니다.");
        setDistance(clientDistance);
        System.out.println("기본 요금 [ " + getFare() + " ] 원, 주행 거리 : [ " + getDistance() + " ]");
        setStatus(Status.RUNNING);
        System.out.println("=================== [ 출발 ] ====================");

    }

    public void running() {
        while (getDistance() > 0) {
            if (getFuelVolumn() <= 0) {
                setStatus(Status.STOP);
                System.out.println("연료가 부족합니다.");
                break;
            }
            setMoney(getMoney() + getFarePerDistance());
            setDistance(getDistance() - 1);
            setFuelVolumn(getFuelVolumn() - getVelocity());
            System.out.println("택시 요금 : [ " + getMoney() + " ] 원 " + "남은 주행 거리 : [ " + getDistance() + " ]");
        }
        if (getStatus() == Status.STOP) {
            System.out.println("차가 정지하였습니다.");
        } else {
            System.out.println("목적지에 도착했습니다.");
            setStatus(Status.ARRIVED);
        }
    }

    public void goToGasStation() {
        setFuelVolumn(150);
        setStatus(Status.RUNNING);
    }

    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        System.out.println("이 택시의 번호는 [ " + taxiNumber + " ] 입니다.");
        taxi.take(3, 12);
        while (taxi.getStatus() != Status.ARRIVED) {
            taxi.goToGasStation();
            taxi.running();
        }
    }
}
