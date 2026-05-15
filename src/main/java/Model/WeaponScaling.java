package Model;

public class WeaponScaling {
    private int id_scaling;
    private String weapon_id;
    private String attribute;
    private String scaling;

    public int getId_scaling() {
        return id_scaling;
    }

    public String getWeapon_id() {
        return weapon_id;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getScaling() {
        return scaling;
    }

    public void setId_scaling(int id_scaling) {
        this.id_scaling = id_scaling;
    }

    public void setWeapon_id(String weapon_id) {
        this.weapon_id = weapon_id;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setScaling(String scaling) {
        this.scaling = scaling;
    }

    @Override
    public String toString() {
        return "WeaponScaling{" +
                "id_scaling=" + id_scaling +
                ", weapon_id='" + weapon_id + '\'' +
                ", attribute='" + attribute + '\'' +
                ", scaling='" + scaling + '\'' +
                '}';
    }
}
