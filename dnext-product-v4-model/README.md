# dnext-product-v4-model

Shared **model** types for the **Product** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

- TMF-620: Product Catalog Management API, version: 2.12.1
- TMF-637: Product Inventory Management API, version: 2.12.1
- TMF-658: Loyalty, version: 2.12.1
- TMF-671: Promotion Management API, version: 2.12.1

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-product-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

For JSON polymorphism, register `TmfProductJacksonConfig` on your `JsonMapper` (see root README).
