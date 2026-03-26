package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IRoleTypeRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * RoleType reference.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = RoleTypeRef.class
)
@Required(fields = {"id"})
public class RoleTypeRef extends EntityRef implements IRoleTypeRef {

  /**
   * Reference url of the partnership type containing the role type.
   */
  private URI partnershipHref;

  /**
   * The identifier of the partnership type containing the role type.
   */
  @SafeId
  @Size(max = 100)
  private String partnershipId;

  /**
   * The name of the partnership type defining this role type.
   */
  private @SafeText String partnershipName;
}