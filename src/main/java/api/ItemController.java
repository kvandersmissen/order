package api;

import domain.dto.CreateCustomerDto;
import domain.dto.CreateItemDto;
import domain.dto.UpdateItemDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestHeader;
import security.Feature;
import service.ItemService;
import service.SecurityService;

import static security.Feature.MANAGE_ITEMS;

@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemController {

    private final ItemService itemService;
    private final SecurityService securityService;

    public ItemController(SecurityService securityService, ItemService itemService) {
        this.securityService = securityService;
        this.itemService = itemService;
    }
    @GET
    @ResponseStatus(200)
    public Response getAllItems(){
        return Response.status(200).entity(itemService.getAllItems()).build();
    }

    @POST
    @ResponseStatus(201)
    public Response createItem(@RestHeader String authorization, CreateItemDto createItemDto){
        securityService.validateAuthorization(authorization, MANAGE_ITEMS);
        return Response.status(201).entity(itemService.createItem(createItemDto)).build();
    }

    @PUT
    @ResponseStatus(202)
    @Path("/{id}")
    public Response updateItem(@RestHeader String authorization, @PathParam("id") String id, UpdateItemDto updateItemDto){
        securityService.validateAuthorization(authorization,MANAGE_ITEMS);
        return Response.status(202).entity(itemService.updateItem(id,updateItemDto)).build();
    }

}
