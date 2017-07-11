package org.elasticsearch.bootstrap;

import org.elasticsearch.cli.Terminal;

import java.io.IOException;
import java.net.URL;

public class ElasticsearchController {

    public static void start() {

        new Thread(() -> {
            try {
                URL url = ElasticsearchController.class.getClassLoader().getResource("elasticsearch");
                String elasticsearchPath = url.getPath();
                System.setProperty("es.path.home", elasticsearchPath);
                Elasticsearch elasticsearch = new Elasticsearch();
                elasticsearch.main(new String[]{}, Terminal.DEFAULT);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public static void stop() {
        try {
            Elasticsearch.close(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
