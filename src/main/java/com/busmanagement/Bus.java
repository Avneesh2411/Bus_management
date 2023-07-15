```java
package com.busmanagement;

public class Bus {
    private String busNumber;
    private Route route;

    public Bus(String busNumber, Route route) {
        this.busNumber = busNumber;
        this.route = route;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
```