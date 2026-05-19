package API.DTO;

import java.util.List;

public class BossResponse {
    private boolean success;
    private int count;
    private int total;
    private List<BossDTO> data;

    public boolean isSuccess() {
        return success;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public List<BossDTO> getData() {
        return data;
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

    public void setData(List<BossDTO> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BossResponse{" +
                "success=" + success +
                ", count=" + count +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
