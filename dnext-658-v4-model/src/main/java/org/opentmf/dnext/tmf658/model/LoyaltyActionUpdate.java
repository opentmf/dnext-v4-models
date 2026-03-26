package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.ProductOfferingRef;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * The LoyaltyAction to be updated.
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
public class LoyaltyActionUpdate {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * The HTTP operation to be used when calling the endpoint.
   */
  private @SafeText String action;

  /**
   * Additional attributes required to perform the action. These attributes will
   * depend on the type of the loyalty action. For example, if it is a LoyaltyEarn
   * action, there will be a “quantity” attribute value pair indicating how
   * mString points should be earned.
   */
  private @SafeText String actionAttributes;

  /**
   * The type of loyalty action.
   */
  private @SafeText String actionType;

  /**
   * The body if the request that is made when this action is executed. The body
   * is assumed to be of type text/json. String tokens denoted with {} will be
   * replaced by attributes present in: Member profile, actionAttributes or event
   * attributes in the loyalty event request.
   */
  private @SafeText String body;

  /**
   * A user-friendly identifier of the loyalty execution point.
   */
  private @SafeText String commonName;

  /**
   * A free-form description of the loyalty execution point.
   */
  private @SafeText String description;

  /**
   * The endpoint to call to trigger a BusinessInteraction, CustomerOrder or
   * LoyaltyEarn.
   */
  private @SafeText String endpoint;

  /**
   * The HTTP headers that is added to the action call.
   */
  private @SafeText String headers;

  /**
   * Optional reference to a partnership related to a BusinessInteraction benefit
   * action type.
   */
  private @Valid PartnershipRef partnership;

  /**
   * Optional reference to product offering related to a CustomerOrder or
   * BusinessInteraction action type.
   */
  private @Valid ProductOfferingRef productOffering;

  /**
   * A string that identifies the version of the loyalty action.
   */
  private @SafeText String version;
}