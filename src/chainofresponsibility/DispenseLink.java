package chainofresponsibility;

public interface DispenseLink {

    void setNextLink(DispenseLink nextLink);

    void dispense(Currency cur);

}
