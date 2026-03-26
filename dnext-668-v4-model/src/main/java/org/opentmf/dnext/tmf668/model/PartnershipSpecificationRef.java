package org.opentmf.dnext.tmf668.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.EntityRef;
import org.opentmf.tmf668.model.IPartnershipSpecificationRef;

/**
 * PartnershipSpecification reference. A partnership specification contains all
 * the information for the setup of a partnership of a given kind. This includes
 * the list of identified role types for the partnership with the corresponding
 * agreement specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
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
    defaultImpl = PartnershipSpecificationRef.class
)
@Required(fields = {"id"})
public class PartnershipSpecificationRef extends EntityRef implements IPartnershipSpecificationRef {
}