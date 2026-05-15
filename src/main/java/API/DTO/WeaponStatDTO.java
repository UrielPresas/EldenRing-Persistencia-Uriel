package API.DTO;

public class WeaponStatDTO {
    private String name;
    private int amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WeaponStatDTO{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
