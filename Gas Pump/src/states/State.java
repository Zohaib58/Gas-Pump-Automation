package states;

import mda.MDAEFSM;
import outputProcessor.OutputProcessor;

public abstract class State {
    protected MDAEFSM m;
    protected OutputProcessor op;

    public State(MDAEFSM m) {
        this.m = m;
        this.op = m.getOP();
    }

    // Default implementations do nothing (or could log "Invalid Action")
    public void Activate() {
    }

    public void Start() {
    }

    public void PayCredit() {
    }

    public void PayCash() {
    }

    public void PayDebit() {
    }

    public void Approved() {
    }

    public void Reject() {
    }

    public void Cancel() {
    }

    public void SelectGas(int g) {
    }

    public void StartPump() {
    }

    public void Pump() {
    }

    public void StopPump() {
    }

    public void CorrectPin() {
    }

    public void IncorrectPin(int max) {
    }
}
