import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AnagramSorter {

    public static void main(String[] args) {
        // set up the input and output file names
        String[] listA = null;
        String inputFile = null;
        String outputFile = null;
        Scanner scan = new Scanner(System.in);

        try {
            // Prompt user for input file name
            System.out.println("Enter an inputFile: ");
            inputFile = scan.next();

            // Read words from the input file
            listA = readWordsFromFile(inputFile);
            System.out.println("______________________");
            System.out.println("The words imported from the file " + inputFile);
            System.out.println(Arrays.toString(listA));
            System.out.println("______________________\n");

            // Sort words in 1D array and print sorted words
            if (listA != null) {
                mergeSort(listA, 0, listA.length - 1);
                System.out.println("______________________");
                System.out.println("The sorted words from the file " + inputFile + ":");
                for (String word : listA) {
                    System.out.println(word);
                }
                System.out.println("______________________\n");
            }

            // Find anagrams and print anagram groups
            LinkedList<String>[] anagramGroups = findAnagramGroups(listA);
            System.out.println("Anagram groups found: " + anagramGroups.length);
            for (LinkedList<String> group : anagramGroups) {
                System.out.println(group);
            }

            // Prompt user for output file name
            System.out.println();
            System.out.println("Enter the outputFile: ");
            outputFile = scan.next();

            // Write anagram groups to the output file
            if (outputFile != null) {
                writeAnagramGroupsToFile(anagramGroups, outputFile);
                System.out.println();
                System.out.println("Data has been saved to the output file: " + outputFile);
            }

        } catch (IOException e) {
            System.out.println("An error occurred with file operations.");
            e.printStackTrace();
        } finally {
            scan.close();
        }
    }

    //TODO-1 (return type)
    // TODO-3
    // Read words from a file and return them as an array of strings
    static String[] readWordsFromFile(String fileName) throws IOException {
        ArrayList<String> wordList = new ArrayList<>();

        // Read words from the file and add them to the list
        try (BufferedReader buffered_reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = buffered_reader.readLine()) != null) {
                wordList.add(line);
            }
        } catch (IOException e) {
            throw e;
        }

        return wordList.toArray(new String[0]);
    }

    // TODO-5
    // Sort the characters of a word
    static String sortWord(String word){
        String[] indivWord = word.split("");
        mergeSort(indivWord, 0, indivWord.length - 1);
        String processedWord = String.join("", indivWord);
        processedWord = processedWord.replaceAll("\\d", "");
        return processedWord;
    }

    // Recursively split the array and then merge
    static void mergeSort(String[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Merge two subarrays of array[]
    static void merge(String[] array, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        /* Create temp arrays */
        String[] L = new String[n1];
        String[] R = new String[n2];

        /*Copy data to temp arrays*/
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, middle + 1, R, 0, n2);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // TODO-4
    static LinkedList<String>[] findAnagramGroups(String[] words) {
        Arrays.sort(words, Comparator.comparing(AnagramSorter::sortWord));
    
        // Declare listB as a list of LinkedLists large enough to store all anagrams
        ArrayList<LinkedList<String>> listB = new ArrayList<>();
    
        // Iterate through the sorted words
        for (String word : words) {
            String sortedWord = sortWord(word);
            boolean isAdded = false;
    
            // Search for an existing anagram group for the sorted word
            for (LinkedList<String> group : listB) {
                if (sortWord(group.peek()).equals(sortedWord)) {
                    group.add(word);
                    isAdded = true;
                    break;
                }
            }
    
            // If the word doesn't fit in any existing group, create a new one
            if (!isAdded) {
                LinkedList<String> newGroup = new LinkedList<>();
                newGroup.add(word);
                listB.add(newGroup);
            }
        }
    
        // Sort the listB based on the natural order of the first word in each group
        listB.sort(Comparator.comparing(group -> group.peek()));
    
        // Convert the listB to an array of LinkedLists
        @SuppressWarnings("unchecked")
        LinkedList<String>[] anagramGroups = new LinkedList[listB.size()];
        anagramGroups = listB.toArray(anagramGroups);
    
        return anagramGroups;
    }

    // TODO-6
    // Write anagram groups to a file
    static void writeAnagramGroupsToFile(LinkedList<String>[] anagramGroups, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write each anagram group to the file
            for (LinkedList<String> group : anagramGroups) {
                String joinedGroup = String.join(" ", group);
                writer.write(joinedGroup);
                writer.newLine();
            }
        }
    }
}