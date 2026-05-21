package API.DTO;

import Model.Boss;
import Model.BossDrop;

import java.util.List;

public class BossDetailDTO {

    private Boss boss;

    private List<BossDrop> drops;

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public List<BossDrop> getDrops() {
        return drops;
    }

    public void setDrops(List<BossDrop> drops) {
        this.drops = drops;
    }
}
