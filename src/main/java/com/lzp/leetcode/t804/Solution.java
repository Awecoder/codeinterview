package com.lzp.leetcode.t804;

import java.util.TreeSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] trans = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        for(String word : words){
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                res.append(trans[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }
}