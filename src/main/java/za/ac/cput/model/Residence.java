package za.ac.cput.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Entity
public class Residence implements Serializable {
    @Id
    private long residenceId;
    private String residenceName;
    @Enumerated(EnumType.STRING)
    private GenderRestriction genderRestriction;
    @OneToMany(mappedBy = "residence",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> room;

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
        return residenceId == residence.residenceId && Objects.equals(residenceName, residence.residenceName) && genderRestriction == residence.genderRestriction && Objects.equals(room, residence.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residenceId, residenceName, genderRestriction, room);
    }

    @Override
    public String toString() {
        return "Residence{" +
                "residenceId=" + residenceId +
                ", residenceName='" + residenceName + '\'' +
                ", genderRestriction=" + genderRestriction +
                ", room=" + room +
                '}';
    }

    public static class ResidenceBuilder{
        private long residenceId;
        private String residenceName;
        private GenderRestriction genderRestriction;
        private List<Room> room;

        public ResidenceBuilder setResidenceName(String residenceName) {
            this.residenceName = residenceName;
            return this;
        }

        public ResidenceBuilder setGenderRestriction(GenderRestriction genderRestriction) {
            this.genderRestriction = genderRestriction;
            return this;
        }

        public ResidenceBuilder setRoom(List<Room> room) {
            this.room = room;
            return this;
        }

        public ResidenceBuilder copy(Residence residence){
            this.residenceId = residence.residenceId;
            this.residenceName = residence.residenceName;
            this.genderRestriction = residence.genderRestriction;
            this.room = residence.room;
            return this;
        }


        public Residence build(){
            return new Residence(this);
        }
    }
}

