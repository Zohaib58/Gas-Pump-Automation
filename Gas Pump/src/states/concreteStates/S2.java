package states.concreteStates;

import mda.MDAEFSM;
import states.State;

public class S2 extends State {
    /* DESIGN PATTERN: State - Concrete State */
    /*
     * Responsibilities: Implements behavior associated with the 'Credit Approval'
     * state
     */

    public S2(MDAEFSM m) {
        super(m);
    }

    @Override
    public void Approved() {
        op.DisplayMenu();
        op.EjectCard();
        m.setState(m.getStates()[3]); // S3
    }

    @Override
    public void Reject() {
        op.RejectMsg();
        op.EjectCard();
        m.setState(m.getStates()[0]); // S0
    }
}
