/*
    Here is the code skeleton for the third programming assignment.
    Complete the missing parts according to the PA-3 specs.

    TODOs:
        (1) Complete the "readWordsFromFile" function to read words from the file.
        (2) Update "totalNumberOfWords", "numberOfUniqueWords", "maximumFrequency", and "maximumFrequencyWords".
        (3) Complete the "BinarySearchTreeNode.addWord" function to add a word to the binary search tree.
        (4) Complete the "BinarySearchTreeNode.preOrderTraversal" function to pre-order traverse the binary search tree.
        (5) Complete the "BinarySearchTreeNode.inOrderTraversal" function to in-order traverse the binary search tree.
        (6) Complete the "BinarySearchTreeNode.postOrderTraversal" function to post-order traverse the binary search tree.

    Make sure you *understand* the algorithms and implement the missing parts on *your own*.
    Comment every line of code, clearly describing what is going on, and the rationale for your choices.
    "" DO NOT CHANGE THE REST OF THE SKELETON CODE ""

====================================================================================

    Student's full name: Omar Ahmed

    Student's UCID: 30154382

====================================================================================
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


// Binary search tree node class
class BinarySearchTreeNode {
    String word; // The word that each node store
    int frequency; // The frequency of the stored word
    BinarySearchTreeNode leftNode, rightNode; // The left and right nodes
    // The right sub-tree should consist of words greater than the current node word
    // The left sub-tree should consist of words smaller than the current node word

    // Constructor
    BinarySearchTreeNode(String word){
        this.word = word;
        this.frequency = 1;
        this.leftNode = null;
        this.rightNode = null;
    }

    // don't touch anything above this line, start here
    // This function should add a word to the binary search tree and return the frequency of that word in the binary search tree
    // change as much as I like
    // TODO-3
    int addWord(String word){
        // If the word is the same as this node's word, increment the frequency.
        if (this.word.equals(word)) {
            this.frequency++;
            return this.frequency;
        }
        // If the word is less than this node's word, go to the left subtree.
        else if (word.compareTo(this.word) < 0) {
            if (this.leftNode == null) {
                this.leftNode = new BinarySearchTreeNode(word);
                return this.leftNode.frequency; // New word, so frequency is 1
            } else {
                return this.leftNode.addWord(word); // Recursively add the word to the left subtree
            }
        }
        // If the word is greater than this node's word, go to the right subtree.
        else {
            if (this.rightNode == null) {
                this.rightNode = new BinarySearchTreeNode(word);
                return this.rightNode.frequency; // New word, so frequency is 1
            } else {
                return this.rightNode.addWord(word); // Recursively add the word to the right subtree
            }
        }
    }

    // Method to count unique words in the subtree rooted at this node
    int countUniqueWords() {
        int count = this.frequency == 1 ? 1 : 0; //if the frequency is 1, then the word is unique
        if (this.leftNode != null) { // Recursively count the unique words in the left subtree
            count += this.leftNode.countUniqueWords();
        }
        if (this.rightNode != null) { // Recursively count the unique words in the right subtree
            count += this.rightNode.countUniqueWords();
        }
        return count;
    }
    

    // This function should pre-order traverse the binary search tree and print out the words in the tree based on that order
    //root, left, right
    // should not take in any parameters
    // TODO-4
    void preOrderTraversal(){
        // 1. process the current node
        System.out.print(this.word + " ");
    
        // 2. process the left sub-tree
        if (this.leftNode != null) {
            this.leftNode.preOrderTraversal();
        }
    
        // 3. process the right sub-tree
        if (this.rightNode != null) {
            this.rightNode.preOrderTraversal();
        }
    }

    // This function should in-order traverse the binary search tree and print out the words in the tree based on that order
    //left, root, right
    // TODO-5
    void inOrderTraversal(){
        // 1. process the left sub-tree
        if (this.leftNode != null) {
            this.leftNode.inOrderTraversal();
        }
    
        // 2. process the current node
        System.out.print(this.word + " ");
    
        // 3. process the right sub-tree
        if (this.rightNode != null) {
            this.rightNode.inOrderTraversal();
        }
    }

    // This function should post-order traverse the binary search tree and print out the words in the tree based on that order
    //left, right, root
    // TODO-6
    void postOrderTraversal(){
        // 1. process the left sub-tree
        if (this.leftNode != null) {
            this.leftNode.postOrderTraversal();
        }
    
        // 2. process the right sub-tree
        if (this.rightNode != null) {
            this.rightNode.postOrderTraversal();
        }
    
        // 3. process the current node
        System.out.print(this.word + " ");
    }

}

// Binary search tree class
class BinarySearchTree {
    // The total number of words in the tree, the number of unique words in the tree, the maximum frequency of a word in the tree
    int totalNumberOfWords, numberOfUniqueWords, maximumFrequency;
    // The list of the words that have maximum frequency among the other words in the tree
    ArrayList<String> maximumFrequencyWords;
    // The root node of the tree
    BinarySearchTreeNode root;

    // Constructor
    BinarySearchTree(){
        this.totalNumberOfWords = 0;
        this.numberOfUniqueWords = 0;
        this.maximumFrequency = 0;
        this.maximumFrequencyWords = new ArrayList<>();
        this.root = null;
    }

    // This function adds a word to the binary search tree
    void addWord(String word){
        int wordFrequency = 0;

        if(this.root == null){
            // This is the case that tree is empty
            this.root = new BinarySearchTreeNode(word);
            wordFrequency = 1;
        }else{
            wordFrequency = this.root.addWord(word);
        }

        // Update internal variables based on "wordFrequency" and "word"
        // TODO-2
        // I want to increment total number of words only if the word is not already in the tree
        // I want to increment number of unique words only if it's frequency is 1
        if (wordFrequency == 1) { 
            this.totalNumberOfWords++;
        }
        if (wordFrequency > this.maximumFrequency) { // If the word has a higher frequency than the current maximum frequency
            this.maximumFrequency = wordFrequency;
            this.maximumFrequencyWords.clear();
            this.maximumFrequencyWords.add(word);
        } else if (wordFrequency == this.maximumFrequency && !this.maximumFrequencyWords.contains(word)) { // Don't add the same word twice
            this.maximumFrequencyWords.add(word);
        }
    }

    // Method to update the numberOfUniqueWords based on the constructed tree
    void updateUniqueWordCount() {
        if (this.root != null) {
            this.numberOfUniqueWords = this.root.countUniqueWords();
        }
    }

    // This function pre-order traversing the binary search tree
    //just call the preOrderTraversal function of the root node, no need to do anything here
    void preOrderTraversal(){
        if(this.root == null){
            // This is the case that tree is empty
            System.out.println("Binary Search Tree is empty.");
        }else{
            this.root.preOrderTraversal();
        }
    }

    // This function in-order traversing the binary search tree
    void inOrderTraversal(){
        if(this.root == null){
            // This is the case that tree is empty
            System.out.println("Binary Search Tree is empty.");
        }else{
            this.root.inOrderTraversal();
        }
    }

    // This function post-order traversing the binary search tree
    void postOrderTraversal(){
        if(this.root == null){
            // This is the case that tree is empty
            System.out.println("Binary Search Tree is empty.");
        }else{
            this.root.postOrderTraversal();
        }
    }

}

public class ProgrammingAssignment3 {
    public static void main(String[] args){
        // This is the input file name
        String fileName = "example01.txt";
        // These are the flags for different types of traverse
        boolean preOrderTraversal = true;
        boolean inOrderTraversal = true;
        boolean postOrderTraversal = true;

        // Read words from the file and store them in a dynamic array of strings
        ArrayList<String> words = readWordsFromFile(fileName);

        // Printing out the words read from the file
        // System.out.println("Words read from " + fileName + ":");
        // for (String word : words) {
        //     System.out.println(word);
        // }
        // System.out.println();

        // Create an instance of "BinarySearchTree" class
        BinarySearchTree bst = new BinarySearchTree();

        // Add words to the tree
        for(int i = 0; i < words.size(); i++){
            bst.addWord(words.get(i));
            //bst.addWord(word.toLowerCase()); // Convert word to lowercase before adding
        }

        // After all words are added, update the count of unique words
        bst.updateUniqueWordCount();

        System.out.println("Total number of words in " + fileName + " = " + bst.totalNumberOfWords);
        System.out.println();
        System.out.println("Number of unique words in " + fileName + " = " + bst.numberOfUniqueWords);
        System.out.println();
        System.out.println("The word(s) which occur(s) most often and the number of times that it/they occur(s) =");
        for(int i = 0; i < bst.maximumFrequencyWords.size(); i++){
            System.out.println(bst.maximumFrequencyWords.get(i) + " = " + bst.maximumFrequency + " times");
        }
        System.out.println();

        // Pre-order traverse
        if(preOrderTraversal == true){
            System.out.println("Pre-order traversal:");
            bst.preOrderTraversal();
            System.out.println();
            System.out.println();
        }

        // In-order traverse
        if(inOrderTraversal == true){
            System.out.println("In-order traversal:");
            bst.inOrderTraversal();
            System.out.println();
            System.out.println();
        }

        // Post-order traverse
        if(postOrderTraversal == true){
            System.out.println("Post-order traversal:");
            bst.postOrderTraversal();
            System.out.println();
            System.out.println();
        }
    }

    // This function should read words from the file and return them as a dynamic array of strings
    // same function as in PA-2
    // TODO-1
    static ArrayList<String> readWordsFromFile(String fileName) {
        ArrayList<String> wordList = new ArrayList<>();
    
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words using space as the delimiter
                String[] words = line.split("\\s+");
                // Add all words to the wordList
                for (String word : words) {
                    if (!word.isEmpty()) { // Check if the word is not empty
                        wordList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file: " + fileName);
            e.printStackTrace();
        }
    
        return wordList;
    }
    
}
