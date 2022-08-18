package com.silascodingchallenges.challenges;

public class PigLatin {
    public StringBuilder encode(String line) {
        StringBuilder encodedString = new StringBuilder("");
        int lastIndex = line.length() - 1;
        Boolean hasEndPunctuation = false;
        char punctuation = '\0';

        if (line.charAt(lastIndex) == '.'
        || line.charAt(lastIndex) == '?'
        || line.charAt(lastIndex) == '!') {
            punctuation = line.charAt(lastIndex);
            line = line.substring(0, lastIndex);
            hasEndPunctuation = true;
        }

        String[] words = line.split(" ");
        
        for(String word: words)  {
            if(word.contains(".")
            || word.contains(",")
            || word.contains(";")
            || word.contains("-")
            || word.contains("?")
            || word.contains("!")) {
                StringBuilder invalid = new StringBuilder("Invalid Input");
                return invalid;
            }
                
            encodedString.append(" " + word.substring(1).concat(word.charAt(0) + "ay"));
        } 
        
        encodedString.deleteCharAt(0);
        if(hasEndPunctuation) {
            encodedString.append(punctuation);
        }
        return encodedString;
    }
}
