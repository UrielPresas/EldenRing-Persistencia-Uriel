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
}
