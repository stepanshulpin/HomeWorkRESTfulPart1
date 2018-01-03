package com.shulpin;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CalculationRestClient {

    public static void main(String[] args) throws InterruptedException {



        Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );


        System.out.println("***TEST ADD***");
        operation(client, "add", 2,3);
        Thread.sleep(1000);
        System.out.println("***TEST SUB***");
        operation(client, "sub", 2,3);
        Thread.sleep(1000);
        System.out.println("***TEST MULT***");
        operation(client, "mult", 2,3);
        Thread.sleep(1000);
        System.out.println("***TEST DIV***");
        operation(client, "div", 2,3);
    }


    public static void operation(Client client, String op, double a, double b){

        WebTarget webTarget = client.target("http://localhost:8080/rest/calc").path(op).path(String.valueOf(a)).path(String.valueOf(b));
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();
        double result = response.readEntity(Double.class);
        System.out.println(response.getStatus());
        System.out.println("Result---> "+result);

    }








}
