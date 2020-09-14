public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> q = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            q.addLast(word.charAt(i));
        }
        return q;
    }

    public boolean isPalindrome(String word){
        Deque<Character> q = wordToDeque(word);
        while (q.size() > 1) {
            if (q.removeFirst() != q.removeLast()){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> q = wordToDeque(word);
        while (q.size() > 1) {
            if (!cc.equalChars(q.removeFirst(), q.removeLast())){
                return false;
            }
        }
        return true;
    }
}
