package com.hoursetrack;


import java.util.ArrayList;
import java.util.List;

public class Driver {


    private static class Money {
        int value;
        int count;

        @Override
        public String toString() {
            return "$" + value +
                    ", " + count ;
        }

        public Money(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static class BalanceInventory{
        public List<Money> inventory;

        public BalanceInventory() {
            inventory = new ArrayList<>();
            reStock();
        }

        private void reStock(){
            inventory.clear();
            inventory.add(new Money(1,10));
            inventory.add(new Money(5,10));
            inventory.add(new Money(10,10));
            inventory.add(new Money(20,10));
            inventory.add(new Money(100,10));
        }

        public void addMoney(Money money){
            inventory.add(money);
        }

        public void removeMoney(Money money){
            if(inventory.contains(money)){
                inventory.remove(money);
            }
        }

        @Override
        public String toString() {

            StringBuffer buffer = new StringBuffer();

            buffer.append("Inventory:");
            buffer.append("\n");
            for(Money money: inventory) {
                buffer.append(money.toString());
                buffer.append("\n");
            }
            return buffer.toString();
        }
    }

    private static class Horse {
        int rank;
        String name;
        int odds;

        public Horse(int rank, String name, int odds) {
            this.rank = rank;
            this.name = name;
            this.odds = odds;
        }


    }

    public static class HorsesInventory {

        public List<Horse> availableHorses;


        public HorsesInventory() {
            availableHorses = new ArrayList<>();

        }
    }

    public static void main (String [] args){

        //
        BalanceInventory balanceInventory = new BalanceInventory();

        /*
        Upon startup, the machine should display a list of its current inventory of money,
        followed by a list ofhorses and current race results. At this point the program accepts user inpu
         */

        System.out.println(balanceInventory.toString());



    }
}
