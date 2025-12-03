package states.concreteStates;

import mda.MDAEFSM;
import states.State;

public class S3 extends State {

    public S3(MDAEFSM m) {
        super(m);
    }

    @Override
    public void SelectGas(int g) {
        op.SetPrice(g);
    }

    @Override
    public void StartPump() {
        op.SetInitialValues();
        m.setState(m.getStates()[4]); // S5
    }

    @Override
    public void Cancel() {
        op.CancelMsg();
        op.ReturnCash();
        m.setState(m.getStates()[0]); // S0
    }
}
