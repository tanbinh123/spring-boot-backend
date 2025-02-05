package org.trebol.jpa.services.crud;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.trebol.exceptions.BadInputException;
import org.trebol.jpa.entities.Customer;
import org.trebol.jpa.entities.Person;
import org.trebol.jpa.repositories.ICustomersJpaRepository;
import org.trebol.jpa.services.ITwoWayConverterJpaService;
import org.trebol.pojo.CustomerPojo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.trebol.testhelpers.CustomersTestHelper.*;

@ExtendWith(MockitoExtension.class)
class CustomersJpaCrudServiceTest {

  @Mock ICustomersJpaRepository customersRepositoryMock;
  @Mock ITwoWayConverterJpaService<CustomerPojo, Customer> billingTypesConverterMock;

  @Test
  void sanity_check() {
    CustomersJpaCrudServiceImpl service = instantiate();
    assertNotNull(service);
  }

  @Test
  void finds_by_id_number() throws BadInputException {
    resetCustomers();
    when(customersRepositoryMock.findByPersonIdNumber(customerPojoForFetch().getPerson().getIdNumber())).thenReturn(Optional.of(customerEntityAfterCreation()));
    CustomersJpaCrudServiceImpl service = instantiate();

    Optional<Customer> match = service.getExisting(customerPojoForFetch());

    assertTrue(match.isPresent());
    Person person = match.get().getPerson();
    assertEquals(person.getIdNumber(), customerEntityAfterCreation().getPerson().getIdNumber());
    assertEquals(person.getFirstName(), customerEntityAfterCreation().getPerson().getFirstName());
    assertEquals(person.getLastName(), customerEntityAfterCreation().getPerson().getLastName());
  }

  private CustomersJpaCrudServiceImpl instantiate() {
    return new CustomersJpaCrudServiceImpl(
        customersRepositoryMock,
        billingTypesConverterMock
    );
  }

}
