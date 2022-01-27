package org.github.hoorf.ai;

import lombok.Data;

import java.util.List;

@Data
public class LacResponse {
    private String id;
    private String content;
    private List<Integer> rank;
    private List<String> tags;
    private List<String> keywords;
}
