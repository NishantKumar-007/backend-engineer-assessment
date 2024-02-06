package com.midas.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.midas.app.enums.ProviderType;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@JsonTypeName("account")
public class AccountDto {
  private UUID id;
  private String firstName;
  private String lastName;
  private String email;

  @DateTimeFormat(iso = ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  @DateTimeFormat(iso = ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  @Enumerated(EnumType.STRING)
  private ProviderType providerType;

  private String providerId;

  public AccountDto providerId(String providerId) {
    this.providerId = providerId;
    return this;
  }

  public AccountDto providerType(ProviderType providerType) {
    this.providerType = providerType;
    return this;
  }

  public ProviderType getProviderType() {
    return providerType;
  }

  public void setProviderType(ProviderType providerType) {
    this.providerType = providerType;
  }

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public AccountDto() {}

  public AccountDto id(UUID id) {
    this.id = id;
    return this;
  }

  @Schema(
      name = "id",
      accessMode = AccessMode.READ_ONLY,
      example = "fba5b240-0e68-4e64-aca6-f12022dc4be3",
      description = "User's ID",
      requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Valid UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public AccountDto firstName(String firstName) {
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

  public AccountDto lastName(String lastName) {
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

  public AccountDto email(String email) {
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

  public AccountDto createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Schema(
      name = "createdAt",
      accessMode = AccessMode.READ_ONLY,
      example = "2022-04-13T01:52:40.690387Z",
      description = "Prospect creation time",
      requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public @Valid OffsetDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public AccountDto updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Schema(
      name = "updatedAt",
      accessMode = AccessMode.READ_ONLY,
      example = "2022-04-13T01:52:40.690387Z",
      description = "Prospect last updated time",
      requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public @Valid OffsetDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o != null && this.getClass() == o.getClass()) {
      AccountDto account = (AccountDto) o;
      return Objects.equals(this.id, account.id)
          && Objects.equals(this.firstName, account.firstName)
          && Objects.equals(this.lastName, account.lastName)
          && Objects.equals(this.email, account.email)
          && Objects.equals(this.createdAt, account.createdAt)
          && Objects.equals(this.updatedAt, account.updatedAt);
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(
        new Object[] {
          this.id,
          this.firstName,
          this.lastName,
          this.email,
          this.createdAt,
          this.updatedAt,
          this.providerType,
          this.providerId
        });
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountDto {\n");
    sb.append("    id: ").append(this.toIndentedString(this.id)).append("\n");
    sb.append("    firstName: ").append(this.toIndentedString(this.firstName)).append("\n");
    sb.append("    lastName: ").append(this.toIndentedString(this.lastName)).append("\n");
    sb.append("    email: ").append(this.toIndentedString(this.email)).append("\n");
    sb.append("    createdAt: ").append(this.toIndentedString(this.createdAt)).append("\n");
    sb.append("    updatedAt: ").append(this.toIndentedString(this.updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
