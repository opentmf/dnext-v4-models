package org.opentmf.dnext.tmf671.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteInformationRequiredEventBase;
import org.opentmf.tmf671.model.IPromotionAttributeValueChangeEvent;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
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
    defaultImpl = PromotionAttributeValueChangeEvent.class
)
public class PromotionAttributeValueChangeEvent extends QuoteInformationRequiredEventBase implements IPromotionAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PromotionAttributeValueChangeEventPayload event;
}