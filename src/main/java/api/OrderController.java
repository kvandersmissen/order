package api;

import domain.dto.CreateItemDto;
import domain.dto.CreateOrderDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestHeader;
import service.OrderService;
import service.SecurityService;

import static security.Feature.ORDER_ITEMS;

@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderController {

    private final OrderService orderService;
    private final SecurityService securityService;

    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @POST
    @ResponseStatus(202)
    public Response createOrder(@RestHeader String authorization, CreateOrderDto createOrderDto){
        securityService.validateAuthorization(authorization, ORDER_ITEMS);
        return Response.status(202).entity(orderService.createOrder(createOrderDto)).build();
    }

}
