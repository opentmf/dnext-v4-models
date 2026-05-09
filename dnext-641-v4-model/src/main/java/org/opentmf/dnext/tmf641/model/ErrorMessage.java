package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opentmf.dnext.common.model.Error;
import org.opentmf.tmf641.model.IErrorMessage;

/**
 * represents an Error.
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
    defaultImpl = ErrorMessage.class
)
public class ErrorMessage extends Error implements IErrorMessage {
}