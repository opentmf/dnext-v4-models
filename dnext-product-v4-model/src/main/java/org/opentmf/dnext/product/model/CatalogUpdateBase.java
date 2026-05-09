package org.opentmf.dnext.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TimePeriod;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>CatalogUpdate (620)</li>
 *   <li>CategoryUpdate (620)</li>
 *   <li>ProductOfferingPriceUpdate (620)</li>
 *   <li>ProductSpecificationUpdate (620)</li>
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
    defaultImpl = CatalogUpdateBase.class
)
public abstract class CatalogUpdateBase extends NamedEntity {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Description of this catalog.
   */
  private @SafeText String description;

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * The period for which the catalog is valid.
   */
  private @Valid TimePeriod validFor;
}