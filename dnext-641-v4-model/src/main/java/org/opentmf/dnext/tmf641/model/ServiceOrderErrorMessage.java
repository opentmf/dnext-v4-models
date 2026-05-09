package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opentmf.dnext.common.model.ServiceOrderItemRef;
import org.opentmf.tmf641.model.IServiceOrderErrorMessage;

/**
 * A ServiceOrderErrorMessage represents an error that causes a status change in
 * a service order.
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
@ToString(callSuper = true)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ServiceOrderErrorMessage.class
)
@JsonTypeName("ServiceOrderErrorMessage")
public class ServiceOrderErrorMessage extends ServiceOrderItemErrorMessage implements IServiceOrderErrorMessage {

  /**
   * A list of order item references corresponded to this error.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItemRef> serviceOrderItems;
}