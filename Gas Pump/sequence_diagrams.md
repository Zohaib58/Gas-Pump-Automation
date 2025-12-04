# Gas Pump Sequence Diagrams

You can copy the code blocks below and paste them into [Mermaid Live Editor](https://mermaid.live/) or [draw.io](https://app.diagrams.net/) (Insert -> Advanced -> Mermaid) to generate the diagrams.

## GasPump1 - Credit Flow (Success)

```mermaid
sequenceDiagram
    actor User
    participant GP1 as GasPump1
    participant DS as DataStore (DS1)
    participant MDA as MDAEFSM
    participant S as State (Current)
    participant OP as OutputProcessor

    User->>GP1: Activate(a)
    GP1->>DS: setTemp_a(a)
    GP1->>MDA: Activate()
    MDA->>S: Activate() (Start)
    S->>OP: StorePrices()
    S->>MDA: setState(S0)

    User->>GP1: Start()
    GP1->>MDA: Start()
    MDA->>S: Start() (S0)
    S->>OP: PayMsg()
    S->>OP: InitializeData()
    S->>OP: SetW(1)
    S->>MDA: setState(S1)

    User->>GP1: PayCredit()
    GP1->>MDA: PayCredit()
    MDA->>S: PayCredit() (S1)
    S->>MDA: setState(S2)

    User->>GP1: Approved()
    GP1->>MDA: Approved()
    MDA->>S: Approved() (S2)
    S->>OP: DisplayMenu()
    S->>OP: EjectCard()
    S->>MDA: setState(S3)

    User->>GP1: SelectGas(1)
    GP1->>MDA: SelectGas(1)
    MDA->>S: SelectGas(1) (S3)
    S->>OP: SetPrice(1)

    User->>GP1: StartPump()
    GP1->>MDA: StartPump()
    MDA->>S: StartPump() (S3)
    S->>OP: SetInitialValues()
    S->>MDA: setState(S5)

    User->>GP1: PumpLiter()
    GP1->>DS: getW() returns 1
    GP1->>MDA: Pump()
    MDA->>S: Pump() (S5)
    S->>OP: PumpGasUnit()
    S->>OP: GasPumpedMsg()

    User->>GP1: StopPump()
    GP1->>MDA: StopPump()
    MDA->>S: StopPump() (S5)
    S->>OP: PrintReceipt()
    S->>MDA: setState(S0)
```

## GasPump1 - Cash Flow (Prepaid Limit)

```mermaid
sequenceDiagram
    actor User
    participant GP1 as GasPump1
    participant DS as DataStore (DS1)
    participant MDA as MDAEFSM
    participant S as State (Current)
    participant OP as OutputProcessor

    Note over GP1, S: Assumes Start() called and in S1

    User->>GP1: PayCash(c)
    GP1->>DS: setTemp_c(c)
    GP1->>MDA: PayCash()
    MDA->>S: PayCash() (S1)
    S->>OP: StoreCash()
    S->>OP: DisplayMenu()
    S->>OP: SetW(0)
    S->>MDA: setState(S3)

    User->>GP1: SelectGas(1)
    GP1->>MDA: SelectGas(1)
    MDA->>S: SelectGas(1) (S3)
    S->>OP: SetPrice(1)

    User->>GP1: StartPump()
    GP1->>MDA: StartPump()
    MDA->>S: StartPump() (S3)
    S->>OP: SetInitialValues()
    S->>MDA: setState(S5)

    User->>GP1: PumpLiter()
    GP1->>DS: getW() returns 0
    GP1->>DS: Check Cash Limit
    alt Cash Sufficient
        GP1->>MDA: Pump()
        MDA->>S: Pump() (S5)
        S->>OP: PumpGasUnit()
        S->>OP: GasPumpedMsg()
    else Cash Limit Reached
        GP1->>MDA: StopPump()
        MDA->>S: StopPump() (S5)
        S->>OP: PrintReceipt()
        S->>MDA: setState(S0)
    end
```

## GasPump2 - Specific Scenario (PIN Retry & Full Tank)
**Sequence:** `Activate(4, 7)`, `Start()`, `PayDebit(123)`, `Pin(124)`, `Pin(123)`, `Regular()`, `StartPump()`, `PumpGallon()`, `FullTank()`

```mermaid
sequenceDiagram
    actor User
    participant GP2 as GasPump2
    participant DS as DataStore (DS2)
    participant MDA as MDAEFSM
    participant S as State (Current)
    participant OP as OutputProcessor

    %% Activate(4, 7)
    User->>GP2: Activate(4, 7)
    GP2->>DS: setTemp_a(4)
    GP2->>DS: setTemp_b(7)
    GP2->>MDA: Activate()
    MDA->>S: Activate() (Start)
    S->>OP: StorePrices()
    Note right of DS: Prices: Reg=4, Dsl=7
    S->>MDA: setState(S0)

    %% Start()
    User->>GP2: Start()
    GP2->>MDA: Start()
    MDA->>S: Start() (S0)
    S->>OP: PayMsg()
    S->>OP: InitializeData()
    S->>MDA: setState(S1)

    %% PayDebit(123)
    User->>GP2: PayDebit(123)
    GP2->>DS: setTemp_p(123)
    GP2->>MDA: PayDebit()
    MDA->>S: PayDebit() (S1)
    S->>OP: EnterPinMsg()
    S->>OP: StorePin()
    Note right of DS: PIN stored: 123
    S->>MDA: setK(0)
    S->>MDA: setState(S8)

    %% Pin(124) - Incorrect
    User->>GP2: Pin(124)
    GP2->>DS: getPin() (123) != 124
    GP2->>MDA: IncorrectPin(1)
    MDA->>S: IncorrectPin(1) (S8)
    S->>MDA: getK() (returns 0)
    Note right of S: 0 <= 1 (max)
    S->>OP: WrongPinMsg()
    S->>MDA: setK(1)
    Note right of S: Stay in S8

    %% Pin(123) - Correct
    User->>GP2: Pin(123)
    GP2->>DS: getPin() (123) == 123
    GP2->>MDA: CorrectPin()
    MDA->>S: CorrectPin() (S8)
    S->>OP: DisplayMenu()
    S->>OP: EjectCard()
    S->>MDA: setState(S3)

    %% Regular()
    User->>GP2: Regular()
    GP2->>MDA: SelectGas(1)
    MDA->>S: SelectGas(1) (S3)
    S->>OP: SetPrice(1)
    Note right of DS: Price set to 4

    %% StartPump()
    User->>GP2: StartPump()
    GP2->>DS: getPrice() > 0
    GP2->>MDA: StartPump()
    MDA->>S: StartPump() (S3)
    S->>OP: SetInitialValues()
    S->>MDA: setState(S5)

    %% PumpGallon()
    User->>GP2: PumpGallon()
    GP2->>MDA: Pump()
    MDA->>S: Pump() (S5)
    S->>OP: PumpGasUnit()
    S->>OP: GasPumpedMsg()
    Note right of DS: G=1, Total=4

    %% FullTank()
    User->>GP2: FullTank()
    GP2->>MDA: StopPump()
    MDA->>S: StopPump() (S5)
    S->>OP: PrintReceipt()
    S->>MDA: setState(S0)
```

## GasPump2 - Debit Flow (PIN Verification)

```mermaid
sequenceDiagram
    actor User
    participant GP2 as GasPump2
    participant DS as DataStore (DS2)
    participant MDA as MDAEFSM
    participant S as State (Current)
    participant OP as OutputProcessor

    Note over GP2, S: Assumes Start() called and in S1

    User->>GP2: PayDebit(p)
    GP2->>DS: setTemp_p(p)
    GP2->>MDA: PayDebit()
    MDA->>S: PayDebit() (S1)
    S->>OP: EnterPinMsg()
    S->>OP: StorePin()
    S->>MDA: setK(0)
    S->>MDA: setState(S8)

    User->>GP2: Pin(x)
    GP2->>DS: getPin() vs x
    alt Correct PIN
        GP2->>MDA: CorrectPin()
        MDA->>S: CorrectPin() (S8)
        S->>OP: DisplayMenu()
        S->>OP: EjectCard()
        S->>MDA: setState(S3)
    else Incorrect PIN
        GP2->>MDA: IncorrectPin(1)
        MDA->>S: IncorrectPin(1) (S8)
        S->>MDA: getK()
        alt k <= max
            S->>OP: WrongPinMsg()
            S->>MDA: setK(k+1)
            Note right of S: Stay in S8
        else k > max
            S->>OP: WrongPinMsg()
            S->>OP: EjectCard()
            S->>MDA: setState(S0)
        end
    end
```

## GasPump2 - Detailed Implementation Flow (All Classes)
**Scenario:** `Activate(4, 7)`, `Start()`, `PayDebit(123)`, `Pin(124)`, `Pin(123)`, `Regular()`, `StartPump()`, `PumpGallon()`, `FullTank()`

```mermaid
sequenceDiagram
    actor User
    participant GP2 as GasPump2
    participant CF2 as ConcreteFactory2
    participant DS2 as DS2
    participant OP as OutputProcessor
    participant SP2 as StorePrices2
    participant PM2 as PayMsg2
    participant ID2 as InitializeData2
    participant EPM2 as EnterPinMsg2
    participant SPin2 as StorePin2
    participant WPM2 as WrongPinMsg2
    participant DM2 as DisplayMenu2
    participant EC2 as EjectCard2
    participant SPr2 as SetPrice2
    participant SIV2 as SetInitialValues2
    participant PGU2 as PumpGasUnit2
    participant GPM2 as GasPumpedMsg2
    participant PR2 as PrintReceipt2
    participant MDA as MDAEFSM
    participant Start as Start
    participant S0 as S0
    participant S1 as S1
    participant S3 as S3
    participant S5 as S5
    participant S8 as S8

    %% Initialization
    Note over GP2, S8: System Initialization
    User->>GP2: new GasPump2()
    GP2->>CF2: new ConcreteFactory2()
    GP2->>CF2: createDataStore()
    CF2->>DS2: new DS2()
    GP2->>OP: new OutputProcessor(CF2, DS2)
    OP->>CF2: createStorePrices()
    CF2->>SP2: new StorePrices2()
    OP->>CF2: createPayMsg()
    CF2->>PM2: new PayMsg2()
    Note right of OP: ... (Creates all strategies) ...
    GP2->>MDA: new MDAEFSM(OP)
    GP2->>S0: new S0(MDA)
    GP2->>S1: new S1(MDA)
    GP2->>S3: new S3(MDA)
    GP2->>S5: new S5(MDA)
    GP2->>S8: new S8(MDA)
    GP2->>Start: new Start(MDA)
    GP2->>MDA: setStates(...)
    GP2->>MDA: setState(Start)

    %% Activate(4, 7)
    Note over GP2, S8: Activate(4, 7)
    User->>GP2: Activate(4, 7)
    GP2->>DS2: setTemp_a(4)
    Note right of DS2: temp_a = 4
    GP2->>DS2: setTemp_b(7)
    Note right of DS2: temp_b = 7
    GP2->>MDA: Activate()
    MDA->>Start: Activate()
    Start->>OP: StorePrices()
    OP->>SP2: storePrices(DS2)
    SP2->>DS2: setRPrice(temp_a)
    Note right of DS2: RPrice = 4
    SP2->>DS2: setDPrice(temp_b)
    Note right of DS2: DPrice = 7
    Start->>MDA: setState(S0)

    %% Start()
    Note over GP2, S8: Start()
    User->>GP2: Start()
    GP2->>MDA: Start()
    MDA->>S0: Start()
    S0->>OP: PayMsg()
    OP->>PM2: payMsg()
    S0->>OP: InitializeData()
    OP->>ID2: initializeData(DS2)
    ID2->>DS2: setPrice(0)
    Note right of DS2: price = 0
    S0->>MDA: setState(S1)

    %% PayDebit(123)
    Note over GP2, S8: PayDebit(123)
    User->>GP2: PayDebit(123)
    GP2->>DS2: setTemp_p(123)
    Note right of DS2: temp_p = 123
    GP2->>MDA: PayDebit()
    MDA->>S1: PayDebit()
    S1->>OP: EnterPinMsg()
    OP->>EPM2: enterPinMsg()
    S1->>OP: StorePin()
    OP->>SPin2: storePin(DS2)
    SPin2->>DS2: setPin(temp_p)
    Note right of DS2: pin = 123
    S1->>MDA: setK(0)
    Note right of MDA: k = 0
    S1->>MDA: setState(S8)

    %% Pin(124) - Incorrect
    Note over GP2, S8: Pin(124)
    User->>GP2: Pin(124)
    GP2->>DS2: getPin()
    Note right of DS2: returns 123
    GP2->>MDA: IncorrectPin(1)
    MDA->>S8: IncorrectPin(1)
    S8->>MDA: getK()
    Note right of MDA: returns 0
    S8->>OP: WrongPinMsg()
    OP->>WPM2: wrongPinMsg()
    S8->>MDA: setK(1)
    Note right of MDA: k = 1

    %% Pin(123) - Correct
    Note over GP2, S8: Pin(123)
    User->>GP2: Pin(123)
    GP2->>DS2: getPin()
    Note right of DS2: returns 123
    GP2->>MDA: CorrectPin()
    MDA->>S8: CorrectPin()
    S8->>OP: DisplayMenu()
    OP->>DM2: displayMenu()
    S8->>OP: EjectCard()
    OP->>EC2: ejectCard(DS2)
    S8->>MDA: setState(S3)

    %% Regular()
    Note over GP2, S8: Regular()
    User->>GP2: Regular()
    GP2->>MDA: SelectGas(1)
    MDA->>S3: SelectGas(1)
    S3->>OP: SetPrice(1)
    OP->>SPr2: setPrice(1, DS2)
    SPr2->>DS2: getRPrice()
    Note right of DS2: returns 4
    SPr2->>DS2: setPrice(4)
    Note right of DS2: price = 4

    %% StartPump()
    Note over GP2, S8: StartPump()
    User->>GP2: StartPump()
    GP2->>DS2: getPrice()
    Note right of DS2: returns 4
    GP2->>MDA: StartPump()
    MDA->>S3: StartPump()
    S3->>OP: SetInitialValues()
    OP->>SIV2: setInitialValues(DS2)
    SIV2->>DS2: setG(0)
    Note right of DS2: G = 0
    SIV2->>DS2: setTotal(0)
    Note right of DS2: total = 0
    S3->>MDA: setState(S5)

    %% PumpGallon()
    Note over GP2, S8: PumpGallon()
    User->>GP2: PumpGallon()
    GP2->>MDA: Pump()
    MDA->>S5: Pump()
    S5->>OP: PumpGasUnit()
    OP->>PGU2: pumpGasUnit(DS2)
    PGU2->>DS2: incG()
    Note right of DS2: G = 1
    PGU2->>DS2: calcTotal()
    Note right of DS2: total = 4 * 1 = 4
    S5->>OP: GasPumpedMsg()
    OP->>GPM2: gasPumpedMsg(DS2)

    %% FullTank()
    Note over GP2, S8: FullTank()
    User->>GP2: FullTank()
    GP2->>MDA: StopPump()
    MDA->>S5: StopPump()
    S5->>OP: PrintReceipt()
    OP->>PR2: printReceipt(DS2)
    S5->>MDA: setState(S0)
```
