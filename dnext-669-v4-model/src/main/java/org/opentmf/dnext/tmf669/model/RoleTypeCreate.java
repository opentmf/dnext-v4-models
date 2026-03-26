package org.opentmf.dnext.tmf669.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A RoleType represents the type of a PartyRole, defined in the context of a
 * given type of partnership, such as Buyer, Seller.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-669: Party Role Management API</li>
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
    defaultImpl = RoleTypeCreate.class
)
@Required(fields = {"name"})
public class RoleTypeCreate extends RoleTypeUpdate {

  /**
   * Unique identifier of the role type.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}