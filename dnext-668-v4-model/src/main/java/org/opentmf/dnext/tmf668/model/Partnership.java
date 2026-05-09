package org.opentmf.dnext.tmf668.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.AttachmentBase;
import org.opentmf.dnext.common.model.Partner;
import org.opentmf.dnext.common.model.PartnershipSpecificationRef;
import org.opentmf.tmf668.model.IPartnership;

/**
 * A partnership represents a formalized collaboration between various parties,
 * each party playing a role in the partnership. The parties playing a role in
 * the partnership represented by the Partner entity. The structure of a
 * partnership is specified by a PartnershipSpecification which contain all the
 * information for the setup of the partnership, including the list of
 * identified roles and the agreement that should apply.
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
    defaultImpl = Partnership.class
)
@Required(fields = {"name", "specification"})
public class Partnership extends AttachmentBase implements IPartnership {

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