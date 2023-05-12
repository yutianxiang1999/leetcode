package com.leetcode.part734;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test1_1 = {"one","excellent","meal"};
        String[] test1_2 = {"one","good","dinner"};
        List<List<String>> test1_3 = new ArrayList<>();
        test1_3.add(Arrays.asList("great", "good"));
        test1_3.add(Arrays.asList("extraordinary", "good"));
        test1_3.add(Arrays.asList("well", "good"));
        test1_3.add(Arrays.asList("wonderful", "good"));
        test1_3.add(Arrays.asList("excellent", "good"));
        test1_3.add(Arrays.asList("fine", "good"));
        test1_3.add(Arrays.asList("nice", "good"));
        test1_3.add(Arrays.asList("any", "one"));
        test1_3.add(Arrays.asList("some", "one"));
        test1_3.add(Arrays.asList("unique", "one"));
        test1_3.add(Arrays.asList("the", "one"));
        test1_3.add(Arrays.asList("an", "one"));
        test1_3.add(Arrays.asList("single", "one"));
        test1_3.add(Arrays.asList("a", "one"));
        test1_3.add(Arrays.asList("truck", "car"));
        test1_3.add(Arrays.asList("wagon", "car"));
        test1_3.add(Arrays.asList("automobile", "car"));
        test1_3.add(Arrays.asList("auto", "car"));
        test1_3.add(Arrays.asList("vehicle", "car"));
        test1_3.add(Arrays.asList("entertain", "have"));
        test1_3.add(Arrays.asList("drink", "have"));
        test1_3.add(Arrays.asList("eat", "have"));
        test1_3.add(Arrays.asList("take", "have"));
        test1_3.add(Arrays.asList("fruits", "meal"));
        test1_3.add(Arrays.asList("brunch", "meal"));
        test1_3.add(Arrays.asList("breakfast", "meal"));
        test1_3.add(Arrays.asList("food", "meal"));
        test1_3.add(Arrays.asList("dinner", "meal"));
        test1_3.add(Arrays.asList("super", "meal"));
        test1_3.add(Arrays.asList("lunch", "meal"));
        test1_3.add(Arrays.asList("possess", "own"));
        test1_3.add(Arrays.asList("keep", "own"));
        test1_3.add(Arrays.asList("have", "own"));
        test1_3.add(Arrays.asList("extremely", "very"));
        test1_3.add(Arrays.asList("actually", "very"));
        test1_3.add(Arrays.asList("really", "very"));
        test1_3.add(Arrays.asList("super", "very"));

        boolean res1 = solution.areSentencesSimilar(test1_1, test1_2, test1_3);
        System.out.println(res1);
    }

    /**
     * 我们可以将一个句子表示为一个单词数组，例如，句子 "I am happy with leetcode" 可以表示为 arr = ["I","am",happy","with","leetcode"]
     * 给定两个句子 sentence1 和 sentence2 分别表示为一个字符串数组，并给定一个字符串对 similarPairs ，其中 similarPairs[i] = [xi, yi] 表示两个单词 xi and yi 是相似的。
     * 如果 sentence1 和 sentence2 相似则返回 true ，如果不相似则返回 false 。
     * 两个句子是相似的，如果:
     * 它们具有 相同的长度 (即相同的字数)
     * sentence1[i] 和 sentence2[i] 是相似的
     * 请注意，一个词总是与它自己相似，也请注意，相似关系是不可传递的。例如，如果单词 a 和 b 是相似的，单词 b 和 c 也是相似的，那么 a 和 c  不一定相似 。
     * 示例 1:
     * 输入: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"], similarPairs = [["great","fine"],["drama","acting"],["skills","talent"]]
     * 输出: true
     * 解释: 这两个句子长度相同，每个单词都相似。
     */

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        Set<String> pairset = new HashSet<>();
        for (List<String> pair: similarPairs)
            pairset.add(pair.get(0) + "#" + pair.get(1));

        for (int i = 0; i < sentence1.length; ++i) {
            if (!sentence1[i].equals(sentence2[i]) &&
                    !pairset.contains(sentence1[i] + "#" + sentence2[i]) &&
                    !pairset.contains(sentence2[i] + "#" + sentence1[i]))
                return false;
        }
        return true;
    }
}
