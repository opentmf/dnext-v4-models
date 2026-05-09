package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Addressable;
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
public class LoyaltyExecutionPoint extends Addressable implements ILoyaltyExecutionPoint {

  /**
   * When subclassing, this defines the super-class.
   */
  @JsonProperty("@baseType")
  private @SafeText String atBaseType;

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * When subclassing, this defines the subclass Extensible name.
   */
  @JsonProperty("@type")
  private @SafeText String atType;

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

  private @SafeText String baseType;

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
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

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
   * Version number of the entity.
   */
  private Integer revision;

  private URI schemaLocation;

  /**
   * The type of loyalty action.
   */
  private @SafeText String type;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;

  /**
   * A string that identifies the version of the loyalty action.
   */
  private @SafeText String version;
}