package za.ac.cput.factory;

import za.ac.cput.model.GenderRestriction;
import za.ac.cput.model.Residence;
import za.ac.cput.util.Helper;

import java.util.Optional;

public class ResidenceFactory {

    public static Residence createResidence(String residenceName, GenderRestriction  genderRestriction, String isSwapAvailable) {
        if(Helper.isNullOrEmpty(residenceName) || Helper.isNullOrEmpty(String.valueOf(genderRestriction)) || Helper.isNullOrEmpty(isSwapAvailable)) {
            return null;
        }
        return new Residence.ResidenceBuilder().setResidenceName(residenceName).setGenderRestriction(GenderRestriction.valueOf(String.valueOf(genderRestriction))).build();
    }
}
