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

    Student's full name: ___________________________________

    Student's UCID: _______________

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

    // This function should add a word to the binary search tree and return the frequency of that word in the binary search tree
    int addWord(String word){
        // TODO-3
        /*
            If word is equal to current node's word:
                Update the current node's frequency.

            If word is less thatn current node's word:
                Add word to the left sub-tree.

            If word is greater than current node's word:
                Add word to the right sub-tree.

            Also, you should return the frequency of the word in the tree.
        */
    }

    // This function should pre-order traverse the binary search tree and print out the words in the tree based on that order
    void preOrderTraversal(){
        // TODO-4
        /*
            Step 1. Process the current node.
            Step 2. Process the left sub-tree.
            Step 3. Process the left sub-tree.
        */
    }

    // This function should in-order traverse the binary search tree and print out the words in the tree based on that order
    void inOrderTraversal(){
        // TODO-5
        /*
            Step 1. Process the left sub-tree.
            Step 2. Process the current node.
            Step 3. Process the left sub-tree.
        */
    }

    // This function should post-order traverse the binary search tree and print out the words in the tree based on that order
    void postOrderTraversal(){
        // TODO-6
        /*
            Step 1. Process the left sub-tree.
            Step 2. Process the left sub-tree.
            Step 3. Process the current node.
        */
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
        /*
            What is wordFrequency?
            Is it possible that wordFrequency be 0?
            What does it mean if wordFrequency is 1? How should we update totalNumberOfWords and numberOfUniqueWords in this case?
            What does it mean if wordFrequency is 2? How should we update totalNumberOfWords and numberOfUniqueWords in this case?
            What does it mean if wordFrequency is greater than maximumFrequency?
        */
    }

    // This function pre-order traversing the binary search tree
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

        // Create an instance of "BinarySearchTree" class
        BinarySearchTree bst = new BinarySearchTree();

        // Add words to the tree
        for(int i = 0; i < words.size(); i++){
            bst.addWord(words.get(i));
        }

        System.out.println("Total number of words in " + fileName + " = " + bst.totalNumberOfWords);
        System.out.println();
        System.out.println("Number of unique words in " + fileName + " = " + bst.numberOfUniqueWords);
        System.out.println();
        System.out.println("The word(s) which occur(s) most often and the number of times that it/they occur(s) =");
        for(int i = 0; i < bst.maximumFrequencyWords.size(); i++){
            System.out.println(bst.maximumFrequencyWords.get(i) + " = " + bst.maximumFrequency + "times");
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
    static ArrayList<String> readWordsFromFile(String fileName){
        // TODO-1
        /*
            Similar to the function you implemented in the previous assignment.
            But, here words are separated by white whitespace in the file instead of newline.​
        */
    }

}
