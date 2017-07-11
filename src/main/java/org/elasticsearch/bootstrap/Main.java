package org.elasticsearch.bootstrap;

public class Main {

    public static void main(String[] args) throws Exception {

        ElasticsearchController.start();

        Thread.sleep(20000);

        ElasticsearchController.stop();
    }
}
