//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {
    public String findOrder(String[] words) {
        // Step 1: Create graph and in-degree array
        Map<Character, List<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Step 2: Build graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean foundOrder = false;

            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree[c2 - 'a']++;
                    foundOrder = true;
                    break;
                }
            }

            // Special case: if w1 is longer and w2 is prefix, invalid input
            if (!foundOrder && w1.length() > w2.length()) {
                return "";
            }
        }

        // Step 3: Perform topological sort (Kahn's algorithm)
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (char c = 'a'; c <= 'z'; c++) {
            if (present[c - 'a'] && indegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char current = queue.poll();
            sb.append(current);

            for (char neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                indegree[neighbor - 'a']--;
                if (indegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all present characters are in result => there's a cycle
        for (char c = 'a'; c <= 'z'; c++) {
            if (present[c - 'a'] && sb.indexOf(String.valueOf(c)) == -1) {
                return "";
            }
        }

        return sb.toString();
    }
}



//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends