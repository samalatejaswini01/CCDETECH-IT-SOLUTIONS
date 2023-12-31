import java.util.Scanner;

public class AtmInterface {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] u = { 191, 192, 193, 194, 195 };
        int[] p = { 6358, 6458, 6558, 6658, 6758 };
        int[] b = { 80000, 900000, 145000, 1506000, 320500 };
        int attempt = 1, m = 0, n = 0, withdraw, deposit;
        try {
            System.out.println("Enter your user ID:");
            int userid = sc.nextInt();
            for (int i = 0; i < 5; i++) {
                if (userid != u[i]) {
                    attempt++;
                } else {
                    n = i;
                    attempt = 1;
                    break;
                }
            }
            if (attempt > 1) {
                System.out.println("Invalid User ID");
                return;
            }
            System.out.println("Welcome " + userid + " for ATM services.");
            System.out.println("Enter your PIN:");
            int pwd = sc.nextInt();
            if (pwd != p[n]) {
                while (true) {
                    System.out.println("Entered PIN is incorrect.");
                    attempt++;
                    System.out.println("Re-enter your pin: ");
                    pwd = sc.nextInt();
                    if (pwd == p[n]) {
                        break;
                    }
                    if (attempt >= 3) {
                        System.out.println("You've exceeded the limit. Please try again after some time.");
                        return;
                    }
                }
            }
            System.out.println();
            System.out.println("Choose your task.");
            System.out.println("1. Balance enquiry");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transaction");
            System.out.println("5. quit");
            System.out.println();
            System.out.println("Enter your option :");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Transaction History");
                    System.out.println("Your current balance is:" + b[n]);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    withdraw = sc.nextInt();
                    if (withdraw > b[n] || b[n] == 0) {
                        System.out.println("Insufficient funds.");
                        System.out.println();
                        break;
                    }
                    System.out.println("Withdraw processed.");
                    b[n] = b[n] - withdraw;
                    System.out.println("Your current balance is:" + b[n]);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    deposit = sc.nextInt();
                    b[n] = b[n] + deposit;
                    System.out.println("Your amount is deposited successfully.");
                    System.out.println("Your current balance is:" + b[n]);
                    break;
                case 4:
                    System.out.println("Enter the user ID to which you want to transfer the amount");
                    int uid = sc.nextInt();
                    for (int i = 0; i < 5; i++) {
                        if (uid != u[i]) {
                            attempt++;
                        } else {
                            m = i;
                            attempt = 1;
                            break;
                        }
                    }
                    if (attempt > 1) {
                        System.out.println("Invalid User ID");
                        return;
                    }
                    System.out.println("Enter the amount that you would like to transfer");
                    int am = sc.nextInt();
                    b[n] = b[n] - am;
                    b[m] = b[m] + am;
                    System.out.println("Your current balance after transaction is:" + b[n]);
                    break;
                case 5:
                    System.out.println("ThankYou for utilising ATM services.");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid Option. Try again!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
