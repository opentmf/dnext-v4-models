package org.opentmf.dnext.partner.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.partner.model.IAgreementTermOrCondition;

/**
 * Aspects of the agreement not formally specified elsewhere in the agreement
 * and that cannot be captured elsewhere in a formal notation, or automatically
 * monitored and require a more human level of management.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement Management API</li>
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
    defaultImpl = AgreementTermOrCondition.class
)
public class AgreementTermOrCondition extends Entity implements IAgreementTermOrCondition {

  /**
   * Text that explains the term or condition of the agreement.
   */
  private @SafeText String description;

  private @Valid TimePeriod validFor;
}