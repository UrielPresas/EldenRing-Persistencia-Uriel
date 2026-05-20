package Model;

public class AshOfWar {
    private String id_ash;
    private String name;
    private String img;
    private String description;
    private String affinity;
    private String skill;

    public String getId_ash() {
        return id_ash;
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

    public String getAffinity() {
        return affinity;
    }

    public String getSkill() {
        return skill;
    }

    public void setId_ash(String id_ash) {
        this.id_ash = id_ash;
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

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "AshOfWar{" +
                "id_ash='" + id_ash + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", affinity='" + affinity + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
