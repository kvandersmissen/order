package api;

import domain.dto.CreateCustomerDto;
import domain.dto.CustomerDto;
import domain.dto.UpdateItemDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestHeader;
import service.CustomerService;
import service.SecurityService;

import java.util.List;

import static security.Feature.*;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {
    //private static final Logger LOG = Logger.getLogger(SecurityService.class);
    private final CustomerService customerService;
    private SecurityService securityService;

    public CustomerController(CustomerService customerService, SecurityService securityService) {
        this.customerService = customerService;
        this.securityService = securityService;
    }

    @POST
    @ResponseStatus(201)
    public Response createCustomer(CreateCustomerDto createCustomerDto){
        return Response.status(201).entity(customerService.createCustomer(createCustomerDto)).build();
    }

    @GET
    @ResponseStatus(200)
    public Response getCustomers(@RestHeader String authorization){
        //LOG.error("Auto %s" + authorization);
        securityService.validateAuthorization(authorization, VIEW_CUSTOMERS);
        return Response.status(200).entity(customerService.getCustomers()).build();
    }

    @GET
    @ResponseStatus(200)
    @Path("/{id}")
    public Response getCustomerById(@RestHeader String authorization, @PathParam("id") String id){
        securityService.validateAuthorization(authorization, SINGLE_CUSTOMER);
        return Response.status(200).entity(customerService.getCustomerByid(id)).build();
    }


}
