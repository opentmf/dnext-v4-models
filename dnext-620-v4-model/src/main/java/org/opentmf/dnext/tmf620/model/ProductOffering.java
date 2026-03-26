package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AgreementRef;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.ChannelRef;
import org.opentmf.dnext.common.model.DecisionTreeRef;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.MarketSegmentRef;
import org.opentmf.dnext.common.model.PlaceRef;
import org.opentmf.dnext.common.model.ProductSpecificationRef;
import org.opentmf.dnext.common.model.ResourceCandidateRef;
import org.opentmf.dnext.common.model.SLARef;
import org.opentmf.dnext.common.model.ServiceCandidateRef;
import org.opentmf.tmf620.model.IProductOffering;

/**
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
    defaultImpl = ProductOffering.class
)
public class ProductOffering extends CatalogCreate implements IProductOffering {

  /**
   * A list of agreement references (AgreementRef [*]). An
   * <br/>agreement represents a contract or arrangement, either written
   * <br/>or verbal and sometimes enforceable by law, such as a service
   * <br/>level agreement or a customer price agreement. An agreement
   * <br/>involves a number of other business entities, such as products,
   * <br/>services, and resources and/or their specifications.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A group of product offerings that can be chosen for instantiation of children
   * of the parent product offering, for example a list of channels for selection
   * under a TV offering. Sometimes known as Selection Group. The group can also
   * hierarchically contain other groups.
   */
  @JsonProperty("bundledGroupProductOffering")
  private List<@Valid BundledGroupProductOffering> bundledGroupProductOfferings;

  /**
   * A list of bundled product offerings (BundledProductOffering [*]).
   * <br/>A type of ProductOffering that belongs to a grouping of
   * <br/>ProductOfferings made available to the market. It inherits of all
   * <br/>attributes of ProductOffering.
   */
  @JsonProperty("bundledProductOffering")
  private List<@Valid BundledProductOffering> bundledProductOfferings;

  /**
   * A list of channel references (ChannelRef [*]). The channel
   * <br/>defines the channel for selling product offerings.
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * External reference of the individual or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Reference of the entity.
   */
  private URI href;

  /**
   * Bundle determines whether a productOffering
   * <br/>represents a single productOffering (false), or a bundle of
   * <br/>productOfferings (true).
   */
  private Boolean isBundle;

  /**
   * A link to the schema describing this product offering.
   */
  private Boolean isSellable;

  /**
   * A list of market segment references (MarketSegmentRef [*]).
   * <br/>provides references to the corresponding market segment as
   * <br/>target of product offerings. A market segment is grouping of
   * <br/>Parties, GeographicAreas, SalesChannels, and so forth.
   */
  @JsonProperty("marketSegment")
  private List<@Valid MarketSegmentRef> marketSegments;

  private @Valid ProductOfferingExtension pExtension;

  /**
   * A list of place references (PlaceRef [*]). Place defines the
   * <br/>places where the products are sold or delivered.
   */
  @JsonProperty("place")
  private List<@Valid PlaceRef> places;

  /**
   * A list of prod spec char value uses (ProdSpecCharValueUse
   * <br/>[*]). A use of the ProdSpecCharacteristicValue by a
   * <br/>ProductOffering to which additional properties (attributes) apply
   * <br/>or override the properties of similar properties contained in
   * <br/>ProdSpecCharacteristicValue. It should be noted that
   * <br/>characteristics which their value(s) addressed by this object
   * <br/>must exist in corresponding product specification. The available
   * <br/>characteristic values for a ProductSpecCharacteristic in a
   * <br/>Product specification can be modified at the ProductOffering
   * <br/>level. For example, a characteristic 'Color' might have values
   * <br/>White, Blue, Green, and Red. But, the list of values can be
   * <br/>restricted to e.g. White and Blue in an associated product
   * <br/>offering. It should be noted that the list of values in
   * <br/>'ProdSpecCharValueUse' is a strict subset of the list of values
   * <br/>as defined in the corresponding product specification
   * <br/>characteristics.
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
  private List<@Valid ProductOfferingPriceRefOrValue> productOfferingPrices;

  /**
   * A migration, substitution, dependency or exclusivity relationship
   * between/among product offerings.
   */
  @JsonProperty("productOfferingRelationship")
  private List<@Valid ProductOfferingRelationship> productOfferingRelationships;

  /**
   * A list of product offering terms (ProductOfferingTerm [*]). A
   * <br/>condition under which a ProductOffering is made available to
   * <br/>Customers. For instance, a productOffering can be offered with
   * <br/>multiple commitment periods..
   */
  @JsonProperty("productOfferingTerm")
  private List<@Valid ProductOfferingTerm> productOfferingTerms;

  /**
   * (ProductSpecificationRef). A
   * <br/>ProductSpecification is a detailed description of a tangible or
   * <br/>intangible object made available externally in the form of a
   * ProductOffering.
   */
  private @Valid ProductSpecificationRef productSpecification;

  /**
   * resource candidate is an entity that makes a
   * <br/>ResourceSpecification available to a catalog.
   */
  private @Valid ResourceCandidateRef resourceCandidate;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  @JsonProperty("rules")
  private List<@Valid DecisionTreeRef> ruleses;

  /**
   * A service candidate reference (ServiceCandidateRef).
   * <br/>ServiceCandidate is an entity that makes a ServiceSpecification
   * <br/>available to a catalog.
   */
  private @Valid ServiceCandidateRef serviceCandidate;

  /**
   * A SLA reference (SLARef). ServiceLevelAgreement reference:
   * <br/>A service level agreement (SLA) is a type of agreement that
   * <br/>represents a formal negotiated agreement between two parties
   * <br/>designed to create a common understanding about products,
   * <br/>services, priorities, responsibilities, and so forth. The SLA is a
   * <br/>set of appropriate procedures and targets formally or informally
   * <br/>agreed between parties in order to achieve and maintain
   * <br/>specified Quality of Service.
   */
  private @Valid SLARef serviceLevelAgreement;

  /**
   * A string providing a complementary information on the value of the lifecycle
   * status attribute.
   */
  private @SafeText String statusReason;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;
}