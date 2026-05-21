package API.DTO;

import Model.*;

import java.util.List;

public class WeaponDetailDTO {

    private Weapon weapon;

    private List<WeaponAttack> attacks;
    private List<WeaponDefence> defences;
    private List<WeaponScaling> scalings;
    private List<WeaponRequirement> requirements;

    public Weapon getWeapon() {
        return weapon;
    }

    public List<WeaponAttack> getAttacks() {
        return attacks;
    }

    public List<WeaponDefence> getDefences() {
        return defences;
    }

    public List<WeaponScaling> getScalings() {
        return scalings;
    }

    public List<WeaponRequirement> getRequirements() {
        return requirements;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setAttacks(List<WeaponAttack> attacks) {
        this.attacks = attacks;
    }

    public void setDefences(List<WeaponDefence> defences) {
        this.defences = defences;
    }

    public void setScalings(List<WeaponScaling> scalings) {
        this.scalings = scalings;
    }

    public void setRequirements(List<WeaponRequirement> requirements) {
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        return "WeaponDetailDTO{" +
                "weapon=" + weapon +
                ", attacks=" + attacks +
                ", defences=" + defences +
                ", scalings=" + scalings +
                ", requirements=" + requirements +
                '}';
    }
}
