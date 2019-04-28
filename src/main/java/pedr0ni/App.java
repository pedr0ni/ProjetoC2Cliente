package pedr0ni;

import java.util.Date;

import pedr0ni.sockets.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println("Conectando...");
        Cliente eu = new Cliente("localhost", 25565);
        eu.send(new Date());
        System.out.println("Sent!");
    }
}
