# dnext-637-v4-model

**TMF-637 Product Inventory Management API** — concrete model classes implementing the `I*` API from **dnext-637-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-637-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

Call `Tmf637JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
