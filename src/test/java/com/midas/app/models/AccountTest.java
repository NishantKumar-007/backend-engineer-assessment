import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.midas.app.enums.ProviderType;
import com.midas.app.models.Account;
import org.junit.jupiter.api.Test;

public class AccountTest {

  @Test
  public void testAccountCreation() {
    // Given
    String firstName = "John";
    String lastName = "Doe";
    String email = "john.doe@example.com";
    ProviderType providerType = ProviderType.STRIPE;

    // When
    Account account =
        Account.builder()
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .providerType(providerType)
            .build();

    // Then
    assertAll(
        () -> assertThat(account.getId()).isNull(),
        () -> assertThat(account.getFirstName()).isEqualTo(firstName),
        () -> assertThat(account.getLastName()).isEqualTo(lastName),
        () -> assertThat(account.getEmail()).isEqualTo(email),
        () -> assertThat(account.getProviderType()).isEqualTo(providerType),
        () -> assertThat(account.getProviderId()).isNull(),
        () -> assertThat(account.getCreatedAt()).isNull(),
        () -> assertThat(account.getUpdatedAt()).isNull());
  }
}
