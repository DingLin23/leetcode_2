// Description:
// Implement a function to return product suggestions using products from a product repository after each character is typed by the customer in the search bar.
// If there are more than THREE acceptable products, return the product name that is first in the alphabetical order.
// Only return product suggestions after the customer has entered two characters.
// Product suggestions must start with the characters already typed.
// Both the repository and the customer query should be compared in a CASE-INSENSITIVE way.

// Input:
// The input to the method/function consist of three arguments:

// numProducts, an integer representing the number of various products in Amazon's product repository;
// repository, a list of unique strings representing the various products in Amazon's product repository;
// customerQuery, a string representing the full search query of the customer.
// Output:
// Return a list of a list of strings, where each list represents the product suggestions made by the system as the customer types each character of the customerQuery. Assume the customer types characters in order without deleting/removing any characters.

// Example:
// Input:
// numProducts = 5
// repository = ["mobile", "mouse", "moneypot", "monitor", "mousepad"]
// customerQuery = "mouse"

// Output:
// [["mobile", "moneypot", "monitor"],
// ["mouse", "mousepad"],
// ["mouse", "mousepad"],
// ["mouse", "mousepad"]]

// Explanation:
// The chain of words that will generate in the search box will be mo, mou, mous and mouse, and each
// line from output shows the suggestions of "mo", "mou", "mous" and "mouse", respectively in each line.
// For the suggestions that are generated for "mo", the matches that will be generated are:
// ["mobile", "mouse", "moneypot", "monitor", "mousepad"]. Alphabetically, they will be reordered to
// ["mobile", "moneypot", "monitor", "mouse", "mousepad"]. Thus, the suggestions are ["mobile", "moneypot", "monitor"]
/*
Idea:
1. Create a Trie (using the repository) where each TrieNode stores a map associating lowercase characters
to children TrieNodes, and a priority queue storing products from the repository in reverse alphabetical order.
2. Call getTopKProducts(~) for all prefixes of customerQuery except the prefix with only the first character.

Complexity: Let N = numProducts, L = the average length of products, LCQ = the length of customerQuery,
Time: O(N * L + LCQ^2)
O(N * L) is for building the Trie.
O(LCQ^2) is for performning LCQ getTopKProducts(~) where the first takes O(2) and the last takes O(LCQ - 1).

Space: O(N * L * L + N * L * LCQ)
O(N * L * L) is for the Trie as there are at most N * L TrieNodes and each TrieNode
stores a pq with at most 3 products, which is O(3 * L) = O(L).
O(N * L * LCQ) is for the result since it could be a list of LCQ sublists, each of which has N strings of length L.
*/
public class SearchSuggestion {
    public static void main(String[] args) {
        int numProducts = 5;
        List<String> repository = Arrays.asList(new String[] {"mOBILE", "MouSE", "MoNEYPOT", "mONITOR", "MOUSEPAD"});
        String userInput = "MoUSe";
        
        SearchSuggestion searchSuggestion = new SearchSuggestion();
        List<List<String>> result = searchSuggestion.suggestProducts(5, repository, userInput);
        System.out.println(result);
    }
    public List<List<String>> suggestProducts(int numProducts, List<String> repository, String customerQuery) {
        if (customerQuery == null || customerQuery.length() < 2) {
            return Collections.emptyList();
        }

        TrieNode root = buildTrie(repository, 3);

        List<List<String>> result = new ArrayList<>(); // Time: O(LCQ^2), Space: O(N * L * LCQ)
        for (int i = 1; i < customerQuery.length(); i++) {
            result.add(getTopKProducts(root, customerQuery.substring(0, i + 1), 3));
        }

        return result;
    }

    private List<String> getTopKProducts(TrieNode root, String prefix, int k) {
        List<String> products = new LinkedList<>();

        TrieNode parent = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = Character.toLowerCase(prefix.charAt(i)); // comparison is case-insensitive

            TrieNode child = parent.children.get(c);
            if (child == null) { // null if 'prefix' is way too long or 'prefix' doesn't appear in the Trie
                return Collections.emptyList();
            }

            parent = child;
        }

        Queue<String> topProducts = parent.topProducts;
        for (int i = 0; !topProducts.isEmpty() && i < k; i++) {
            products.add(0, topProducts.poll());
        }

        for (String product : products) { // Put the top k products back to the pq
            parent.topProducts.offer(product);
        }

        return products;
    }

    private TrieNode buildTrie(List<String> repository, int k) { // Time: O(N * L), Space: O(N * L * L)
        TrieNode root = new TrieNode();
        if (repository == null || repository.isEmpty()) {
            return root;
        }

        for (String product : repository) { // Build Trie using the repository
            if (product == null) {
                continue;
            }

            TrieNode parent = root;
            for (int i = 0; i < product.length(); i++) {
                char c = Character.toLowerCase(product.charAt(i)); // comparison is case-insensitive

                TrieNode child = parent.children.get(c);
                if (child == null) {
                    child = new TrieNode();
                    parent.children.put(c, child);
                }

                child.topProducts.offer(product); // storing products at each TrieNode in O(1)
                if (child.topProducts.size() > k) { // keep the size of pq small
                    child.topProducts.poll();
                }

                parent = child; // Navigate to next level
            }
        }

        return root;
    }

    /**
     * TrieNode has
     * 1. a priority queue storing products sorted in reverse alphabetical order
     * 2. a map associating lowercase characters to TrieNodes
     */
    private class TrieNode {
        Map<Character, TrieNode> children;
        PriorityQueue<String> topProducts;

        TrieNode() {
            children = new HashMap<>();
            topProducts = new PriorityQueue<>((s1, s2) -> s2.toLowerCase().compareTo(s1.toLowerCase())); // comparison is case-insensitive
        }
    }
}