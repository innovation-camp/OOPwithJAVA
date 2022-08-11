package org.example;

public class Bus extends PublicTransport {

    static int busNumber;

    Bus() {
        this.busNumber++;
        setMaxClient(30);
        setStatus(Status.RUNNING);
        setFare(1000);
        System.out.println("버스가 운행을 시작합니다.");
    }

    public void stop() {
        setStatus(Status.STOP);
    }

    public void running() {
        if (getStatus() != Status.RUNNING) {
            System.out.println("버스가 운행중이 아닙니다.");
        } else if (getFuelVolumn() <= 0) {
            stop();
            System.out.println("[ " + getStatus() + " ] !! 주유량이 떨어져 운행을 종료합니다.");
        } else if (getFuelVolumn() < 10) {
            System.out.println("주유가 필요합니다.");
            System.out.println("Fuel : " + getFuelVolumn() + " V : " + getVelocity());
            setFuelVolumn(getFuelVolumn() - getVelocity());
        } else {
            setFuelVolumn(getFuelVolumn() - getVelocity());
            System.out.println("버스가 이동합니다. 현재 속도 " + getVelocity() + " 남은 연료량 " + getFuelVolumn());
        }
    }

    public void speedUp(int value) {
        setVelocity(value);
        System.out.println("속도를 " + value + "만큼 올립니다.");
    }

    public void speedDown(int value) {
        setVelocity(-value);
        System.out.println("속도를 " + value + "만큼 내립니다.");
    }

    public void takeBus() {
        if (getStatus() != Status.RUNNING) {
            System.out.println("운행 중인 버스에만 탑승할 수 있습니다.");
            return;
        }
        if (getClient() < getMaxClient()) {
            setClient(getClient() + 1);
            System.out.println("승객이 탑승합니다.");
            setMoney(getMoney() + getFare());
            return;
        }
        System.out.println("최대 승객 수에 도달하여 승객이 탑승할 수 없습니다.");
    }

    public static void main(String[] args) {
        Bus bus = new Bus();

        System.out.println("이 버스의 번호는 [ " + busNumber + " ] 입니다.");
        while (bus.getStatus() == Status.RUNNING) {
            bus.running();
            bus.speedUp(10);
            bus.takeBus();
        }
    }
}
