package service;

import domain.dto.CreateItemDto;
import domain.dto.ItemDto;
import domain.dto.UpdateItemDto;
import domain.item.Item;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import mapper.ItemMapper;
import repository.ItemRepository;

import java.util.List;

@ApplicationScoped
public class ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto createItem(CreateItemDto createItemDto){
        Item item = itemRepository.createItem(itemMapper.mapToEntity(createItemDto));
        return itemMapper.entityToDto(itemRepository.createItem(item));
    }

    public List<ItemDto> getAllItems(){
        return itemMapper.mapToDto(itemRepository.getAllItems().stream().toList());
    }

    public ItemDto updateItem(String id, UpdateItemDto updateItemDto){
        Item itemToUpdate = itemRepository.getItemById(id).orElseThrow(() -> new NotFoundException("No item found for " + id));

        Item itemUpdated =  itemToUpdate.changeName(updateItemDto.getName())
                .changeDescription(updateItemDto.getDescription())
                .changePrice(updateItemDto.getPrice())
                .changeAmount(updateItemDto.getAmount());

        return itemMapper.entityToDto(itemUpdated);

    }


}
