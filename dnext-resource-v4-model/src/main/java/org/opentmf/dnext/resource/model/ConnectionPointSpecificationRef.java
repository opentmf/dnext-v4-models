package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.resource.model.IConnectionPointSpecificationRef;

/**
 * Connection point specification reference. A connection point provides a
 * service access point (SAP) for input and/or output of the resource function.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = ConnectionPointSpecificationRef.class
)
@Required(fields = {"id"})
public class ConnectionPointSpecificationRef extends CategoryRef implements IConnectionPointSpecificationRef {
}