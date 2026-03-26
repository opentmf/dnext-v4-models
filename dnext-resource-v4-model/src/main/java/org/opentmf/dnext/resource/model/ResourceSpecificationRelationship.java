package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.resource.model.IResourceSpecificationRelationship;

/**
 * A migration, substitution, dependency or exclusivity relationship
 * between/among resource specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id, relationshipType<br/>
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
    defaultImpl = ResourceSpecificationRelationship.class
)
@Required(fields = {"relationshipType", "href", "id"})
public class ResourceSpecificationRelationship extends NamedEntity implements IResourceSpecificationRelationship {

  /**
   * A characteristic that refines the relationship. For example, consider the
   * relationship between a slot and a card. For a half-height card it is
   * important to know the position at which the card is inserted, so a
   * characteristic Position might be defined on the relationship to allow
   * capturing of this in the inventory.
   */
  @JsonProperty("characteristic")
  private List<@Valid ResourceSpecificationCharacteristic> characteristics;

  /**
   * The default number of the related resource that should be instantiated, for
   * example a rack would typically have 4 cards, although it could support more.
   */
  private Integer defaultQuantity;

  /**
   * The maximum number of the related resource that should be instantiated, for
   * example a rack supports a maximum of 16 cards.
   */
  private Integer maximumQuantity;

  /**
   * The minimum number of the related resource that should be instantiated, for
   * example a rack must have at least 1 card.
   */
  private Integer minimumQuantity;

  /**
   * Type of relationship such as migration, substitution, dependency,
   * exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * The association role for this resource specification.
   */
  private @SafeText String role;

  /**
   * The period for which the ResourceSpecRelationship is valid.
   */
  private @Valid TimePeriod validFor;

  /**
   * The version given to the target resource specification instance.
   */
  private @SafeText String version;
}