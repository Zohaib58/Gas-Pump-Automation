package states.concreteStates;

import mda.MDAEFSM;
import states.State;

public class S0 extends State {

    public S0(MDAEFSM m) {
        super(m);
    }

    @Override
    public void Start() {
        op.PayMsg();
        op.InitializeData();
        op.SetW(1);
        m.setState(m.getStates()[1]); // S1
    }

}
