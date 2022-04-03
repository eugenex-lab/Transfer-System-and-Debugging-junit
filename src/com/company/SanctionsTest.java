package com.company;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class SanctionsTest {

    private SoccerTransfer clubAccount;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @org.junit.Before
    public void setup() {
        clubAccount = new SoccerTransfer("Crisatiano Ronaldo",
                "ManchesterUnited", 200.00,
                "Juventus", SoccerTransfer.SUMMER);
        System.out.println("Running a test...");
    }

    @org.junit.Test
    public void playerSold() throws Exception {
        double clubAccBal = clubAccount.playerSold(80.00, true);
        assertEquals(280.00, clubAccBal, 0); // result is
        System.out.println("Player sold successfully");
        System.out.println("Count = " + count++);
        System.out.println( "Club transfer Balance = " + clubAccBal);
    }

    @org.junit.Test
    public void playerBuysSummer() throws Exception {
        double clubAccBal = clubAccount.playerBuys(100.00, true); // should be 100.00
        assertEquals(100.00, clubAccBal, 0); // should be 80.00
        System.out.println("Player Bal Fee: " + clubAccBal);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void playerBuysWinter() throws Exception {
        double clubAccBal = clubAccount.playerBuys(140.00, false);
        assertEquals(60.00, clubAccBal, 0); // result is 80.00
    }

    @org.junit.Test
    public void getPlayerTransferSold_() throws Exception {
        clubAccount.playerSold(100.00, true);
        assertEquals(300.00, clubAccount.getTransferBal(), 0); // result is   1200.00
    }

    @org.junit.Test
    public void getPlayerTransferBuy() throws Exception {
        clubAccount.playerBuys(130.00, true);
        assertEquals(70.00, clubAccount.getTransferBal(), 0); // res
    }

    @org.junit.Test
    public void isSummerTrabsferTrue() {
        assertTrue("Summer Transfer window is   Summer", clubAccount.summerTransfer());
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }
}