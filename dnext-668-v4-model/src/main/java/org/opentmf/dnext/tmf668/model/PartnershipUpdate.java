package org.opentmf.dnext.tmf668.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.Partner;
import org.opentmf.tmf668.model.IPartnershipUpdate;

/**
 * The Partnership to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-668: Partnership Type</li>
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
    defaultImpl = PartnershipUpdate.class
)
public class PartnershipUpdate extends NamedEntity implements IPartnershipUpdate {

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

  /**
   * An explanatory text regarding this partnership.
   */
  private @SafeText String description;

  /**
   * A list of external references.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * The list of partners of the partnership, where a partner represents a party
   * playing a given role. Hence a partner structure includes primarily a
   * reference to the engaged party and a role name matching necessarily the name
   * of one of the role specifications defined in the specification of the
   * partnership.
   */
  @JsonProperty("partner")
  private List<@Valid Partner> partners;

  /**
   * PartnershipSpecification reference. A partnership specification contains all
   * the information for the setup of a partnership of a given kind. This includes
   * the list of identified role types for the partnership with the corresponding
   * agreement specifications.
   */
  private @Valid PartnershipSpecificationRef specification;
}