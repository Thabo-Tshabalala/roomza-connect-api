package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.model.GenderRestriction;
import za.ac.cput.model.Residence;

import static org.junit.jupiter.api.Assertions.*;

class ResidenceFactoryTest {

    private Residence residence;

    @Test
    void buildResidence() {
        residence = ResidenceFactory.createResidence("New Market Junction", GenderRestriction.ANY);
        assertNotNull(residence);
    }

    @Test
    void buildResidenceWithNullResidenceName() {
        residence = ResidenceFactory.createResidence("", GenderRestriction.MALE_ONLY);
        assertNull(residence);
    }
}