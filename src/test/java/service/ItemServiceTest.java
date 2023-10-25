package service;

import domain.dto.CreateItemDto;
import domain.dto.ItemDto;
import domain.item.Item;
import mapper.ItemMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ItemRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ItemServiceTest {

    private ItemRepository itemRepositoryMock;
    private ItemMapper itemMapperMock;

    private ItemService itemService;



    @BeforeEach
    void setup(){
        itemRepositoryMock = mock(ItemRepository.class);
        itemMapperMock = mock(ItemMapper.class);
        itemService = new ItemService(itemRepositoryMock, itemMapperMock);
    }
    @Test
    void createItem() {

        CreateItemDto createItemDto = TestConstants.createItemDto;

        Item newItem = new Item(createItemDto.getName(), createItemDto.getDescription(), createItemDto.getPrice(), createItemDto.getAmount());

        ItemDto newItemDto = new ItemDto(newItem.getId(), newItem.getName(), newItem.getDescription(), newItem.getPrice(), createItemDto.getAmount());

        when(itemMapperMock.mapToEntity(createItemDto)).thenReturn(newItem);
        when(itemRepositoryMock.createItem(newItem)).thenReturn(newItem);
        when(itemMapperMock.entityToDto(newItem)).thenReturn(newItemDto);

        ItemDto result = itemService.createItem(createItemDto);

        assertEquals(newItemDto, result);

    }

    @Test
    void getAllItems() {

//        List<Item> allItems =

    }

    @Test
    void updateItem() {
    }
}