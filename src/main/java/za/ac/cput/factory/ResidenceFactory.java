package za.ac.cput.factory;

import za.ac.cput.model.Residence;
import za.ac.cput.util.Helper;

import java.util.Optional;

public class ResidenceFactory {

    public static Optional<Residence> createResidence(String residenceName, String genderRestriction, String isSwapAvailable) {
        if(Helper.isNullOrEmpty(residenceName) || Helper.isNullOrEmpty(genderRestriction) || Helper.isNullOrEmpty(isSwapAvailable)) {
            return Optional.empty();
        }
        return Optional.of(new Residence.ResidenceBuilder().setResidenceName(residenceName).setGenderRestriction(genderRestriction).setSwapAvailable(isSwapAvailable).build());
    }
}
