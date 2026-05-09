package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IAgreementSpecificationRelationship;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A relationship between agreement specifications. Typical relationships are
 * substitution and dependency.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement Management API</li>
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
    defaultImpl = AgreementSpecificationRelationship.class
)
public class AgreementSpecificationRelationship extends RelationshipBase implements IAgreementSpecificationRelationship {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;
}