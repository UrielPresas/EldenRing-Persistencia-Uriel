package API.DTO;

import java.util.List;

public class WeaponResponse {
    private boolean success;
    private int count;
    private int total;
    private List<WeaponDTO> data;

    public List<WeaponDTO> getData() {
        return data;
    }
}
