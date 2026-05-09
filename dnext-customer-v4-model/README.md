# dnext-customer-v4-model

Shared **model** types for the **Customer** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

- TMF-622: Product Ordering Management API, version: 2.12.1
- TMF-629: Customer Management API, version: 2.12.1
- TMF-648: Quote Management API, version: 2.12.1
- TMF-663: Shopping Cart Management API, version: 2.12.1
- TMF-670: Payment Method Management API, version: 2.12.1
- TMF-676: Payment Management API, version: 2.12.1

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-customer-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

For JSON polymorphism, register `TmfCustomerJacksonConfig` on your `JsonMapper` (see root README).
