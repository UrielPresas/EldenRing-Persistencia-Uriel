package Model;

public class WeaponDefence {
    private int id_defence;
    private String weapon_id;
    private String type;
    private int amount;

    public int getId_defence() {
        return id_defence;
    }

    public String getWeapon_id() {
        return weapon_id;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public void setId_defence(int id_defence) {
        this.id_defence = id_defence;
    }

    public void setWeapon_id(String weapon_id) {
        this.weapon_id = weapon_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WeaponDefence{" +
                "id_defence=" + id_defence +
                ", weapon_id='" + weapon_id + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
