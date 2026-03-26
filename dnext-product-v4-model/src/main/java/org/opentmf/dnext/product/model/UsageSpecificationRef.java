package org.opentmf.dnext.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.EntityRef;
import org.opentmf.product.model.IUsageSpecificationRef;

/**
 * UsageSpecification reference. UsageSpecification is a detailed description of
 * a usage event that are of interest to the business and can have charges
 * applied to it. It is comprised of characteristics, which define all
 * attributes known for a particular type of usage.
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
    defaultImpl = UsageSpecificationRef.class
)
@Required(fields = {"id"})
public class UsageSpecificationRef extends EntityRef implements IUsageSpecificationRef {
}