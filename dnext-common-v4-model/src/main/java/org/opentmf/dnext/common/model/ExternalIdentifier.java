package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IExternalIdentifier;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An identification of an entity that is owned by or originates in a software
 * system different from the current system.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-667: Document Management API</li>
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
    defaultImpl = ExternalIdentifier.class
)
@Required(fields = {"id"})
public class ExternalIdentifier extends Entity implements IExternalIdentifier {

  /**
   * Type of the identification, typically would be the type of the entity within
   * the external system.
   */
  private @SafeText String externalIdentifierType;

  /**
   * Name of the external system that owns the entity.
   */
  private @SafeText String owner;
}