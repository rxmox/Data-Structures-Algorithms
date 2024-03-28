import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnagramSorter {

    // TODO-1 = Data type and return type? = 1 point
    // TODO-2 = Data type and return type? = 1 point
    // TODO-3, TODO-4, TODO-5, TODO-6 = functionality? = 1 point each, total = 4 points

    public static void main(String[] args){
        // Replace the input parameter of 'readWordsFromFile()' with 5 of the required INPUT DATA files
        /* TODO-1 (data type) */ words = readWordsFromFile("INPUT-DATA-1--with-8_words.txt");

        /* TODO-2 (data type) */ anagramGroups = findAnagramGroups(words);

        // Replace the input parameter of 'writeAnagramGroupsToFile()' with 5 of the required OUTPUT DATA files
        writeAnagramGroupsToFile(anagramGroups, "OUTPUT-DATA-1.txt");
    }

    static /* TODO-1 (return type) */ readWordsFromFile(String fileName){
        /* TODO-1 (data type) */ words;

        // TODO-3

        return words;
    }

    static /* TODO-2 (return type) */ findAnagramGroups(/* TODO-1 (data type) */ words){
        /* TODO-2 (data type) */ anagramGroups;

        // TODO-4

        return anagramGroups;
    }

    static String sortWord(String word){

        // TODO-5

    }

    static void writeAnagramGroupsToFile(/* TODO-2 (data type) */ anagramGroups, String fileName){

        // TODO-6

    }
}
