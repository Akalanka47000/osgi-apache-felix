package dictionary.service;

public class DictionaryServiceImpl implements DictionaryService {
    String [] m_dictionary = { "welcome", "to", "the", "osgi", "tutorial" };

    public boolean checkWord(String word) {
        word = word.toLowerCase();
        for (int i =0; i< m_dictionary.length; i++) {
            if (m_dictionary[i].equals(word)) {
                return true;
            }
        }
        return false;
    }
}
