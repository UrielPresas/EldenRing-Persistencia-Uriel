package Model;

public class WeaponRequirement {
    private int id_requirement;
    private String weapon_id;
    private String attribute;
    private int amount;

    public int getId_requirement() {
        return id_requirement;
    }

    public String getWeapon_id() {
        return weapon_id;
    }

    public String getAttribute() {
        return attribute;
    }

    public int getAmount() {
        return amount;
    }

    public void setId_requirement(int id_requirement) {
        this.id_requirement = id_requirement;
    }

    public void setWeapon_id(String weapon_id) {
        this.weapon_id = weapon_id;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WeaponRequirement{" +
                "id_requirement=" + id_requirement +
                ", weapon_id='" + weapon_id + '\'' +
                ", attribute='" + attribute + '\'' +
                ", amount=" + amount +
                '}';
    }
}
