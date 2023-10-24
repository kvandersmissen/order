package service;

import domain.customer.Customer;
import exceptions.UnauthorizatedException;
import exceptions.WrongPasswordException;
import jakarta.annotation.Nullable;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;
import repository.CustomerRepository;
import security.DecodedCredentials;
import security.Feature;

import java.util.Base64;
import java.util.Optional;

import static java.lang.String.format;

@ApplicationScoped
public class SecurityService {

    private final Logger logger = Logger.getLogger(SecurityService.class);

    private final CustomerRepository customerRepository;

    public SecurityService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void validateAuthorization(@Nullable String authorization, Feature feature) {
        DecodedCredentials credentials = getEmailPassword(Optional.ofNullable(authorization)
                .orElseThrow(() -> new UnauthorizatedException("You do not have authorization")));
        Customer customer = customerRepository.getCustomerByEmail(credentials.getEmail())
                .orElseThrow(() -> new UnauthorizatedException("Unknown user " + credentials.getEmail()));

        if (!customer.doesPasswordMatch(credentials.getPassword())) {
            logger.errorf("Password does not match for user %s", credentials.getEmail());
            throw new WrongPasswordException("Password does not match for user " + credentials.getEmail());
        }

        if (!customer.canHaveAccessTo(feature)) {
            logger.error(format("Customer %s does not have access to %s", credentials.getEmail(), feature));
            throw new UnauthorizatedException("Customer " + credentials.getEmail() + " does not have access to " + feature.toString());
        }

    }

    private DecodedCredentials getEmailPassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String email = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new DecodedCredentials(email, password);
    }
}
