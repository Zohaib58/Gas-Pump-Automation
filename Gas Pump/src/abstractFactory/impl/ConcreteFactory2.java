package abstractFactory.impl;

import abstractFactory.AbstractFactory;
import strategy.*;
import strategy.impl.*;

public class ConcreteFactory2 extends AbstractFactory {
    @Override
    public PayMsg createPayMsg() {
        return new PayMsg2();
    }

    @Override
    public StoreCash createStoreCash() {
        return new StoreCash2();
    }

    @Override
    public DisplayMenu createDisplayMenu() {
        return new DisplayMenu2();
    }

    @Override
    public RejectMsg createRejectMsg() {
        return new RejectMsg2();
    }

    @Override
    public SetPrice createSetPrice() {
        return new SetPrice2();
    }

    @Override
    public SetInitialValues createSetInitialValues() {
        return new SetInitialValues2();
    }

    @Override
    public PumpGasUnit createPumpGasUnit() {
        return new PumpGasUnit2();
    }

    @Override
    public GasPumpedMsg createGasPumpedMsg() {
        return new GasPumpedMsg2();
    }

    @Override
    public PrintReceipt createPrintReceipt() {
        return new PrintReceipt2();
    }

    @Override
    public CancelMsg createCancelMsg() {
        return new CancelMsg2();
    }

    @Override
    public ReturnCash createReturnCash() {
        return new ReturnCash2();
    }

    @Override
    public WrongPinMsg createWrongPinMsg() {
        return new WrongPinMsg2();
    }

    @Override
    public EjectCard createEjectCard() {
        return new EjectCard2();
    }

    @Override
    public SetW createSetW() {
        return new SetW2();
    }

    @Override
    public StorePrices createStorePrices() {
        return new StorePrices2();
    }

    @Override
    public StorePin createStorePin() {
        return new StorePin2();
    }

    @Override
    public EnterPinMsg createEnterPinMsg() {
        return new EnterPinMsg2();
    }

    @Override
    public InitializeData createInitializeData() {
        return new InitializeData2();
    }
}
