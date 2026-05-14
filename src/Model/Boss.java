package Model;

import java.util.List;

public class Boss {
    private String id_boss;
    private String name;
    private String img;
    private String region;
    private String description;
    private String location;
    private String health_points;

    private List<BossDrop> drops;

    public String getId_boss() {
        return id_boss;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getRegion() {
        return region;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getHealth_points() {
        return health_points;
    }

    public void setId_boss(String id_boss) {
        this.id_boss = id_boss;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHealth_points(String health_points) {
        this.health_points = health_points;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "id_boss='" + id_boss + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", region='" + region + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", health_points='" + health_points + '\'' +
                '}';
    }
}
