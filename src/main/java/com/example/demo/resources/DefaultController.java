package com.example.demo.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class DefaultController {

    private static final String HTML_TEMPLATE =
            """
                    <!DOCTYPE html>
                        <html>
                            <body>
                                <h1>Welcome on %s</h1>
                                <h2>Some useful ENV VARS:</h2>
                                <p>%s</p>
                            </body>
                        </html>
                    """;

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        String hostname = System.getenv("HOSTNAME");
        Map<String, String> otherVars = System.getenv().entrySet().stream().filter(e -> e.getKey().startsWith("GC_") || e.getKey().startsWith("JAVA_")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        StringBuilder sb = new StringBuilder("<ul>\n");
        otherVars.forEach((key, value) -> sb.append("<li>").append("<strong>").append(key).append("</strong>").append(" = ").append(value).append("</li>\n"));
        sb.append("</ul>\n");
        return HTML_TEMPLATE.formatted(hostname, sb);
    }
}
