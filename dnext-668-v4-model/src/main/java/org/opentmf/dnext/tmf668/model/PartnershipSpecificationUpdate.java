package org.opentmf.dnext.tmf668.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.CartTermBase;
import org.opentmf.tmf668.model.IPartnershipSpecificationUpdate;

/**
 * The PartnershipSpecification to be updated.
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
    defaultImpl = PartnershipSpecificationUpdate.class
)
public class PartnershipSpecificationUpdate extends CartTermBase implements IPartnershipSpecificationUpdate {

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

  /**
   * The list of roles specifications a engaged party will be able to play for
   * this kind of partnership.
   */
  @JsonProperty("roleSpecification")
  private List<@Valid PartnershipRoleSpecification> roleSpecifications;
}