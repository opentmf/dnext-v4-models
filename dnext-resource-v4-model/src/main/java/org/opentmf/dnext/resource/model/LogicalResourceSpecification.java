package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.ResourceSpecificationExtension;
import org.opentmf.resource.model.ILogicalResourceSpecification;

/**
 * This is a base class that is used to define the invariant characteristics and
 * behavior (attributes, methods, constraints, and relationships) of a
 * LogicalResource.
 *
 * <p><br/>
 * <strong>Required:</strong> @type<br/>
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
    defaultImpl = LogicalResourceSpecification.class
)
@Required(fields = {"atType"})
public class LogicalResourceSpecification extends ResourceSpecification implements ILogicalResourceSpecification {

  private @Valid ResourceSpecificationExtension pextension;
}