package states.concreteStates;

import mda.MDAEFSM;
import states.State;

public class Start extends State {

    public Start(MDAEFSM m) {
        super(m);
    }

    @Override
    public void Activate() {
        op.StorePrices();
        m.setState(m.getStates()[0]); // Transition to S0
    }
}
