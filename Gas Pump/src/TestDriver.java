import gasPump.GasPump1;
import gasPump.GasPump2;

public class TestDriver {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("RUNNING USER TEST CASES");
        System.out.println("==========================================");

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
    }

    // Test #1: Activate(4.1), Start(), PayCash(5.2), StartPump(), PumpLiter(),
    // PumpLiter()
    // Expected outcome: 1 liter pumped; Receipt total: $4.1
    private static void test1() {
        System.out.println("\n--- Test #1 ---");
        GasPump1 gp1 = new GasPump1();
        gp1.Activate(4.1f);
        gp1.Start();
        gp1.PayCash(5.2f);
        gp1.StartPump();
        gp1.PumpLiter();
        gp1.PumpLiter(); // Should fail/stop
    }

    // Test #2: Activate(4.1), Start(), PayCash(5.2), Activate(7.2), StartPump(),
    // PumpLiter(), PumpLiter()
    // Expected outcome: 1 liter pumped; Receipt total: $4.1
    private static void test2() {
        System.out.println("\n--- Test #2 ---");
        GasPump1 gp1 = new GasPump1();
        gp1.Activate(4.1f);
        gp1.Start();
        gp1.PayCash(5.2f);
        gp1.Activate(7.2f); // Should be ignored
        gp1.StartPump();
        gp1.PumpLiter();
        gp1.PumpLiter();
    }

    // Test #3: Activate(4.1), Start(), PayCash(5.2), Cancel(), Start(),
    // PayCredit(), Approved(), StartPump(), PumpLiter(), PumpLiter(), StopPump()
    // Expected outcome: 2 liters pumped; Receipt total: $8.2
    private static void test3() {
        System.out.println("\n--- Test #3 ---");
        GasPump1 gp1 = new GasPump1();
        gp1.Activate(4.1f);
        gp1.Start();
        gp1.PayCash(5.2f);
        gp1.Cancel();
        gp1.Start();
        gp1.PayCredit();
        gp1.Approved();
        gp1.StartPump();
        gp1.PumpLiter();
        gp1.PumpLiter();
        gp1.StopPump();
    }

    // Test #4: Activate(4.1), Start(), PayCredit(), Approved(), PayCash(5.2),
    // StartPump(), PumpLiter(), PumpLiter(), StopPump()
    // Expected outcome: 2 liters pumped; Receipt total: $8.2
    private static void test4() {
        System.out.println("\n--- Test #4 ---");
        GasPump1 gp1 = new GasPump1();
        gp1.Activate(4.1f);
        gp1.Start();
        gp1.PayCredit();
        gp1.Approved();
        gp1.PayCash(5.2f); // Should be ignored
        gp1.StartPump();
        gp1.PumpLiter();
        gp1.PumpLiter();
        gp1.StopPump();
    }

    // Test #5: Activate(4.1), Start(), PayCredit(), Reject(), Start(), PayCash(9),
    // StartPump(), PumpLiter(), PumpLiter(), StopPump()
    // Expected outcome: 2 liters pumped; Receipt total: $8.2
    private static void test5() {
        System.out.println("\n--- Test #5 ---");
        GasPump1 gp1 = new GasPump1();
        gp1.Activate(4.1f);
        gp1.Start();
        gp1.PayCredit();
        gp1.Reject();
        gp1.Start();
        gp1.PayCash(9f);
        gp1.StartPump();
        gp1.PumpLiter();
        gp1.PumpLiter();
        gp1.StopPump();
    }

    // Test #6: Activate(4, 7), Start(), PayDebit(123), Pin(124), Pin(123),
    // Regular(), StartPump(), PumpGallon(), FullTank()
    // Expected outcome: wrong pin msg, 1 gallon pumped; Receipt total: $4
    private static void test6() {
        System.out.println("\n--- Test #6 ---");
        GasPump2 gp2 = new GasPump2();
        gp2.Activate(4, 7);
        gp2.Start();
        gp2.PayDebit(123);
        gp2.Pin(124); // Wrong
        gp2.Pin(123); // Correct
        gp2.Regular();
        gp2.StartPump();
        gp2.PumpGallon();
        gp2.FullTank();
    }

    // Test #7: Activate(4, 7), Start(), PayDebit(123), Pin(123), Regular(),
    // StartPump(), Activate(7, 3), PumpGallon(), FullTank()
    // Expected outcome: 1 gallon pumped; Receipt total: $4
    private static void test7() {
        System.out.println("\n--- Test #7 ---");
        GasPump2 gp2 = new GasPump2();
        gp2.Activate(4, 7);
        gp2.Start();
        gp2.PayDebit(123);
        gp2.Pin(123);
        gp2.Regular();
        gp2.StartPump();
        gp2.Activate(7, 3); // Should be ignored
        gp2.PumpGallon();
        gp2.FullTank();
    }

    // Test #8: Activate(4, 7), Start(), PayDebit(123), Pin(123), Regular(),
    // StartPump(), Diesel(), PumpGallon(), FullTank()
    // Expected outcome: 1 gallon pumped; Receipt total: $4
    private static void test8() {
        System.out.println("\n--- Test #8 ---");
        GasPump2 gp2 = new GasPump2();
        gp2.Activate(4, 7);
        gp2.Start();
        gp2.PayDebit(123);
        gp2.Pin(123);
        gp2.Regular();
        gp2.StartPump();
        gp2.Diesel(); // Should be ignored
        gp2.PumpGallon();
        gp2.FullTank();
    }

    // Test #9: Activate(4, 7), Start(), PayDebit(123), Pin(124), Pin(124),
    // Pin(124), Start(), PayCredit(), Approved(), Diesel(), StartPump(),
    // PumpGallon(), PumpGallon(), StopPump()
    // Expected outcome: Wrong pin msg, Too many attempts msg; 2 gallons pumped;
    // Receipt total: $14
    private static void test9() {
        System.out.println("\n--- Test #9 ---");
        GasPump2 gp2 = new GasPump2();
        gp2.Activate(4, 7);
        gp2.Start();
        gp2.PayDebit(123);
        gp2.Pin(124);
        gp2.Pin(124);
        gp2.Pin(124); // Too many attempts
        gp2.Start();
        gp2.PayCredit();
        gp2.Approved();
        gp2.Diesel();
        gp2.StartPump();
        gp2.PumpGallon();
        gp2.PumpGallon();
        gp2.StopPump();
    }

    // Test #10: Activate(4, 7), Start(), PayDebit(123), Pin(123), Regular(),
    // Diesel(), StartPump(), PumpGallon(), FullTank()
    // Expected outcome: 1 gallon pumped; Receipt total: $7
    private static void test10() {
        System.out.println("\n--- Test #10 ---");
        GasPump2 gp2 = new GasPump2();
        gp2.Activate(4, 7);
        gp2.Start();
        gp2.PayDebit(123);
        gp2.Pin(123);
        gp2.Regular();
        gp2.Diesel(); // Should switch to Diesel
        gp2.StartPump();
        gp2.PumpGallon();
        gp2.FullTank();
    }
}
