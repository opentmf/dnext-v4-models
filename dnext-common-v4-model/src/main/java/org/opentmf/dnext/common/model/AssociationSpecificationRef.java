package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IAssociationSpecificationRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * reference to an AssociationSpecification object.
 *
 * <p><br/>
 * <strong>Required:</strong> @referredType, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = AssociationSpecificationRef.class
)
@Required(fields = {"atReferredType", "id"})
public class AssociationSpecificationRef extends EntityRef implements IAssociationSpecificationRef {
}