package API.DTO;

public class AshOfWarDTO {
    private String id;
    private String name;
    private String image;
    private String description;
    private String affinity;
    private String skill;

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

    public String getAffinity() {
        return affinity;
    }

    public String getSkill() {
        return skill;
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

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "AshOfWarDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", affinity='" + affinity + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
