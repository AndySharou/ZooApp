package com.example.andrew.zooapp.utils;

import com.squareup.otto.Bus;

/**
 * Created by Andrew on 18.11.2016.
 */

public class EventBus extends Bus {
    private static final EventBus bus = new EventBus();

    public static Bus getInstance() {return bus;}

    private EventBus () {}
}
