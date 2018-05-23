public class WordAbbreviation {

    public List<String> generateAbbreviations(String word){
        List<String> r = new ArrayList<>();
        if (word == null || word.length() == 0)
            return r;
        r.add(word);
        bb(r, word, 0);
        return r;
    }

    private void bb(List<String> r, String word, int start){
        if (start == word.length())
            return;
        for (int i = start; i < word.length(); i++)
            for (int j = 1; j <= word.length() - i; j++){
                String num = Integer.toString(j);
                String abbr = word.substring(0, i) + num + word.substring(i + j);
                r.add(abbr);
                bb(r, abbr, i + num.length() + 1);
            }
        
    }
}
