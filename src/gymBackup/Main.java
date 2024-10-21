import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GymMembership gymMembership = new GymMembership();
        gymMembership.loadMembers("src/medlemsData.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Välkommen till Best Gym Ever!");
        System.out.print("Ange personnummer eller namn: ");

        String input = scanner.nextLine();
        String status = gymMembership.checkMembershipStatus(input);
        System.out.println("Medlemsstatus: " + status);

        scanner.close();
    }
}
