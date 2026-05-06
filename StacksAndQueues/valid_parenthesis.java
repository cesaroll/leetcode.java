import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

class valid_parenthesis {

    public static void main(String[] args) {

        System.out.println("Stack:");

        System.out.println(matching_parenthesis("{}[]()"));
        System.out.println(matching_parenthesis("{}[]("));
        System.out.println(matching_parenthesis("{([]){}}"));

    }

    static boolean matching_parenthesis(String parenthesis) {

        var matching = new HashMap<Character, Character>();
        matching.put('(', ')');
        matching.put('[', ']');
        matching.put('{', '}');

        // var stack = new Stack<Character>();
        var stack = new ArrayDeque<Character>();

        for (int i=0; i < parenthesis.length(); i++) {
            var c = parenthesis.charAt(i);

            if (matching.containsKey(c))
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                var prevOpennnig = stack.pop();

                if (matching.get(prevOpennnig) != c)
                    return false;
            }

        }

        return stack.isEmpty();
    }


}