package security;

import java.util.List;

import static java.util.Arrays.asList;
import static security.Feature.*;

public enum UserRole {
    ADMIN(asList(MANAGE_ITEMS, VIEW_CUSTOMERS, SINGLE_CUSTOMER)),
    CUSTOMER(asList(ORDER_ITEMS));

    private final List<Feature> featureList;

    UserRole(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public boolean containsFeature(Feature feature) {
        return featureList.contains(feature);
    }

}
