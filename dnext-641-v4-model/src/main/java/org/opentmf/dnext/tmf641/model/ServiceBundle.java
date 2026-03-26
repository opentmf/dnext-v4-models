package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.NamedEntity;

/**
 * A type of ServiceSpecification that belongs to a grouping of
 * ServiceSpecifications made available to the market. It inherits of all
 * attributes of ServiceSpecification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = ServiceBundle.class
)
public class ServiceBundle extends NamedEntity {

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;
}