package com.example.demo.drivers;

public class Operation {
    private Route route;

    public Operation(Route route) {
        this.route = route;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
