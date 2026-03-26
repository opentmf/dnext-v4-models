package org.opentmf.dnext.service.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.service.model.IServiceCategoryRef;

/**
 * The (service) category resource is used to group service candidates in
 * logical containers. Categories can contain other categories.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id<br/>
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
    defaultImpl = ServiceCategoryRef.class
)
@Required(fields = {"href", "id"})
public class ServiceCategoryRef extends CategoryRef implements IServiceCategoryRef {
}