package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 12 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>BillFormatCreate (666)</li>
 *   <li>BillFormatUpdate (666)</li>
 *   <li>BillPresentationMediaCreate (666)</li>
 *   <li>BillPresentationMediaUpdate (666)</li>
 *   <li>CartTerm (663)</li>
 *   <li>OrderTerm (622)</li>
 *   <li>POPAlteration (620)</li>
 *   <li>PartnershipRoleSpecification (668)</li>
 *   <li>PartnershipSpecificationCreate (668)</li>
 *   <li>PartnershipSpecificationUpdate (668)</li>
 *   <li>PricingLogicAlgorithm (620)</li>
 *   <li>ProductOfferingTerm (620)</li>
 *   <li>ProductTerm (622, 637, 648, 658, 663)</li>
 *   <li>PromotionPattern (671)</li>
 *   <li>ResourceGraphSpecification (634)</li>
 *   <li>ServiceOrderMilestone (641)</li>
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
    defaultImpl = CartTermBase.class
)
public abstract class CartTermBase extends Extensible {

  /**
   * Detailed description of the party account.
   */
  private @SafeText String description;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the bill format.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A short descriptive name.
   */
  private @SafeText String name;
}