package mda;

import outputProcessor.OutputProcessor;
import states.State;

public class MDAEFSM {
    /* DESIGN PATTERN: State - Context Class */
    /*
     * Responsibilities: Maintains the current state and delegates requests to the
     * state object
     */
    private State s;
    private State[] LS;
    private OutputProcessor p;
    private int k;

    public MDAEFSM(OutputProcessor p) {
        this.p = p;
        // LS will be initialized with concrete states in the main setup or a setup
        // method
    }

    public void setStates(State[] LS) {
        this.LS = LS;
    }

    public void setState(State s) {
        this.s = s;
    }

    public State getState() {
        return s;
    }

    public State[] getStates() {
        return LS;
    }

    public OutputProcessor getOP() {
        return p;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    // Events
    public void Activate() {
        s.Activate();
    }

    public void Start() {
        s.Start();
    }

    public void PayCredit() {
        s.PayCredit();
    }

    public void PayCash() {
        s.PayCash();
    }

    public void PayDebit() {
        s.PayDebit();
    }

    public void Approved() {
        s.Approved();
    }

    public void Reject() {
        s.Reject();
    }

    public void Cancel() {
        s.Cancel();
    }

    public void SelectGas(int g) {
        s.SelectGas(g);
    }

    public void StartPump() {
        s.StartPump();
    }

    public void Pump() {
        s.Pump();
    }

    public void StopPump() {
        s.StopPump();
    }

    public void CorrectPin() {
        s.CorrectPin();
    }

    public void IncorrectPin(int max) {
        s.IncorrectPin(max);
    }
}
