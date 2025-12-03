package states.concreteStates;

import mda.MDAEFSM;
import states.State;

public class S1 extends State {

    public S1(MDAEFSM m) {
        super(m);
    }

    @Override
    public void PayCredit() {
        m.setState(m.getStates()[2]); // S2
    }

    @Override
    public void PayCash() {
        op.StoreCash();
        op.DisplayMenu();
        op.SetW(0);
        m.setState(m.getStates()[3]); // S3
    }

    @Override
    public void PayDebit() {
        op.EnterPinMsg();
        op.StorePin();
        m.setK(0);
        m.setState(m.getStates()[5]); // S8
    }
}
