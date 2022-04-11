package huawei;

import java.util.*;

public class Main1 {

    static class Word{
        String word;
        int count = 0;
        int title = 0;
        int content = 0;

        public Word(int count, int title, int content, String word) {
            this.count = count;
            this.title = title;
            this.content = content;
            this.word = word;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Word> map = new HashMap<>();
        TreeSet<Word> dict = new TreeSet<>(new Comparator<Word>() {
            @Override
            public int compare(Word w1, Word w2) {
                if (w1.count != w2.count) return w2.count-w1.count;
                if (w1.title!=w2.title) return w1.title-w2.title;
                return w1.content-w2.content;
            }
        });
        int N = sc.nextInt();
        int M = sc.nextInt();
        int tsIndex = 0;
        int csIndex = 0;
        sc.nextLine();
        for(int i = 0;i<M;++i){
            String title = sc.nextLine();
            String content = sc.nextLine();
            String[] ts = title.split(" ");
            String[] cs = content.split(" ");
            tsIndex += ts.length;
            csIndex += cs.length;
            for (int j = 0; j<ts.length;++j){
                if (!map.containsKey(ts[j])){
                    map.put(ts[j],new Word(0,j,0,ts[j]));
                }
                Word word = map.get(ts[j]);
                if (word.title>j) word.title = j;
                word.count += 3;
                map.put(ts[j],word);
            }
            for (int j = 0; j<cs.length;++j){
                if (!map.containsKey(cs[j])){
                    map.put(cs[j],new Word(0,0,j,cs[j]));
                }
                Word word = map.get(cs[j]);
                word.count += 1;
                if (word.content>j) word.content = j;
                map.put(cs[j],word);
            }
        }
        for (Map.Entry<String, Word> entry :map.entrySet()){
            dict.add(entry.getValue());
        }

        int i = 0;
        for(Word word : dict){
            if (i == 0) System.out.print(word.word);
            else{
                System.out.print(" " + word.word);
            }
            i++;
            if (i >= N) break;
        }
    }
}
