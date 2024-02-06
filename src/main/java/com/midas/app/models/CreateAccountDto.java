package com.midas.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.Objects;

@JsonTypeName("createAccount")
public class CreateAccountDto {
  private String firstName;
  private String lastName;
  private String email;

  public CreateAccountDto() {}

  public CreateAccountDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  @Schema(
      name = "firstName",
      example = "John",
      description = "User's first name",
      requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CreateAccountDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  @Schema(
      name = "lastName",
      example = "Doe",
      description = "User's last name",
      requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CreateAccountDto email(String email) {
    this.email = email;
    return this;
  }

  @Schema(
      name = "email",
      example = "john@doe.com",
      description = "Email of user",
      requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o != null && this.getClass() == o.getClass()) {
      CreateAccountDto createAccount = (CreateAccountDto) o;
      return Objects.equals(this.firstName, createAccount.firstName)
          && Objects.equals(this.lastName, createAccount.lastName)
          && Objects.equals(this.email, createAccount.email);
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(new Object[] {this.firstName, this.lastName, this.email});
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAccountDto {\n");
    sb.append("    firstName: ").append(this.toIndentedString(this.firstName)).append("\n");
    sb.append("    lastName: ").append(this.toIndentedString(this.lastName)).append("\n");
    sb.append("    email: ").append(this.toIndentedString(this.email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
