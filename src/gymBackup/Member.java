import java.time.LocalDate;

public class Member {
    private String id;
    private String name;
    private LocalDate lastPaidDate;

    public Member(String id, String name, LocalDate lastPaidDate) {
        this.id = id;
        this.name = name;
        this.lastPaidDate = lastPaidDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastPaidDate() {
        return lastPaidDate;
    }
}
