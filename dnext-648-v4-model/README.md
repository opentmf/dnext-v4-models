# dnext-648-v4-model

**TMF-648 Quote Management API** — concrete model classes implementing the `I*` API from **dnext-648-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-648-v4-model</artifactId>
    <version>2.11.2</version>
</dependency>
```

Call `Tmf648JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
