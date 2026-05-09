# dnext-667-v4-model

**TMF-667 Document Management API** — concrete model classes implementing the `I*` API from **dnext-667-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-667-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

Call `Tmf667JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
