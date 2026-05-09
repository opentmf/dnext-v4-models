package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.tmf658.model.ILoyaltyProgramProductSpecCreate;

/**
 * The LoyaltyProgramProductSpec to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> name, productNumber<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = LoyaltyProgramProductSpecCreate.class
)
@Required(fields = {"name", "productNumber"})
public class LoyaltyProgramProductSpecCreate extends LoyaltyProgramProductSpecUpdate implements ILoyaltyProgramProductSpecCreate {

  /**
   * A narrative that explains in detail what the product specification is.
   */
  private Boolean needsLoyaltyAccount;
}