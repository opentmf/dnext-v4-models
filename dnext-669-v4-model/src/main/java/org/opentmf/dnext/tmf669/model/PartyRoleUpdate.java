package org.opentmf.dnext.tmf669.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.AgreementRef;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.CustomerUpdateBase;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.PartyRef;
import org.opentmf.dnext.common.model.RoleTypeRef;

/**
 * The part played by a party in a given context. Skipped properties: id,href.
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
    defaultImpl = PartyRoleUpdate.class
)
public class PartyRoleUpdate extends CustomerUpdateBase {

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Party reference.
   */
  private @Valid PartyRef engagedParty;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Role type reference. A RoleType represents the type of a PartyRole, defined
   * in the context of a given type of partnership, such as Buyer, Seller.
   */
  private @Valid RoleTypeRef roleType;
}