package Model;

import java.sql.Timestamp;
import java.util.List;

public class Weapon {
    private String id_weapon;
    private String name;
    private String img;
    private String description;
    private String category;
    private double weight;
    private Timestamp last_update;

    private List<WeaponAttack> attacks;
    private List<WeaponDefence> defences;
    private List<WeaponScaling> scalings;
    private List<WeaponRequirement> requirements;


    public String getId_weapon() {
        return id_weapon;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getWeight() {
        return weight;
    }

    public void setId_weapon(String id_weapon) {
        this.id_weapon = id_weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id_weapon='" + id_weapon + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                '}';
    }
}
