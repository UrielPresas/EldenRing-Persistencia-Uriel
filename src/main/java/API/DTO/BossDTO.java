package API.DTO;

import java.util.List;

public class BossDTO {

    private String id;
    private String name;
    private String image;
    private String region;
    private String description;
    private String location;
    private String healthPoints;
    private List<String> drops;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getImage() { return image; }
    public String getRegion() { return region; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getHealthPoints() { return healthPoints; }
    public List<String> getDrops() { return drops; }

    @Override
    public String toString() {
        return "BossDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", region='" + region + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", healthPoints='" + healthPoints + '\'' +
                ", drops=" + drops +
                '}';
    }
}
