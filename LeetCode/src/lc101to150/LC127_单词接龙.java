package lc101to150;

import java.util.*;

public class LC127_单词接龙 {
    /*
    1 <= beginWord.length <= 10
    endWord.length == beginWord.length
    1 <= wordList.length <= 5000
    wordList[i].length == beginWord.length
    beginWord、endWord 和 wordList[i] 由小写英文字母组成
    beginWord != endWord
    wordList 中的所有字符串 互不相同*/

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. 将wordList中的word加入Set，便于后面比对
        Set<String> wordSet = new HashSet<>();
        for(String word : wordList){
            wordSet.add(word);
        }
        if (wordSet.size()==0 || !wordSet.contains(endWord)) return 0;
        //wordSet.remove(beginWord);
        // 第 2 步：图的广度优先遍历，使用队列和表示是否访问过的 visited 哈希表
        Queue<String> nextWordQueue = new LinkedList<>();
        nextWordQueue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!nextWordQueue.isEmpty()){
            int size = nextWordQueue.size();
            for(int i = 0; i<size; ++i){
                String curWord = nextWordQueue.poll();
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeOneLetter(curWord, endWord, nextWordQueue, visited, wordSet)) {
                    return step + 1;
                }
            }
            ++step;
        }
        return 0;
    }

    private boolean changeOneLetter(String curWord, String endWord, Queue<String> nextWordQueue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = curWord.toCharArray();
        for(int i = 0; i<curWord.length(); ++i){
            char originChar = charArray[i];
            for(char k = 'a'; k<='z';++k){
                if(k==originChar) continue;
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if(wordSet.contains(nextWord)){
                    if(nextWord.equals(endWord)) return true;
                    if(!visited.contains(nextWord)){
                        nextWordQueue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }
}
