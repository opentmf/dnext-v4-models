# dnext-partner-v4-model

Shared **model** types for the **Partner** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

- TMF-632: Party Management API, version: 2.12.1
- TMF-651: Agreement Management API, version: 2.12.1
- TMF-666: Account Management API, version: 2.12.1
- TMF-668: Partnership Type, version: 2.12.1
- TMF-669: Party Role Management API, version: 2.12.1
- TMF-683: Party Interaction Management API, version: 2.12.1

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-partner-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

For JSON polymorphism, register `TmfPartnerJacksonConfig` on your `JsonMapper` (see root README).
