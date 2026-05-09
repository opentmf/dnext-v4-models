# dnext-681-v4-model

**TMF-681 Communication Management API** — concrete model classes implementing the `I*` API from **dnext-681-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-681-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

Call `Tmf681JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
