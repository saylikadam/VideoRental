package com.tw;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by saylik on 31/10/15.
 */
public class CustomerTest {
    Customer customer ;
    @Before
    public void setUp(){
        Rental rental1 = new Rental(new Movie("DDLJ",Movie.NEW_RELEASE),2);
        Rental rental2 = new Rental(new Movie("Minions",Movie.CHILDRENS),1);
        customer = new Customer("Dolly");
        customer.addRental(rental1);
        customer.addRental(rental2);
    }

    @After
        public void tearDown(){
            customer=null;
        }

    @Test
    public void customerShouldReturnTheStatement(){
        String statement = customer.statement();
        String expectedStatment = "Rental Record for " + "Dolly" + "\n"+
        "\t" + "DDLJ" + "\t" + "6.0" + "\n" +
            "\t" + "Minions"  + "\t" + "1.5" + "\n"+
                "Amount owed is "+ "7.5" +"\n"+
                "You earned "+"3 "+ "frequent renter points";
        assertEquals(statement,expectedStatment);
    }

    @Test
    public void customerShouldReturnTheStatementWhenNoMovieIsRented(){
        Customer sayli = new Customer("Sayli");
        String statement = sayli.statement();
        String expectedStatment = "Rental Record for " + "Sayli" + "\n"+
                "Amount owed is "+ "0.0" +"\n"+
                "You earned"+" 0 "+ "frequent renter points";
        assertEquals(statement,expectedStatment);
    }

    @Test
    public void shouldIncrementFrequentRenterPointWhenMovieTypeIsNewRelease(){
        Rental rental1 = new Rental(new Movie("DDLJ",Movie.NEW_RELEASE),2);
        customer = new Customer("Dolly");
        customer.addRental(rental1);
        String statement = customer.statement();
        String expectedStatment = "Rental Record for " + "Dolly" + "\n"+
                "\t" + "DDLJ" + "\t" + "6.0" + "\n" +
                "Amount owed is "+ "6.0" +"\n"+
                "You earned "+"2 "+ "frequent renter points";
        assertEquals(statement,expectedStatment);
    }



}
