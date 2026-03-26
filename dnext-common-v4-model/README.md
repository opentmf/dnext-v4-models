# dnext-common-v4-model

Shared **model** types for the **Common** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

- TMF-620: Product Catalog Management API, version: 2.11.2
- TMF-622: Product Ordering Management API, version: 2.11.2
- TMF-629: Customer Management API, version: 2.11.2
- TMF-632: Party Management API, version: 2.11.2
- TMF-633: Service Catalog Management API, version: 2.11.2
- TMF-634: Resource Catalog Management API, version: 2.11.2
- TMF-637: Product Inventory Management API, version: 2.11.2
- TMF-638: Service Inventory Management API, version: 2.11.2
- TMF-639: Resource Inventory Management API, version: 2.11.2
- TMF-641: Service Ordering Management API, version: 2.11.2
- TMF-648: Quote Management API, version: 2.11.2
- TMF-651: Agreement Management API, version: 2.11.2
- TMF-652: Resource Order Management API, version: 2.11.2
- TMF-658: Loyalty, version: 2.11.2
- TMF-663: Shopping Cart Management API, version: 2.11.2
- TMF-666: Account Management API, version: 2.11.2
- TMF-667: Document Management API, version: 2.11.2
- TMF-668: Partnership Type, version: 2.11.2
- TMF-669: Party Role Management API, version: 2.11.2
- TMF-670: Payment Method Management API, version: 2.11.2
- TMF-671: Promotion Management API, version: 2.11.2
- TMF-673: Geographic Address Management API, version: 2.11.2
- TMF-676: Payment Management API, version: 2.11.2
- TMF-681: Communication Management API, version: 2.11.2
- TMF-683: Party Interaction Management API, version: 2.11.2

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-common-v4-model</artifactId>
    <version>2.11.2</version>
</dependency>
```

For JSON polymorphism, register `TmfCommonJacksonConfig` on your `JsonMapper` (see root README).
