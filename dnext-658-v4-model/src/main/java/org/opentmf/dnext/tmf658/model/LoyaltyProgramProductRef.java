package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.EntityRef;
import org.opentmf.tmf658.model.ILoyaltyProgramProductRef;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> @referredType<br/>
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
    defaultImpl = LoyaltyProgramProductRef.class
)
@Required(fields = {"atReferredType"})
public class LoyaltyProgramProductRef extends EntityRef implements ILoyaltyProgramProductRef {
}