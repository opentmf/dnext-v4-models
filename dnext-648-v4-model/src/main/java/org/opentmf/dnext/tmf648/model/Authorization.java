package org.opentmf.dnext.tmf648.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf648.model.IAuthorization;

/**
 * If special discount or special product offering price or specific condition
 * need an approval for ISP sale representative it is described here.
 *
 * <p><br/>
 * <strong>Required:</strong> state<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
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
    defaultImpl = Authorization.class
)
@Required(fields = {"state"})
public class Authorization extends Extensible implements IAuthorization {

  @JsonProperty("approver")
  private List<@Valid RelatedParty> approvers;

  /**
   * Date when the authorization (approved or declined) was done.
   */
  private OffsetDateTime givenDate;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Name of the required authorization.
   */
  private @SafeText String name;

  /**
   * Date when the authorization is requested for.
   */
  private OffsetDateTime requestedDate;

  /**
   * To describe a digital or manual signature.
   */
  private @SafeText String signatureRepresentation;

  /**
   * State of the authorization, such as: approved or declined.
   */
  private @SafeText String state;
}