package org.github.hoorf.ai;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LacRequest {

    private String id;

    private String content;

    public LacRequest(String id, String content) {
        this.id = id;
        this.content = content;
    }
}
