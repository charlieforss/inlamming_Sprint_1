import java.nio.file.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class GymMembership {
    private List<Member> members = new ArrayList<>();

    // Ladda medlemmar från en fil
    public void loadMembers(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/medlemsData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length != 2) continue;

                String id = parts[0];
                String name = parts[1];
                String lastPaidDateStr = reader.readLine();
                LocalDate lastPaidDate = LocalDate.parse(lastPaidDateStr);

                members.add(new Member(id, name, lastPaidDate));
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Implement proper error handling
        }
    }

    // Kontrollera medlemsstatus
    public String checkMembershipStatus(String input) {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);

        for (Member member : members) {
            if (member.getId().equals(input) || member.getName().equalsIgnoreCase(input)) {
                if (member.getLastPaidDate().isAfter(oneYearAgo)) {
                    saveTrainingSession(member);
                    return "Nuvarande medlem";
                } else {
                    return "Före detta kund";
                }
            }
        }
        return "Obehörig";
    }

    // Spara träningssession
    private void saveTrainingSession(Member member) {
        String logPath = "src/trainingSessions.txt"; // Define log path
        LocalDate today = LocalDate.now();
        String logEntry = member.getId() + ", " + member.getName() + ", " + today;

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(logPath), StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            // error hantering
        }
    }
}
