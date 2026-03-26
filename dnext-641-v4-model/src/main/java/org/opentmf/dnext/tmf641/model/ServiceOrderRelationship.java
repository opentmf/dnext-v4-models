package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.CharacteristicRelationship;
import org.opentmf.tmf641.model.IServiceOrderRelationship;

/**
 * Linked service order to the one containing this attribute.
 *
 * <p><br/>
 * <strong>Required:</strong> id, relationshipType<br/>
 * </p>
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
    defaultImpl = ServiceOrderRelationship.class
)
@Required(fields = {"relationshipType", "id"})
public class ServiceOrderRelationship extends CharacteristicRelationship implements IServiceOrderRelationship {

  /**
   * The entity type of the related order.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;
}