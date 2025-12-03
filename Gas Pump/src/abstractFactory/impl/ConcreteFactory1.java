package abstractFactory.impl;

import abstractFactory.AbstractFactory;
import data.DataStore;
import data.impl.DS1;
import strategy.*;
import strategy.impl.*;

public class ConcreteFactory1 extends AbstractFactory {
    @Override
    public PayMsg createPayMsg() {
        return new PayMsg1();
    }

    @Override
    public StoreCash createStoreCash() {
        return new StoreCash1();
    }

    @Override
    public DisplayMenu createDisplayMenu() {
        return new DisplayMenu1();
    }

    @Override
    public RejectMsg createRejectMsg() {
        return new RejectMsg1();
    }

    @Override
    public SetPrice createSetPrice() {
        return new SetPrice1();
    }

    @Override
    public SetInitialValues createSetInitialValues() {
        return new SetInitialValues1();
    }

    @Override
    public PumpGasUnit createPumpGasUnit() {
        return new PumpGasUnit1();
    }

    @Override
    public GasPumpedMsg createGasPumpedMsg() {
        return new GasPumpedMsg1();
    }

    @Override
    public PrintReceipt createPrintReceipt() {
        return new PrintReceipt1();
    }

    @Override
    public CancelMsg createCancelMsg() {
        return new CancelMsg1();
    }

    @Override
    public ReturnCash createReturnCash() {
        return new ReturnCash1();
    }

    @Override
    public WrongPinMsg createWrongPinMsg() {
        return new WrongPinMsg1();
    }

    @Override
    public EjectCard createEjectCard() {
        return new EjectCard1();
    }

    @Override
    public SetW createSetW() {
        return new SetW1();
    }

    @Override
    public StorePrices createStorePrices() {
        return new StorePrices1();
    }

    @Override
    public StorePin createStorePin() {
        return new StorePin1();
    }

    @Override
    public EnterPinMsg createEnterPinMsg() {
        return new EnterPinMsg1();
    }

    @Override
    public InitializeData createInitializeData() {
        return new InitializeData1();
    }

    @Override
    public DataStore createDataStore() {
        return new DS1();
    }
}
