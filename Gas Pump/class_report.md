# Class Design Report

## 1. Input Processors

### GasPump1
**Purpose:**
Acts as the Input Processor for the first Gas Pump configuration. It bridges the platform-specific hardware inputs to the platform-independent State Machine (MDA-EFSM).

**Responsibilities of Operations:**
- `Activate(float a)`: Activates the pump with a price `a` for Regular gas. Parses input and calls `mda.Activate()`.
- `Start()`: Initiates the transaction. Calls `mda.Start()`.
- `PayCredit()`: Handles credit card payment input. Calls `mda.PayCredit()`.
- `Reject()`: Simulates credit card rejection. Calls `mda.Reject()`.
- `Cancel()`: Cancels the current transaction. Calls `mda.Cancel()`.
- `Approved()`: Simulates credit card approval. Calls `mda.Approved()`.
- `PayCash(float c)`: Handles cash insertion. Updates temp cash in DataStore and calls `mda.PayCash()`.
- `StartPump()`: Starts the pumping process. Calls `mda.StartPump()`.
- `PumpLiter()`: Simulates pumping 1 liter. Checks for cash limits (prepaid) and calls `mda.Pump()` or `mda.StopPump()`.
- `StopPump()`: Stops the pumping process manually. Calls `mda.StopPump()`.

### GasPump2
**Purpose:**
Acts as the Input Processor for the second Gas Pump configuration. It handles inputs specific to GasPump2 (Debit, PIN, Diesel) and maps them to the MDA-EFSM.

**Responsibilities of Operations:**
- `Activate(int a, int b)`: Activates the pump with prices for Regular (`a`) and Diesel (`b`). Updates DataStore and calls `mda.Activate()`.
- `Start()`: Initiates the transaction. Calls `mda.Start()`.
- `PayCredit()`: Handles credit card payment. Calls `mda.PayCredit()`.
- `Reject()`: Simulates credit card rejection. Calls `mda.Reject()`.
- `Approved()`: Simulates credit card approval. Calls `mda.Approved()`.
- `PayDebit(int p)`: Handles debit card payment with a PIN `p`. Updates temp PIN in DataStore and calls `mda.PayDebit()`.
- `Pin(int x)`: Verifies the entered PIN `x` against the stored PIN. Calls `mda.CorrectPin()` or `mda.IncorrectPin()`.
- `Regular()`: Selects Regular gas. Calls `mda.SelectGas(1)`.
- `Diesel()`: Selects Diesel gas. Calls `mda.SelectGas(2)`.
- `StartPump()`: Starts the pumping process. Checks if price is set and calls `mda.StartPump()`.
- `PumpGallon()`: Simulates pumping 1 gallon. Calls `mda.Pump()`.
- `StopPump()`: Stops the pumping process. Calls `mda.StopPump()`.
- `FullTank()`: Simulates a full tank event (auto-stop). Calls `mda.StopPump()`.

---

## 2. State Machine

### MDAEFSM
**Purpose:**
Implements the platform-independent State Machine logic. It maintains the current state context and delegates events to the current state object.

**Responsibilities of Operations:**
- `Activate()`: Delegates to `state.Activate()`.
- `Start()`: Delegates to `state.Start()`.
- `PayCredit()`: Delegates to `state.PayCredit()`.
- `PayCash()`: Delegates to `state.PayCash()`.
- `PayDebit()`: Delegates to `state.PayDebit()`.
- `Approved()`: Delegates to `state.Approved()`.
- `Reject()`: Delegates to `state.Reject()`.
- `Cancel()`: Delegates to `state.Cancel()`.
- `SelectGas(int g)`: Delegates to `state.SelectGas(g)`.
- `StartPump()`: Delegates to `state.StartPump()`.
- `Pump()`: Delegates to `state.Pump()`.
- `StopPump()`: Delegates to `state.StopPump()`.
- `CorrectPin()`: Delegates to `state.CorrectPin()`.
- `IncorrectPin(int max)`: Delegates to `state.IncorrectPin(max)`.
- `setState(State s)`: Transitions the system to a new state `s`.
- `getStates()`: Returns the array of all state objects.
- `getK()`: Returns the PIN retry counter.
- `setK(int k)`: Sets the PIN retry counter.

---

## 3. States

### State (Abstract)
**Purpose:**
Defines the interface for all states in the EFSM. Provides default empty implementations.

**Responsibilities of Operations:**
- `Activate()`, `Start()`, `PayCredit()`, etc.: Default implementations that do nothing.

### Start
**Purpose:**
Initial state waiting for activation.
**Responsibilities of Operations:**
- `Activate()`: Stores prices and transitions to `S0`.

### S0
**Purpose:**
Idle state.
**Responsibilities of Operations:**
- `Start()`: Displays Pay Message, initializes data, sets `w` flag, and transitions to `S1`.

### S1
**Purpose:**
Payment Selection state.
**Responsibilities of Operations:**
- `PayCredit()`: Transitions to `S2`.
- `PayCash()`: Stores cash, displays menu, sets `w=0`, and transitions to `S3`.
- `PayDebit()`: Displays PIN entry message, stores PIN, resets `k`, and transitions to `S8`.

### S2
**Purpose:**
Credit Approval state.
**Responsibilities of Operations:**
- `Approved()`: Displays menu, ejects card, and transitions to `S3`.
- `Reject()`: Displays rejection message, ejects card, and transitions to `S0`.

### S3
**Purpose:**
Gas Selection state.
**Responsibilities of Operations:**
- `SelectGas(int g)`: Sets the price for the selected gas `g`.
- `StartPump()`: Sets initial values and transitions to `S5`.
- `Cancel()`: Cancels transaction, returns cash, and transitions to `S0`.

### S5
**Purpose:**
Pumping state.
**Responsibilities of Operations:**
- `Pump()`: Pumps a unit of gas, updates totals, and displays progress.
- `StopPump()`: Prints receipt and transitions to `S0`.

### S8
**Purpose:**
PIN Verification state.
**Responsibilities of Operations:**
- `CorrectPin()`: Displays menu, ejects card, and transitions to `S3`.
- `IncorrectPin(int max)`: Checks retries. If `k <= max`, displays wrong PIN and increments `k`. Else, ejects card and transitions to `S0`.

---

## 4. Output Processor

### OutputProcessor
**Purpose:**
Client for the Strategy Pattern. Delegates meta-actions to specific strategy objects.

**Responsibilities of Operations:**
- `StorePrices()`: Calls `storePricesStrategy.storePrices(data)`.
- `PayMsg()`: Calls `payMsgStrategy.payMsg()`.
- `StoreCash()`: Calls `storeCashStrategy.storeCash(data)`.
- `DisplayMenu()`: Calls `displayMenuStrategy.displayMenu()`.
- `RejectMsg()`: Calls `rejectMsgStrategy.rejectMsg()`.
- `SetW()`: Calls `setWStrategy.setW(data, w)`.
- `SetPrice()`: Calls `setPriceStrategy.setPrice(g, data)`.
- `SetInitialValues()`: Calls `setInitialValuesStrategy.setInitialValues(data)`.
- `PumpGasUnit()`: Calls `pumpGasUnitStrategy.pumpGasUnit(data)`.
- `GasPumpedMsg()`: Calls `gasPumpedMsgStrategy.gasPumpedMsg(data)`.
- `PrintReceipt()`: Calls `printReceiptStrategy.printReceipt(data)`.
- `CancelMsg()`: Calls `cancelMsgStrategy.cancelMsg()`.
- `EnterPinMsg()`: Calls `enterPinMsgStrategy.enterPinMsg()`.
- `StorePin()`: Calls `storePinStrategy.storePin(data)`.
- `WrongPinMsg()`: Calls `wrongPinMsgStrategy.wrongPinMsg()`.
- `EjectCard()`: Calls `ejectCardStrategy.ejectCard(data)`.

---

## 5. Strategies (Abstract & Concrete)

### StorePrices (Interface)
**Purpose:** Interface for storing prices.
- `storePrices(DataStore data)`: Stores price data.

### StorePrices1
**Purpose:** Concrete strategy for GasPump1.
- `storePrices(DataStore data)`: Stores `temp_a` into `price` in `DS1`.

### StorePrices2
**Purpose:** Concrete strategy for GasPump2.
- `storePrices(DataStore data)`: Stores `temp_a` into `Rprice` and `temp_b` into `Dprice` in `DS2`.

### PayMsg (Interface)
**Purpose:** Interface for payment message.
- `payMsg()`: Displays payment options.

### PayMsg1
**Purpose:** Concrete strategy for GasPump1.
- `payMsg()`: Displays "Select Payment: Credit or Cash".

### PayMsg2
**Purpose:** Concrete strategy for GasPump2.
- `payMsg()`: Displays "Select Payment: Credit or Debit".

### StoreCash (Interface)
**Purpose:** Interface for storing cash.
- `storeCash(DataStore data)`: Stores inserted cash.

### StoreCash1
**Purpose:** Concrete strategy for GasPump1.
- `storeCash(DataStore data)`: Stores `temp_c` into `cash` in `DS1`.

### StoreCash2
**Purpose:** Concrete strategy for GasPump2.
- `storeCash(DataStore data)`: Empty implementation (GasPump2 does not accept cash).

### DisplayMenu (Interface)
**Purpose:** Interface for displaying menu.
- `displayMenu()`: Displays gas selection menu.

### DisplayMenu1
**Purpose:** Concrete strategy for GasPump1.
- `displayMenu()`: Displays "Select Gas: Regular".

### DisplayMenu2
**Purpose:** Concrete strategy for GasPump2.
- `displayMenu()`: Displays "Select Gas: Regular or Diesel".

### RejectMsg (Interface)
**Purpose:** Interface for rejection message.
- `rejectMsg()`: Displays credit rejection message.

### RejectMsg1
**Purpose:** Concrete strategy for GasPump1.
- `rejectMsg()`: Displays "Credit Card Rejected".

### RejectMsg2
**Purpose:** Concrete strategy for GasPump2.
- `rejectMsg()`: Displays "Credit Card Rejected".

### SetW (Interface)
**Purpose:** Interface for setting cash flag.
- `setW(DataStore data, int w)`: Sets the `w` flag.

### SetW1
**Purpose:** Concrete strategy for GasPump1.
- `setW(DataStore data, int w)`: Sets `w` in `DS1`.

### SetW2
**Purpose:** Concrete strategy for GasPump2.
- `setW(DataStore data, int w)`: Empty implementation.

### SetPrice (Interface)
**Purpose:** Interface for setting current price.
- `setPrice(int g, DataStore data)`: Sets price based on grade `g`.

### SetPrice1
**Purpose:** Concrete strategy for GasPump1.
- `setPrice(int g, DataStore data)`: Sets `price` in `DS1` (only one grade).

### SetPrice2
**Purpose:** Concrete strategy for GasPump2.
- `setPrice(int g, DataStore data)`: Sets `price` in `DS2` (Regular if g=1, Diesel if g=2).

### SetInitialValues (Interface)
**Purpose:** Interface for initializing pump values.
- `setInitialValues(DataStore data)`: Resets volume and total.

### SetInitialValues1
**Purpose:** Concrete strategy for GasPump1.
- `setInitialValues(DataStore data)`: Resets `L` and `total` to 0 in `DS1`.

### SetInitialValues2
**Purpose:** Concrete strategy for GasPump2.
- `setInitialValues(DataStore data)`: Resets `G` and `total` to 0 in `DS2`.

### PumpGasUnit (Interface)
**Purpose:** Interface for pumping logic.
- `pumpGasUnit(DataStore data)`: Increments volume and calculates total.

### PumpGasUnit1
**Purpose:** Concrete strategy for GasPump1.
- `pumpGasUnit(DataStore data)`: Increments `L`, calculates `total = price * L`.

### PumpGasUnit2
**Purpose:** Concrete strategy for GasPump2.
- `pumpGasUnit(DataStore data)`: Increments `G`, calculates `total = price * G`.

### GasPumpedMsg (Interface)
**Purpose:** Interface for pumping message.
- `gasPumpedMsg(DataStore data)`: Displays pumped amount.

### GasPumpedMsg1
**Purpose:** Concrete strategy for GasPump1.
- `gasPumpedMsg(DataStore data)`: Displays "Pumped 1 liter".

### GasPumpedMsg2
**Purpose:** Concrete strategy for GasPump2.
- `gasPumpedMsg(DataStore data)`: Displays "Pumped 1 gallon".

### PrintReceipt (Interface)
**Purpose:** Interface for printing receipt.
- `printReceipt(DataStore data)`: Prints final receipt.

### PrintReceipt1
**Purpose:** Concrete strategy for GasPump1.
- `printReceipt(DataStore data)`: Prints Liters and Total from `DS1`.

### PrintReceipt2
**Purpose:** Concrete strategy for GasPump2.
- `printReceipt(DataStore data)`: Prints Gallons and Total from `DS2`.

### CancelMsg (Interface)
**Purpose:** Interface for cancellation message.
- `cancelMsg()`: Displays cancellation message.

### CancelMsg1
**Purpose:** Concrete strategy for GasPump1.
- `cancelMsg()`: Displays "Transaction Cancelled".

### CancelMsg2
**Purpose:** Concrete strategy for GasPump2.
- `cancelMsg()`: Displays "Transaction Cancelled".

### EnterPinMsg (Interface)
**Purpose:** Interface for PIN entry message.
- `enterPinMsg()`: Displays PIN prompt.

### EnterPinMsg1
**Purpose:** Concrete strategy for GasPump1.
- `enterPinMsg()`: Empty implementation.

### EnterPinMsg2
**Purpose:** Concrete strategy for GasPump2.
- `enterPinMsg()`: Displays "Please Enter PIN".

### StorePin (Interface)
**Purpose:** Interface for storing PIN.
- `storePin(DataStore data)`: Stores entered PIN.

### StorePin1
**Purpose:** Concrete strategy for GasPump1.
- `storePin(DataStore data)`: Empty implementation.

### StorePin2
**Purpose:** Concrete strategy for GasPump2.
- `storePin(DataStore data)`: Stores `temp_p` into `pin` in `DS2`.

### WrongPinMsg (Interface)
**Purpose:** Interface for wrong PIN message.
- `wrongPinMsg()`: Displays wrong PIN error.

### WrongPinMsg1
**Purpose:** Concrete strategy for GasPump1.
- `wrongPinMsg()`: Empty implementation.

### WrongPinMsg2
**Purpose:** Concrete strategy for GasPump2.
- `wrongPinMsg()`: Displays "WRONG PIN".

### EjectCard (Interface)
**Purpose:** Interface for ejecting card.
- `ejectCard(DataStore data)`: Displays eject message.

### EjectCard1
**Purpose:** Concrete strategy for GasPump1.
- `ejectCard(DataStore data)`: Empty implementation.

### EjectCard2
**Purpose:** Concrete strategy for GasPump2.
- `ejectCard(DataStore data)`: Displays "Card Ejected".

---

## 6. Data Store

### DataStore (Abstract)
**Purpose:**
Defines the abstract interface for data storage.

### DS1
**Purpose:**
Concrete Data Store for GasPump1.
**Responsibilities of Operations:**
- `getTemp_a()`, `setTemp_a()`: Manage temporary price.
- `getTemp_c()`, `setTemp_c()`: Manage temporary cash.
- `getCash()`, `setCash()`: Manage stored cash.
- `getPrice()`, `setPrice()`: Manage current price.
- `getL()`, `setL()`: Manage liters pumped.
- `getTotal()`, `setTotal()`: Manage total cost.
- `getW()`, `setW()`: Manage cash flag.

### DS2
**Purpose:**
Concrete Data Store for GasPump2.
**Responsibilities of Operations:**
- `getTemp_a()`, `setTemp_a()`: Manage temporary Regular price.
- `getTemp_b()`, `setTemp_b()`: Manage temporary Diesel price.
- `getTemp_p()`, `setTemp_p()`: Manage temporary PIN.
- `getRprice()`, `setRprice()`: Manage Regular price.
- `getDprice()`, `setDprice()`: Manage Diesel price.
- `getPrice()`, `setPrice()`: Manage current selected price.
- `getG()`, `setG()`: Manage gallons pumped.
- `getTotal()`, `setTotal()`: Manage total cost.
- `getPin()`, `setPin()`: Manage stored PIN.

---

## 7. Abstract Factory

### AbstractFactory
**Purpose:**
Defines the interface for creating families of related objects (Strategies and DataStore).
**Responsibilities of Operations:**
- `createDataStore()`: Abstract method to create DataStore.
- `createStorePrices()`: Abstract method to create StorePrices strategy.
- `createPayMsg()`: Abstract method to create PayMsg strategy.
- `createStoreCash()`: Abstract method to create StoreCash strategy.
- `createDisplayMenu()`: Abstract method to create DisplayMenu strategy.
- `createRejectMsg()`: Abstract method to create RejectMsg strategy.
- `createSetW()`: Abstract method to create SetW strategy.
- `createSetPrice()`: Abstract method to create SetPrice strategy.
- `createSetInitialValues()`: Abstract method to create SetInitialValues strategy.
- `createPumpGasUnit()`: Abstract method to create PumpGasUnit strategy.
- `createGasPumpedMsg()`: Abstract method to create GasPumpedMsg strategy.
- `createPrintReceipt()`: Abstract method to create PrintReceipt strategy.
- `createCancelMsg()`: Abstract method to create CancelMsg strategy.
- `createEnterPinMsg()`: Abstract method to create EnterPinMsg strategy.
- `createStorePin()`: Abstract method to create StorePin strategy.
- `createWrongPinMsg()`: Abstract method to create WrongPinMsg strategy.
- `createEjectCard()`: Abstract method to create EjectCard strategy.

### ConcreteFactory1
**Purpose:**
Creates components for GasPump1.
**Responsibilities of Operations:**
- `createDataStore()`: Returns `new DS1()`.
- `createStorePrices()`: Returns `new StorePrices1()`.
- `createPayMsg()`: Returns `new PayMsg1()`.
- ... (and so on for all strategies): Returns the corresponding "1" strategy.

### ConcreteFactory2
**Purpose:**
Creates components for GasPump2.
**Responsibilities of Operations:**
- `createDataStore()`: Returns `new DS2()`.
- `createStorePrices()`: Returns `new StorePrices2()`.
- `createPayMsg()`: Returns `new PayMsg2()`.
- ... (and so on for all strategies): Returns the corresponding "2" strategy.
