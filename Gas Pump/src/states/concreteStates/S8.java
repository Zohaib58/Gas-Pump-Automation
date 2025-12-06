package states.concreteStates;

import mda.MDAEFSM;
import states.State;

public class S8 extends State {
    /* DESIGN PATTERN: State - Concrete State */
    /*
     * Responsibilities: Implements behavior associated with the 'PIN Verification'
     * state
     */

    public S8(MDAEFSM m) {
        super(m);
    }

    @Override
    public void CorrectPin() {
        op.DisplayMenu();
        op.EjectCard();
        m.setState(m.getStates()[3]); // S3
    }

    @Override
    public void IncorrectPin(int max) {
        int k = m.getK();
        if (k <= max) {
            op.WrongPinMsg(false);
            m.setK(k + 1);
            // Stay in S8
        } else {
            op.WrongPinMsg(true);
            op.EjectCard();
            m.setState(m.getStates()[0]); // S0
        }
    }
}
