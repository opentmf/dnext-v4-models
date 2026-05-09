package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IPartnershipRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Partnership reference. A partnership contains all the information for the
 * setup of a partnership of a given kind. This includes the list of identified
 * role types for the partnership with the corresponding agreement
 * specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
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
    defaultImpl = PartnershipRef.class
)
@Required(fields = {"id"})
public class PartnershipRef extends EntityRef implements IPartnershipRef {
}