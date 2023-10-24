package domain.order;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<String, ItemGroup> orderById;

    public Order() {
        this.orderById = new HashMap<>();
    }

}
