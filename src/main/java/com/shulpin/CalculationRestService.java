package com.shulpin;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalculationRestService {

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public double add(@PathParam("a") double a, @PathParam("b") double b){
        return a+b;
    }

    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public double sub(@PathParam("a") double a, @PathParam("b") double b){
        return a-b;
    }

    @GET
    @Path("/mult/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public double mult(@PathParam("a") double a, @PathParam("b") double b){
        return a*b;
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public double div(@PathParam("a") double a, @PathParam("b") double b){
        if(b==0) return 0;
        else return a/b;
    }



}
