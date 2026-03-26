package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.AccountRef;
import org.opentmf.tmf666.model.IBillFormatRefOrValue;

/**
 * An attachment by value or by reference.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = BillFormatRefOrValue.class
)
public class BillFormatRefOrValue extends AccountRef implements IBillFormatRefOrValue {

  private Boolean isRef;
}