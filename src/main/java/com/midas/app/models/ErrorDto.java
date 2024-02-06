package com.midas.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

@Schema(name = "error", description = "Error response object")
@JsonTypeName("error")
public class ErrorDto {
  private String code;
  private String title;
  private String type;
  private String message;

  public ErrorDto() {}

  public ErrorDto(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public ErrorDto code(String code) {
    this.code = code;
    return this;
  }

  @Schema(name = "code", requiredMode = RequiredMode.REQUIRED)
  @JsonProperty("code")
  public @NotNull String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorDto title(String title) {
    this.title = title;
    return this;
  }

  @Schema(name = "title", requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ErrorDto type(String type) {
    this.type = type;
    return this;
  }

  @Schema(name = "type", requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ErrorDto message(String message) {
    this.message = message;
    return this;
  }

  @Schema(name = "message", requiredMode = RequiredMode.REQUIRED)
  @JsonProperty("message")
  public @NotNull String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o != null && this.getClass() == o.getClass()) {
      ErrorDto error = (ErrorDto) o;
      return Objects.equals(this.code, error.code)
          && Objects.equals(this.title, error.title)
          && Objects.equals(this.type, error.type)
          && Objects.equals(this.message, error.message);
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(new Object[] {this.code, this.title, this.type, this.message});
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDto {\n");
    sb.append("    code: ").append(this.toIndentedString(this.code)).append("\n");
    sb.append("    title: ").append(this.toIndentedString(this.title)).append("\n");
    sb.append("    type: ").append(this.toIndentedString(this.type)).append("\n");
    sb.append("    message: ").append(this.toIndentedString(this.message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
