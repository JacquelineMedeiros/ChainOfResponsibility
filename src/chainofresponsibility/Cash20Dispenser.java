/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsibility;

/**
 *
 * @author jacqu
 */
public class Cash20Dispenser implements DispenseLink {

    private DispenseLink nextLink;

    public Cash20Dispenser() {
    }

    @Override
    public void setNextLink(DispenseLink nextLink) {
        this.nextLink = nextLink;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 20) {
            int toDispense = cur.getAmount() / 20;
            System.out.println("Dispensing " + toDispense + " 20 Euro note");
            int remainder = cur.getAmount() % 20; //

            if (remainder > 0) {
                nextLink.dispense(new Currency(remainder));
            }

        } else {
            nextLink.dispense(cur); //pass on to the next link in the chain because if less than 50
        }
    }

}
