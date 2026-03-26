package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opentmf.tmf641.model.IServiceOrderItemErrorMessage;

/**
 * A ServiceOrderItemErrorMessage represents an error that causes a status
 * change in a service order item.
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
    defaultImpl = ServiceOrderItemErrorMessage.class
)
@JsonTypeName("ServiceOrderItemErrorMessage")
public class ServiceOrderItemErrorMessage extends ErrorMessage implements IServiceOrderItemErrorMessage {

  /**
   * Date when the error happened.
   */
  private OffsetDateTime timestamp;
}