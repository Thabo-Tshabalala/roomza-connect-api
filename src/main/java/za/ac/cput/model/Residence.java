package za.ac.cput.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;
@Entity
public class Residence {
    @Id
    private long residenceId;
    private String residenceName;
    @Enumerated(EnumType.STRING)
    private GenderRestriction genderRestriction;

public Residence(ResidenceBuilder builder) {
    this.residenceId = builder.residenceId;
    this.residenceName = builder.residenceName;
    this.genderRestriction = builder.genderRestriction;
}

    protected Residence() {}

    public long getResidenceId(){
        return residenceId;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public GenderRestriction getGenderRestriction() {
        return genderRestriction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Residence residence = (Residence) o;
        return residenceId == residence.residenceId && Objects.equals(residenceName, residence.residenceName) && genderRestriction == residence.genderRestriction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(residenceId, residenceName, genderRestriction);
    }

    @Override
    public String toString() {
        return "Residence{" +
                "residenceId=" + residenceId +
                ", residenceName='" + residenceName + '\'' +
                ", genderRestriction=" + genderRestriction + '\'' +
                '}';
    }

    public static class ResidenceBuilder{
        private long residenceId;
        private String residenceName;
        private GenderRestriction genderRestriction;

        public ResidenceBuilder setResidenceName(String residenceName) {
            this.residenceName = residenceName;
            return this;
        }

        public ResidenceBuilder setGenderRestriction(GenderRestriction genderRestriction) {
            this.genderRestriction = genderRestriction;
            return this;
        }

        public ResidenceBuilder copy(Residence residence){
            this.residenceId = residence.residenceId;
            this.residenceName = residence.residenceName;
            this.genderRestriction = residence.genderRestriction;
            return this;
        }


        public Residence build(){
            return new Residence(this);
        }
    }
}

