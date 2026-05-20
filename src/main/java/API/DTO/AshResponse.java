package API.DTO;

import java.util.List;

public class AshResponse {

    private boolean success;
    private int count;
    private int total;

    private List<AshOfWarDTO> data;

    public List<AshOfWarDTO> getData() {
        return data;
    }
}
