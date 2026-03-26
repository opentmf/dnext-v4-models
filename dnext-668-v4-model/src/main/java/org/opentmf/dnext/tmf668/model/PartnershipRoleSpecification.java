package org.opentmf.dnext.tmf668.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AgreementSpecificationRef;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.tmf668.model.IPartnershipRoleSpecification;

/**
 * A PartnershipRoleSpecification represents a specification of a role defined
 * in the context of a given type of partnership (PartnershipSpecification),
 * such as Buyer, Seller.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
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
    defaultImpl = PartnershipRoleSpecification.class
)
@Required(fields = {"name"})
public class PartnershipRoleSpecification extends NamedEntity implements IPartnershipRoleSpecification {

  /**
   * List of: AgreementSpecification reference. An AgreementSpecification
   * represents a template of an agreement that can be used when establishing
   * partnerships.
   */
  @JsonProperty("agreementSpecification")
  private List<@Valid AgreementSpecificationRef> agreementSpecifications;

  /**
   * An explanatory text documenting the role specification.
   */
  private @SafeText String description;

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