package dev.cstv.musify.messaging;

import dev.cstv.musify.domain.Chart;

public class ChartQueueListener {

    public void listen(Chart chart) {

        System.out.println("Chart has been Received");

    }
}
