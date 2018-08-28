
package com.abhi.server.userservice;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Server {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static void startServer() throws IOException
    {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example.rest package
        ResourceConfig rc = new MyResourceConfig();

        System.out.println("RC + "+ rc.getClasses());
//        rc.register(new MyAbstractBinder());

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        HttpServer server =  GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));

        // register shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Shut down hook: Stopping server..");
                server.stop();
            }
        }, "shutdownHook"));

        // run
        try {
            server.start();
            System.out.println("Press CTRL^C to exit..");
            Thread.currentThread().join();
        } catch (Exception e) {
            System.err.println("There was an error while starting Grizzly HTTP server.");
        }
//        System.in.read();
//        server.stop();
//        return server;
    }
}