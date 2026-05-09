package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AgreementRef;
import org.opentmf.dnext.common.model.Attachment;
import org.opentmf.dnext.common.model.ChannelRef;
import org.opentmf.dnext.common.model.DecisionTreeRef;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.MarketSegmentRef;
import org.opentmf.dnext.common.model.PlaceRef;
import org.opentmf.dnext.common.model.ProductOfferingPriceRef;
import org.opentmf.dnext.common.model.ProductSpecificationRef;
import org.opentmf.dnext.common.model.ResourceCandidateRef;
import org.opentmf.dnext.common.model.SLARef;
import org.opentmf.dnext.common.model.ServiceCandidateRef;

/**
 * The ProductOffering to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = ProductOfferingUpdate.class
)
public class ProductOfferingUpdate extends CatalogUpdate {

  /**
   * An agreement represents a contract or arrangement, either written or verbal
   * and sometimes enforceable by law, such as a service level agreement or a
   * customer price agreement. An agreement involves a number of other business
   * entities, such as products, services, and resources and/or their
   * specifications.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid Attachment> attachments;

  /**
   * A group of product offerings that can be chosen for instantiation of children
   * of the parent product offering, for example a list of channels for selection
   * under a TV offering. Sometimes known as Selection Group. The group can also
   * hierarchically contain other groups.
   */
  @JsonProperty("bundledGroupProductOffering")
  private List<@Valid BundledGroupProductOffering> bundledGroupProductOfferings;

  /**
   * A type of ProductOffering that belongs to a grouping of ProductOfferings made
   * available to the market. It inherits of all attributes of ProductOffering.
   */
  @JsonProperty("bundledProductOffering")
  private List<@Valid BundledProductOffering> bundledProductOfferings;

  /**
   * The channel defines the channel for selling product offerings.
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * isBundle determines whether a productOffering represents a single
   * productOffering (false), or a bundle of productOfferings (true).
   */
  private Boolean isBundle;

  /**
   * A flag indicating if this product offer can be sold stand-alone for sale or
   * not. If this flag is false it indicates that the offer can only be sold
   * within a bundle.
   */
  private Boolean isSellable;

  /**
   * provides references to the corresponding market segment as target of product
   * offerings. A market segment is grouping of Parties, GeographicAreas,
   * SalesChannels, and so forth.
   */
  @JsonProperty("marketSegment")
  private List<@Valid MarketSegmentRef> marketSegments;

  private @Valid ProductOfferingExtension pExtension;

  /**
   * Place defines the places where the products are sold or delivered.
   */
  @JsonProperty("place")
  private List<@Valid PlaceRef> places;

  /**
   * A use of the ProductSpecificationCharacteristicValue by a ProductOffering to
   * which additional properties (attributes) apply or override the properties of
   * similar properties contained in ProductSpecificationCharacteristicValue. It
   * should be noted that characteristics which their value(s) addressed by this
   * object must exist in corresponding product specification. The available
   * characteristic values for a ProductSpecificationCharacteristic in a Product
   * specification can be modified at the ProductOffering level. For example, a
   * characteristic 'Color' might have values White, Blue, Green, and Red. But,
   * the list of values can be restricted to e.g. White and Blue in an associated
   * product offering. It should be noted that the list of values in
   * 'ProductSpecificationCharacteristicValueUse' is a strict subset of the list
   * of values as defined in the corresponding product specification
   * characteristics.
   */
  @JsonProperty("prodSpecCharValueUse")
  private List<@Valid ProductSpecificationCharacteristicValueUse> prodSpecCharValueUses;

  /**
   * An amount, usually of money, that is asked for or allowed when a
   * ProductOffering is bought, rented, or leased. The price is valid for a
   * defined period of time and may not represent the actual price paid by a
   * customer.
   */
  @JsonProperty("productOfferingPrice")
  private List<@Valid ProductOfferingPriceRef> productOfferingPrices;

  /**
   * A migration, substitution, dependency or exclusivity relationship
   * between/among product offerings.
   */
  @JsonProperty("productOfferingRelationship")
  private List<@Valid ProductOfferingRelationship> productOfferingRelationships;

  /**
   * A condition under which a ProductOffering is made available to Customers. For
   * instance, a productOffering can be offered with multiple commitment periods.
   */
  @JsonProperty("productOfferingTerm")
  private List<@Valid ProductOfferingTerm> productOfferingTerms;

  /**
   * A ProductSpecification is a detailed description of a tangible or intangible
   * object made available externally in the form of a ProductOffering to
   * customers or other parties playing a party role.
   */
  private @Valid ProductSpecificationRef productSpecification;

  /**
   * A resource candidate is an entity that makes a ResourceSpecification
   * available to a catalog.
   */
  private @Valid ResourceCandidateRef resourceCandidate;

  @JsonProperty("rules")
  private List<@Valid DecisionTreeRef> ruleses;

  /**
   * ServiceCandidate is an entity that makes a ServiceSpecification available to
   * a catalog.
   */
  private @Valid ServiceCandidateRef serviceCandidate;

  /**
   * A service level agreement (SLA) is a type of agreement that represents a
   * formal negotiated agreement between two parties designed to create a common
   * understanding about products, services, priorities, responsibilities, and so
   * forth. The SLA is a set of appropriate procedures and targets formally or
   * informally agreed between parties in order to achieve and maintain specified
   * Quality of Service.
   */
  private @Valid SLARef serviceLevelAgreement;

  /**
   * A string providing a complementary information on the value of the lifecycle
   * status attribute.
   */
  private @SafeText String statusReason;
}