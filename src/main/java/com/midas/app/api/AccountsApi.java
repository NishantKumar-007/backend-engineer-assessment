package com.midas.app.api;

import com.midas.app.models.AccountDto;
import com.midas.app.models.CreateAccountDto;
import com.midas.app.models.ErrorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

@Validated
@Tag(
    name = "Accounts",
    description = "Create and manage user and attach payment providers such as 'stripe'.")
public interface AccountsApi {
  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  @Operation(
      operationId = "createUserAccount",
      summary = "Create a new user account",
      description =
          "Creates a new user account with the given details and attaches a supported payment provider such as 'stripe'.",
      tags = {"Accounts"},
      responses = {
        @ApiResponse(
            responseCode = "201",
            description = "User account created",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AccountDto.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorDto.class))
            }),
        @ApiResponse(
            responseCode = "401",
            description = "Unauthorized",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorDto.class))
            }),
        @ApiResponse(
            responseCode = "403",
            description = "Forbidden",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorDto.class))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorDto.class))
            })
      },
      security = {@SecurityRequirement(name = "bearerAuth")})
  @RequestMapping(
      method = {RequestMethod.POST},
      value = {"/accounts"},
      produces = {"application/json"},
      consumes = {"application/json"})
  default ResponseEntity<?> createUserAccount(
      @Parameter(name = "CreateAccountDto", description = "User account details", required = true)
          @RequestBody
          @Valid
          CreateAccountDto createAccountDto) {
    this.getRequest()
        .ifPresent(
            (request) -> {
              Iterator var1 = MediaType.parseMediaTypes(request.getHeader("Accept")).iterator();

              while (var1.hasNext()) {
                MediaType mediaType = (MediaType) var1.next();
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "[ { \"id\" : \"usr_fba5b240-0e68-4e64-aca6-f12022dc4be3\", \"firstName\" : \"John\", \"lastName\" : \"Doe\", \"creationAt\" : \"2022-04-13T01:52:40.690387Z\", \"updatedAt\" : \"2022-04-13T01:52:40.690387Z\" } ]";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @Operation(
      operationId = "getUserAccounts",
      summary = "Get list of user accounts",
      description = "Returns a list of user accounts.",
      tags = {"Accounts"},
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "List of user accounts",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = AccountDto.class)))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorDto.class))
            }),
        @ApiResponse(
            responseCode = "401",
            description = "Unauthorized",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorDto.class))
            }),
        @ApiResponse(
            responseCode = "403",
            description = "Forbidden",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorDto.class))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorDto.class))
            })
      },
      security = {@SecurityRequirement(name = "bearerAuth")})
  @RequestMapping(
      method = {RequestMethod.GET},
      value = {"/accounts"},
      produces = {"application/json"})
  default ResponseEntity<List<AccountDto>> getUserAccounts() {
    this.getRequest()
        .ifPresent(
            (request) -> {
              Iterator var1 = MediaType.parseMediaTypes(request.getHeader("Accept")).iterator();

              while (var1.hasNext()) {
                MediaType mediaType = (MediaType) var1.next();
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "[ [ { \"id\" : \"usr_fba5b240-0e68-4e64-aca6-f12022dc4be3\", \"firstName\" : \"John\", \"lastName\" : \"Doe\", \"creationAt\" : \"2022-04-13T01:52:40.690387Z\", \"updatedAt\" : \"2022-04-13T01:52:40.690387Z\" } ], [ { \"id\" : \"usr_fba5b240-0e68-4e64-aca6-f12022dc4be3\", \"firstName\" : \"John\", \"lastName\" : \"Doe\", \"creationAt\" : \"2022-04-13T01:52:40.690387Z\", \"updatedAt\" : \"2022-04-13T01:52:40.690387Z\" } ] ]";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
