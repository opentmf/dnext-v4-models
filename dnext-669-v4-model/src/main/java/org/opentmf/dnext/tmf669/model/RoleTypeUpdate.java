package org.opentmf.dnext.tmf669.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.AgreementRef;
import org.opentmf.dnext.common.model.Extensible;

/**
 * A RoleType represents the type of a PartyRole, defined in the context of a
 * given type of partnership, such as Buyer, Seller.
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
    defaultImpl = RoleTypeUpdate.class
)
public class RoleTypeUpdate extends Extensible {

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

  /**
   * Agreement reference. An agreement represents a contract or arrangement,
   * either written or verbal and sometimes enforceable by law, such as a service
   * level agreement or a customer price agreement. An agreement involves a number
   * of other business entities, such as products, services, and resources and/or
   * their specifications.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * An explanatory text documenting the role type.
   */
  private @SafeText String description;

  /**
   * The name of the role type.
   */
  private @SafeText String name;

  /**
   * Indicates whether billing operations will be associated to parties playing
   * the role.
   */
  private Boolean requiresBilling;

  /**
   * Indicates whether settlement operations will be associated to parties playing
   * the role.
   */
  private Boolean requiresSettlement;
}