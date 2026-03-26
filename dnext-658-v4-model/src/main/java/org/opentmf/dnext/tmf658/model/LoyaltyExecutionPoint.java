package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.product.model.LoyaltyBase;
import org.opentmf.tmf658.model.ILoyaltyExecutionPoint;

/**
 * A record of a loyalty action that was applied.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = LoyaltyExecutionPoint.class
)
public class LoyaltyExecutionPoint extends LoyaltyBase implements ILoyaltyExecutionPoint {

  /**
   * The HTTP operation to be used when calling the endpoint.
   */
  private @SafeText String action;

  /**
   * Additional attributes required to perform the action. These attributes will
   * depend on the type of the loyalty action. For example, if it is a LoyaltyEarn
   * action, there will be a “quantity” attribute value pair indicating how many
   * points should be earned.
   */
  private Object actionAttributes;

  /**
   * The body if the request that is made when this action i executed. The body is
   * assumed to be of type text/json. Any tokens denoted with {} will be replaced
   * by attributes present in: Member profile, actionAttributes or event
   * attributes in the loyalty event request.
   */
  private Object body;

  /**
   * A user-friendly identifier of the loyalty execution point.
   */
  private @SafeText String commonName;

  /**
   * The timestamp that the action was applied.
   */
  private OffsetDateTime datetime;

  /**
   * A free-form description of the loyalty execution point.
   */
  private @SafeText String description;

  /**
   * The endpoint called to trigger the Loyalty Program reward.
   */
  private @SafeText String endpoint;

  /**
   * The HTTP headers that is added to the action call.
   */
  private Object headers;

  /**
   * The member benefiting from the loyalty execution point.
   */
  private @Valid LoyaltyProgramMember loyaltyProgramMember;

  /**
   * The loyalty program product that resulted in the loyalty program execution
   * point.
   */
  private @Valid LoyaltyProgramProduct loyaltyProgramProduct;

  /**
   * A string that identifies the version of the loyalty action.
   */
  private @SafeText String version;
}