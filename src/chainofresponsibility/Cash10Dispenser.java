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
public class Cash10Dispenser implements DispenseLink {

    private DispenseLink nextLink;

    public Cash10Dispenser() {
    }

    @Override
    public void setNextLink(DispenseLink nextLink) {
        this.nextLink = null;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 10) {
            int toDispense = cur.getAmount() / 10;
            System.out.println("Dispensing " + toDispense + " 10 Euro note");
        }
    }
}
