class Solution {
    public String mostCommonWord(String paragraph,String[]banned) {
		if(paragraph==null||paragraph.length()==0){
			return "";
		}
		Set<String>bannedWords=new HashSet<>();
		Map<String,Integer>wordCount=new HashMap<>();
        String[] words=paragraph.replaceAll("[^A-Za-z]"," ").toLowerCase().split(" ");
		for(String word:banned) {
			bannedWords.add(word);
		}
        for(String word: words){
			if(!bannedWords.contains(word)){
				wordCount.put(word, wordCount.getOrDefault(word,0)+1);
			}
		}
		String mostCommonWord="";
		for(String word: wordCount.keySet()){
			if(mostCommonWord.equals("")){
				mostCommonWord=word;
			}
			else
			{
				mostCommonWord = wordCount.get(mostCommonWord)>wordCount.get(word)? mostCommonWord:word; 
			}
		}
		return mostCommonWord;
	}
}