package API.DTO;

public class WeaponScalingDTO {
    private String name;
    private String scaling;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScaling() {
        return scaling;
    }

    public void setScaling(String scaling) {
        this.scaling = scaling;
    }

    @Override
    public String toString() {
        return "WeaponScalingDTO{" +
                "name='" + name + '\'' +
                ", scaling='" + scaling + '\'' +
                '}';
    }
}
