package chainofresponsibility;

import java.util.Scanner;

public class ATMChainTest {

    public static void main(String[] args) {

        new ATMChainTest();

    }

    public ATMChainTest() {

        // initialize the chain
        DispenseLink c1 = new Cash50Dispenser();
        DispenseLink c2 = new Cash20Dispenser();
        DispenseLink c3 = new Cash10Dispenser();

        // set the chain of responsibility
        c1.setNextLink(c2);
        c2.setNextLink(c3);

        while (true) {

            int amount = 0;

            System.out.println("Enter amount to dispense");

            Scanner input = new Scanner(System.in);
            amount = input.nextInt();

            if (amount % 10 != 0) {

                System.out.println("Amount should be in multiple of 10s.");
                break;

            }

            // process the request
            c1.dispense(new Currency(amount));
        }

    }

}
