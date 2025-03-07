package za.ac.cput.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Residence {
    @Id
    private long residenceId;
    private String residenceName;
    private String genderRestriction;
    private String swapAvailable;

public Residence(ResidenceBuilder builder) {
    this.residenceId = builder.residenceId;
    this.residenceName = builder.residenceName;
    this.genderRestriction = builder.genderRestriction;
    this.swapAvailable = builder.swapAvailable;
}

    protected Residence() {}

    public long getResidenceId(){
        return residenceId;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public String getGenderRestriction() {
        return genderRestriction;
    }

    public String isSwapAvailable() {
        return swapAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Residence residence = (Residence) o;
        return residenceId == residence.residenceId && swapAvailable == residence.swapAvailable && Objects.equals(residenceName, residence.residenceName) && Objects.equals(genderRestriction, residence.genderRestriction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residenceId, residenceName, genderRestriction, swapAvailable);
    }

    @Override
    public String toString() {
        return "Residence{" +
                "residenceId=" + residenceId +
                ", residenceName='" + residenceName + '\'' +
                ", genderRestriction='" + genderRestriction + '\'' +
                ", swapAvailable=" + swapAvailable +
                '}';
    }

    public static class ResidenceBuilder{
        private long residenceId;
        private String residenceName;
        private String genderRestriction;
        private String swapAvailable;


        public ResidenceBuilder setResidenceName(String residenceName) {
            this.residenceName = residenceName;
            return this;
        }

        public ResidenceBuilder setGenderRestriction(String genderRestriction) {
            this.genderRestriction = genderRestriction;
            return this;
        }

        public ResidenceBuilder setSwapAvailable(String swapAvailable) {
            this.swapAvailable = swapAvailable;
            return this;
        }

        public ResidenceBuilder copy(Residence residence){
            this.residenceId = residence.residenceId;
            this.residenceName = residence.residenceName;
            this.genderRestriction = residence.genderRestriction;
            this.swapAvailable = residence.swapAvailable;
            return this;
        }


        public Residence build(){
            return new Residence(this);
        }
    }
}

