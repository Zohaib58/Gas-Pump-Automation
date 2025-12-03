package gasPump;

import abstractFactory.AbstractFactory;
import abstractFactory.impl.ConcreteFactory2;
import data.DataStore;
import data.impl.DS2;
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

public class GasPump2 {
    private DataStore data;
    private MDAEFSM mda;

    public GasPump2() {
        AbstractFactory factory = new ConcreteFactory2();
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

        mda.setStates(states);
        mda.setState(new Start(mda)); // Initial state
    }

    public void Activate(int a, int b) {
        if (a > 0 && b > 0) {
            ((DS2) data).setTemp_a(a);
            ((DS2) data).setTemp_b(b);
            mda.Activate();
        }
    }

    public void Start() {
        mda.Start();
    }

    public void PayCredit() {
        mda.PayCredit();
    }

    public void Reject() {
        mda.Reject();
    }

    public void Approved() {
        mda.Approved();
    }

    public void PayDebit(int p) {
        ((DS2) data).setTemp_p(p);
        mda.PayDebit(); // Debit is usually type 3
    }

    public void Regular() {
        mda.SelectGas(1);
    }

    public void Diesel() {
        mda.SelectGas(2);
    }

    public void StartPump() {
        // Added price check as per diagram/requirements
        if (((DS2) data).getPrice() > 0) {
            mda.StartPump();
        }
    }

    public void Pin(int x) {
        if (((DS2) data).getPin() == x) {
            mda.CorrectPin();
        } else {
            mda.IncorrectPin(1);
        }
    }

    public void PumpGallon() {
        mda.Pump();
    }

    public void StopPump() {
        mda.StopPump();
    }

    public void FullTank() {
        mda.StopPump();
    }
}
