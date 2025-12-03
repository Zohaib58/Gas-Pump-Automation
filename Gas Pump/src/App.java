import gasPump.GasPump1;
import gasPump.GasPump2;

public class App {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("           Gas Pump Automation System            ");
        System.out.println("=================================================");

        System.out.println("\n--- Testing GasPump1 ---");
        GasPump1 gp1 = new GasPump1();
        gp1.Activate(1.5f);
        gp1.Start();
        gp1.PayCredit();
        gp1.Approved();
        gp1.SelectGas(1);
        gp1.StartPump();
        gp1.PumpLiter();
        gp1.PumpLiter(); // Pump another liter
        gp1.StopPump();

        System.out.println("\n--- Testing GasPump2 ---");
        GasPump2 gp2 = new GasPump2();
        gp2.Activate(2, 3);
        gp2.Start();
        gp2.PayCredit();
        gp2.Approved();
        gp2.Regular();
        gp2.StartPump();
        gp2.PumpGallon();
        gp2.PumpGallon(); // Pump another gallon
        gp2.PumpGallon(); // Pump a third gallon
        gp2.StopPump();

        System.out.println("\n=================================================");
        System.out.println("           Test Execution Completed              ");
        System.out.println("=================================================");
    }
}
