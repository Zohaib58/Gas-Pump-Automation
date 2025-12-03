package outputProcessor;

import abstractFactory.AbstractFactory;
import data.DataStore;
import strategy.*;

public class OutputProcessor {
    private DataStore data;
    private StorePrices storePrices;
    private PayMsg payMsg;
    private StoreCash storeCash;
    private DisplayMenu displayMenu;
    private RejectMsg rejectMsg;
    private SetPrice setPrice;
    private SetInitialValues setInitialValues;
    private PumpGasUnit pumpGasUnit;
    private GasPumpedMsg gasPumpedMsg;
    private PrintReceipt printReceipt;
    private CancelMsg cancelMsg;
    private ReturnCash returnCash;
    private WrongPinMsg wrongPinMsg;
    private StorePin storePin;
    private EnterPinMsg enterPinMsg;
    private InitializeData initializeData;
    private SetW setW;
    private EjectCard ejectCard;

    public OutputProcessor(AbstractFactory factory, DataStore data) {
        this.data = data;
        this.storePrices = factory.createStorePrices();
        this.payMsg = factory.createPayMsg();
        this.storeCash = factory.createStoreCash();
        this.displayMenu = factory.createDisplayMenu();
        this.rejectMsg = factory.createRejectMsg();
        this.setPrice = factory.createSetPrice();
        this.setInitialValues = factory.createSetInitialValues();
        this.pumpGasUnit = factory.createPumpGasUnit();
        this.gasPumpedMsg = factory.createGasPumpedMsg();
        this.printReceipt = factory.createPrintReceipt();
        this.cancelMsg = factory.createCancelMsg();
        this.returnCash = factory.createReturnCash();
        this.wrongPinMsg = factory.createWrongPinMsg();
        this.storePin = factory.createStorePin();
        this.enterPinMsg = factory.createEnterPinMsg();
        this.initializeData = factory.createInitializeData();
        this.setW = factory.createSetW();
        this.ejectCard = factory.createEjectCard();
    }

    public void StorePrices() {
        storePrices.storePrices(data);
    }

    public void PayMsg() {
        payMsg.payMsg();
    }

    public void StoreCash() {
        storeCash.storeCash(data);
    }

    public void DisplayMenu() {
        displayMenu.displayMenu();
    }

    public void RejectMsg() {
        rejectMsg.rejectMsg();
    }

    public void SetPrice(int g) {
        setPrice.setPrice(g, data);
    }

    public void SetInitialValues() {
        setInitialValues.setInitialValues(data);
    }

    public void PumpGasUnit() {
        pumpGasUnit.pumpGasUnit(data);
    }

    public void GasPumpedMsg() {
        gasPumpedMsg.gasPumpedMsg(data);
    }

    public void PrintReceipt() {
        printReceipt.printReceipt(data);
    }

    public void CancelMsg() {
        cancelMsg.cancelMsg();
    }

    public void ReturnCash() {
        returnCash.returnCash(data);
    }

    public void WrongPinMsg() {
        wrongPinMsg.wrongPinMsg();
    }

    public void StorePin() {
        storePin.storePin(data);
    }

    public void EnterPinMsg() {
        enterPinMsg.enterPinMsg(data);
    }

    public void InitializeData() {
        initializeData.initializeData(data);
    }

    public void SetW(int w) {
        setW.setW(w, data);
    }

    public void EjectCard() {
        ejectCard.ejectCard(data);
    }
}
