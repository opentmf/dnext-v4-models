package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IServiceLevelSpecificationRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A Service Level Specification represents a pre-defined or negotiated set of
 * Service Level Objectives. In addition, certain consequences are associated
 * with not meeting the Service Level Objectives. Service Level Agreements are
 * expressed in terms of Service Level Specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
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
    defaultImpl = ServiceLevelSpecificationRef.class
)
@Required(fields = {"id"})
public class ServiceLevelSpecificationRef extends EntityRef implements IServiceLevelSpecificationRef {
}