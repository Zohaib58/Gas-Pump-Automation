package gasPump;

import abstractFactory.AbstractFactory;
import abstractFactory.impl.ConcreteFactory1;
import data.DataStore;
import data.impl.DS1;
import mda.MDAEFSM;
import outputProcessor.OutputProcessor;
import states.*;
import states.concreteStates.S0;
import states.concreteStates.S1;
import states.concreteStates.S2;
import states.concreteStates.S3;
import states.concreteStates.S5;
import states.concreteStates.S8;
import states.concreteStates.Start;

public class GasPump1 {
    private DataStore data;
    private MDAEFSM mda;

    public GasPump1() {
        AbstractFactory factory = new ConcreteFactory1();
        this.data = factory.createDataStore();
        OutputProcessor op = new OutputProcessor(factory, data);
        this.mda = new MDAEFSM(op);

        State[] states = new State[7];
        states[0] = new S0(mda);
        states[1] = new S1(mda);
        states[2] = new S2(mda);
        states[3] = new S3(mda);
        states[4] = new S5(mda);
        states[5] = new S8(mda);
        // Start state is initial, not in the array for transitions usually,
        // but we can put it if needed. The array is for "next state" lookup.
        // Start state transitions to S0 (index 0).

        mda.setStates(states);
        mda.setState(new Start(mda)); // Initial state
    }

    public void Activate(float a) {
        if (a > 0) {
            ((DS1) data).setTemp_a(a);
            mda.Activate();
        }
    }

    public void Start() {
        mda.Start();
    }

    public void PayCredit() {
        mda.PayCredit();
    }

    public void PayCash(float c) {
        if (c > 0) {
            ((DS1) data).setTemp_c(c);
            mda.PayCash();
        }
    }

    public void SelectGas(int g) {
        mda.SelectGas(g);
    }

    public void Reject() {
        mda.Reject();
    }

    public void Approved() {
        mda.Approved();
    }

    public void Cancel() {
        mda.Cancel();
    }

    public void StartPump() {
        mda.StartPump();
    }

    public void PumpLiter() {
        if (((DS1) data).getW() == 1) {
            mda.Pump();
        } else if (((DS1) data).getCash() > 0
                && ((DS1) data).getCash() < ((DS1) data).getPrice() * (((DS1) data).getL() + 1)) {
            mda.StopPump();
        } else {
            mda.Pump();
        }
    }

    public void StopPump() {
        mda.StopPump();
    }
}
