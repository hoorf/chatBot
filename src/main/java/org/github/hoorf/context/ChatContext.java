package org.github.hoorf.context;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.github.hoorf.ai.LacResponse;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ChatContext {

    private List<Pair<String, String>> keyContent;

    private List<String> says;

    public void run() {
        //输入语句
    }

    public List<String> input(LacResponse response) {
        return new Node(response).focusOn();
    }

    @Data
    class Node {
        private String id;
        private String content;
        private List<Triple<String, Integer, Integer>> ik;

        public Node(LacResponse response) {
            this.id = response.getId();
            this.content = response.getContent();
            ik = Lists.newArrayList();
            for (int i = 0; i < response.getKeywords().size(); i++) {
                ik.add(new ImmutableTriple(response.getKeywords().get(i), response.getRank().get(i), i));
            }
        }

        public List<String> focusOn() {
            List<String> result = Lists.newArrayList();
            Comparator<Triple<String, Integer, Integer>> comparator = (o1, o2) -> {
                if (!o1.getMiddle().equals(o2.getMiddle())) {
                    return o2.getMiddle() - o1.getMiddle();
                } else {
                    return o1.getRight() - o2.getRight();
                }
            };
            PriorityQueue<Triple<String, Integer, Integer>> queue = new PriorityQueue<>(comparator);
            queue.addAll(ik);

            Triple<String, Integer, Integer> prev = queue.poll();
            result.add(prev.getLeft());
            int count = 2;
            while (!queue.isEmpty() && count > 0) {
                Triple<String, Integer, Integer> current = queue.poll();
                if (!prev.getMiddle().equals(current.getMiddle())) {
                    count--;
                }
                result.add(current.getLeft());
                prev = current;
            }
            return result;
        }

        private boolean isN(Triple<String, Integer, String> triple) {
            return "n".equals(triple.getRight());
        }

        private boolean isV(Triple<String, Integer, String> triple) {
            return "v".equals(triple.getRight());
        }
    }
}
