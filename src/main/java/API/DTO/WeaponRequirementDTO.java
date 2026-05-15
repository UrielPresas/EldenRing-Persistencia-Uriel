package API.DTO;

public class WeaponRequirementDTO {
    private String name;
    private int amount;

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WeaponRequirementDTO{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
