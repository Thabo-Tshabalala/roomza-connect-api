package za.ac.cput.Model;

import java.util.Objects;

public class Residence {

    private long residenceId;
    private String residenceName;
    private String genderRestriction;
    private boolean swapAvailable;

public Residence(Builder builder) {
    this.residenceId = builder.residenceId;
    this.residenceName = builder.residenceName;
    this.genderRestriction = builder.genderRestriction;
    this.swapAvailable = builder.swapAvailable;
}

    public long getResidenceId(){
        return residenceId;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public String getGenderRestriction() {
        return genderRestriction;
    }

    public boolean isSwapAvailable() {
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

    public static class Builder{
        private long residenceId;
        private String residenceName;
        private String genderRestriction;
        private boolean swapAvailable;


        public void setResidenceName(String residenceName) {
            this.residenceName = residenceName;
        }

        public void setGenderRestriction(String genderRestriction) {
            this.genderRestriction = genderRestriction;
        }

        public void setSwapAvailable(boolean swapAvailable) {
            this.swapAvailable = swapAvailable;
        }

        public Builder copy(Residence residence){
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

