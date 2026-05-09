package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * The part played by a party in a given context. Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> engagedParty, name, roleType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-669: Party Role Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = PartyRoleCreate.class
)
@Required(fields = {"name", "roleType", "engagedParty"})
public class PartyRoleCreate extends CustomerBase {

  /**
   * List of: Account reference. An account may be a party account or a financial
   * account.
   */
  @JsonProperty("account")
  private List<@Valid AccountRef> accounts;

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Party reference. A party ref defines the real world party (organization or
   * individual) linked to a specific entity (such as a customer or a party role
   * entity).
   */
  private @Valid PartyRef engagedParty;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * List of: PaymentMethod reference. A payment method defines a specific mean of
   * payment (e.g. direct debit).
   */
  @JsonProperty("paymentMethod")
  private List<@Valid PaymentMethodRef> paymentMethods;

  /**
   * Role type reference. A RoleType represents the type of a PartyRole, defined
   * in the context of a given type of partnership, such as Buyer, Seller.
   */
  private @Valid RoleTypeRef roleType;
}