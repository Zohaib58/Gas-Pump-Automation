package abstractFactory;

import strategy.*;

public abstract class AbstractFactory {
    public abstract PayMsg createPayMsg();

    public abstract StoreCash createStoreCash();

    public abstract DisplayMenu createDisplayMenu();

    public abstract RejectMsg createRejectMsg();

    public abstract SetPrice createSetPrice();

    public abstract SetInitialValues createSetInitialValues();

    public abstract PumpGasUnit createPumpGasUnit();

    public abstract GasPumpedMsg createGasPumpedMsg();

    public abstract PrintReceipt createPrintReceipt();

    public abstract CancelMsg createCancelMsg();

    public abstract ReturnCash createReturnCash();

    public abstract WrongPinMsg createWrongPinMsg();

    public abstract EjectCard createEjectCard();

    public abstract SetW createSetW();

    public abstract StorePrices createStorePrices();

    public abstract StorePin createStorePin();

    public abstract EnterPinMsg createEnterPinMsg();

    public abstract InitializeData createInitializeData();
}
