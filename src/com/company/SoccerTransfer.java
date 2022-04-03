package com.company;

public class SoccerTransfer {
    private String playerName;
    private String clubBuying;
    private double transferBal;
    private String clubSelling;


    public static final int SUMMER = 1;
    public static final int WINTER = 2;

    private int transferPeriod;

    public SoccerTransfer(String playerName, String clubBuying, double transferBal,
                          String clubSelling, int transferSeason) {
        this.playerName = playerName;
        this.clubBuying = clubBuying;
        this.transferBal = transferBal;
        this.clubSelling = clubSelling;
        this.transferPeriod = transferSeason;
    }

    public double playerSold(double transferFee, boolean transactionPeriod) {
        transferBal += transferFee;
        return transferBal;
    }

    public double playerBuys(double transferFee,boolean transactionPeriod ){
        if ((transferFee > 100) & !transactionPeriod )  {
            System.out.println("Board: we are think the resiurces u have is dufficent enough ");
            throw new IllegalArgumentException();
        }
        transferBal -= transferFee;
        return transferBal;
    }

    public double getTransferBal() {
        return transferBal;
    }

    public boolean summerTransfer() {
        return  transferPeriod == SUMMER;
    }


}
