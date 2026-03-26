package org.opentmf.dnext.tmf669.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The part played by a party in a given context. Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> engagedParty, name, roleType<br/>
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
    defaultImpl = PartyRoleCreate.class
)
@Required(fields = {"name", "roleType", "engagedParty"})
public class PartyRoleCreate extends PartyRoleUpdate {

  /**
   * Unique identifier of the party role.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}