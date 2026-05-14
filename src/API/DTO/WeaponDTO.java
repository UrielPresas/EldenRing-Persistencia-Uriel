package API.DTO;

import java.util.List;

public class WeaponDTO {

    private String id;
    private String name;
    private String image;
    private String description;
    private String category;
    private double weight;

    private List<WeaponStatDTO> attack;
    private List<WeaponStatDTO> defence;
    private List<WeaponScalingDTO> scalesWith;
    private List<WeaponRequirementDTO> requiredAttributes;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
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

    public List<WeaponStatDTO> getAttack() {
        return attack;
    }

    public List<WeaponStatDTO> getDefence() {
        return defence;
    }

    public List<WeaponScalingDTO> getScalesWith() {
        return scalesWith;
    }

    public List<WeaponRequirementDTO> getRequiredAttributes() {
        return requiredAttributes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
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

    public void setAttack(List<WeaponStatDTO> attack) {
        this.attack = attack;
    }

    public void setDefence(List<WeaponStatDTO> defence) {
        this.defence = defence;
    }

    public void setScalesWith(List<WeaponScalingDTO> scalesWith) {
        this.scalesWith = scalesWith;
    }

    public void setRequiredAttributes(List<WeaponRequirementDTO> requiredAttributes) {
        this.requiredAttributes = requiredAttributes;
    }

    @Override
    public String toString() {
        return "WeaponDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                ", attack=" + attack +
                ", defence=" + defence +
                ", scalesWith=" + scalesWith +
                ", requiredAttributes=" + requiredAttributes +
                '}';
    }
}
