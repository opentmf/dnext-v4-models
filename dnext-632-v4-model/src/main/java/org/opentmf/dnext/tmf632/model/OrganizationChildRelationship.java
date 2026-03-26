package org.opentmf.dnext.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.tmf632.model.IOrganizationChildRelationship;

/**
 * Child references of an organization in a structure of organizations.
 *
 * <p><br/>
 * <strong>Required:</strong> organization, relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = OrganizationChildRelationship.class
)
@Required(fields = {"relationshipType", "organization"})
public class OrganizationChildRelationship extends Entity implements IOrganizationChildRelationship {

  private @Valid OrganizationRef organization;

  /**
   * Type of the relationship. Could be juridical, hierarchical, geographical,
   * functional for example.
   */
  private @SafeText String relationshipType;
}