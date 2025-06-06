class StringProcessor{
    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static int countOccurrences(String text, String sub){
        return text.split(sub,-1).length-1;
    }

    public static String splitAndCapitalize(String str){
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return result.toString().trim();
    }
}