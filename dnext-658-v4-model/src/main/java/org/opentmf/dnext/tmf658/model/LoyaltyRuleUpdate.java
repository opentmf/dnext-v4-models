package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The LoyaltyRule to be updated.
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
public class LoyaltyRuleUpdate {

  private Boolean cnf;

  /**
   * A user-friendly identifier of the loyalty rule.
   */
  private @SafeText String commonName;

  /**
   * A free-form description of the rule.
   */
  private @SafeText String description;

  /**
   * This is a Boolean attribute that, if true, defines the condition clause of
   * this rule to be represented in Conjunctive Normal Form (e.g., an AND of ORs).
   * If the value of this attribute is false, then the condition clause will be
   * represented in Disjunctive Normal Form (e.g., an OR of ANDs).
   */
  private Boolean isCNF;

  /**
   * A Boolean attribute that, if true, signifies that evaluation (and possibly
   * action execution) of this entity is mandatory and must be attempted. If the
   * Mandatory property value of this entity is false, then the evaluation of this
   * entity is considered to be 'best effort' and may be ignored.
   */
  private Boolean isMandatoryEvaluation;

  /**
   * A string attribute that defines a set of one or more keywords that a policy
   * administrator may use to assist in characterizing or categorizing a policy
   * object to facilitate search operations.
   */
  private @SafeText String keywords;

  /**
   * References to linked actions.
   */
  @JsonProperty("loyaltyAction")
  private List<@Valid LoyaltyActionRef> loyaltyActions;

  /**
   * References to linked conditions.
   */
  @JsonProperty("loyaltyCondition")
  private List<@Valid LoyaltyConditionRef> loyaltyConditions;

  /**
   * References to linked event types.
   */
  @JsonProperty("loyaltyEventType")
  private List<@Valid LoyaltyEventTypeRef> loyaltyEventTypes;

  private Boolean mandatoryEvaluation;

  /**
   * A generic naming attribute that can be used to identify different policy
   * entities.
   */
  private @SafeText String policyName;

  /**
   * References to sub-rules.
   */
  @JsonProperty("subRule")
  private List<@Valid LoyaltyRule> subRules;

  /**
   * A free-form string attribute that recommends how this policy object should be
   * used.
   */
  private @SafeText String usage;
}