```java
package com.busmanagement;

import java.util.ArrayList;

public class Route {
    private String startPoint;
    private String endPoint;
    private ArrayList<String> stops;

    public Route(String startPoint, String endPoint, ArrayList<String> stops) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.stops = stops;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public ArrayList<String> getStops() {
        return stops;
    }

    public void setStops(ArrayList<String> stops) {
        this.stops = stops;
    }
}
```