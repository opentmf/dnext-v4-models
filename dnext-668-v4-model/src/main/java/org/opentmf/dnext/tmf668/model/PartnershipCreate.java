package org.opentmf.dnext.tmf668.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.Partner;
import org.opentmf.dnext.common.model.PartnershipSpecificationRef;
import org.opentmf.dnext.common.model.ServiceUpdateBase;
import org.opentmf.tmf668.model.IPartnershipCreate;

/**
 * The Partnership to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> name, specification<br/>
 * </p>
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
    defaultImpl = PartnershipCreate.class
)
@Required(fields = {"name", "specification"})
public class PartnershipCreate extends ServiceUpdateBase implements IPartnershipCreate {

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

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
   * The specification of this partnership.
   */
  private @Valid PartnershipSpecificationRef specification;
}