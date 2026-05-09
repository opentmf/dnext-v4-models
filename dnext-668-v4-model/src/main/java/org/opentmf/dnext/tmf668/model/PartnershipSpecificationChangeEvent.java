package org.opentmf.dnext.tmf668.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf668.model.IPartnershipSpecificationChangeEvent;

/**
 * The notification data structure.
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
    defaultImpl = PartnershipSpecificationChangeEvent.class
)
public class PartnershipSpecificationChangeEvent extends QuoteCreateEventBase implements IPartnershipSpecificationChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PartnershipSpecificationChangeEventPayload event;
}