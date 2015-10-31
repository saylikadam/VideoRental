package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by saylik on 31/10/15.
 */
public class RentalTest {
    @Test
    public void shouldReturnRentedAmountForNewRelease(){
        Rental rental = new Rental(new Movie("DDLG",Movie.NEW_RELEASE),1);
        assertEquals(rental.GetRentalAmount(), 3.0, 0);
    }
    @Test
    public void shouldReturnRentedAmountForRegularRelease(){
        Rental rental = new Rental(new Movie("KKHH",Movie.REGULAR),2);
        assertEquals(rental.GetRentalAmount(),2.0,0);
    }
    @Test
    public void shouldReturnRentedAmountForChildrenRelease(){
        Rental rental = new Rental(new Movie("Minions",Movie.CHILDRENS),3);
        assertEquals(rental.GetRentalAmount(),1.5,0);
    }

}
