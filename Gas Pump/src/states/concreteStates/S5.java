package states.concreteStates;

import mda.MDAEFSM;
import states.State;

public class S5 extends State {

    public S5(MDAEFSM m) {
        super(m);
    }

    @Override
    public void Pump() {
        op.PumpGasUnit();
        op.GasPumpedMsg();
    }

    @Override
    public void StopPump() {
        op.PrintReceipt();
        m.setState(m.getStates()[0]); // S0
    }
}
