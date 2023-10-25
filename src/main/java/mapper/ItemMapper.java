package mapper;

import domain.dto.CreateItemDto;
import domain.dto.ItemDto;
import domain.item.Item;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ItemMapper {
    public List<ItemDto> mapToDto(List<Item> items) {
        return items.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Item mapToEntity(CreateItemDto createItemDto) {
        return new Item(createItemDto.getName(),
                createItemDto.getDescription(),
                createItemDto.getPrice(),
                createItemDto.getAmount());
    }

    public ItemDto entityToDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getAmount());
    }

}
