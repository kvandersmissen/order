package repository;

import domain.customer.Customer;
import domain.item.Item;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class ItemRepository {

    private final Map<String, Item> itemById;

    public ItemRepository() {
        this.itemById = new HashMap<>();
    }

    public Item createItem(Item item){

        itemById.put(item.getId(),item);
        return item;
    }

    public Collection<Item> getAllItems(){
        return itemById.values();
    }

    public Optional<Item> getItemById(String id){
        return Optional.ofNullable(itemById.get(id));
    }

}
