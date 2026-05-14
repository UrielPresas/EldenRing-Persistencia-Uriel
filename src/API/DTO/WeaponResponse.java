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

    public boolean isSuccess() {
        return success;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setData(List<WeaponDTO> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeaponResponse{" +
                "success=" + success +
                ", count=" + count +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
