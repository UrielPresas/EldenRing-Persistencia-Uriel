package Model;

public class WeaponAttack {
    private int id_attack;
    private String weapon_id;
    private String type;
    private int amount;

    public int getId_attack() {
        return id_attack;
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

    public void setId_attack(int id_attack) {
        this.id_attack = id_attack;
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
        return "WeaponAttack{" +
                "id_attack=" + id_attack +
                ", weapon_id='" + weapon_id + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
