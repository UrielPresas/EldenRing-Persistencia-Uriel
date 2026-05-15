package Model;

public class BossDrop {
    private int id_drop;
    private String boss_id;
    private String drop_name;

    public int getId_drop() {
        return id_drop;
    }

    public String getBoss_id() {
        return boss_id;
    }

    public String getDrop_name() {
        return drop_name;
    }

    public void setId_drop(int id_drop) {
        this.id_drop = id_drop;
    }

    public void setBoss_id(String boss_id) {
        this.boss_id = boss_id;
    }

    public void setDrop_name(String drop_name) {
        this.drop_name = drop_name;
    }

    @Override
    public String toString() {
        return "BossDrop{" +
                "id_drop=" + id_drop +
                ", boss_id='" + boss_id + '\'' +
                ", drop_name='" + drop_name + '\'' +
                '}';
    }
}
