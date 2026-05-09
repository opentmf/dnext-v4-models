package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteInformationRequiredEventBase;
import org.opentmf.tmf641.model.IServiceOrderAttributeValueChangeEvent;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = ServiceOrderAttributeValueChangeEvent.class
)
public class ServiceOrderAttributeValueChangeEvent extends QuoteInformationRequiredEventBase implements IServiceOrderAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ServiceOrderAttributeValueChangeEventPayload event;
}