public class GenerateString {

    private String last = null;
    private char[] chars = {'0', '1', '2', '3'};
    private int m = 3;

    public String generate(){
        if (last == null)
            last = "0";
        else if (last.equals("333222111000"))
            return last;
        else{
            char[] arr = last.toCharArray();
            last = incLast(arr);
        }
        return last;
    }

    private String incLast(char[] arr){
        int i = arr.length - 1;
        for (; i >= 0; i--)
            if (arr[i] == '3')
                arr[i] = '0';
            else{
                arr[i] =(char)((int)arr[i] + 1);
//                System.out.println("test..." + arr[i]);
                break;
            }
        if (i < 0)
            return createLast(arr.length + 1);
        else{
            Map<Character, Integer> map = new HashMap<>();
            for (char c : arr)
                map.put(c, map.getOrDefault(c, 0) + 1);
            for (int j : map.values())
                if (j > m)
                    return incLast(arr);
//            System.out.println("test...." + new);
            return new String(arr);
        }
    }

    private String createLast(int n){
        if (n > 12)
            return "333222111000";
        int i = 0;
        String result = "";
        while (n / 3 > 0){
            result += ("" + chars[i] + chars[i] + chars[i]);
            n -= 3;
            i++;
        }
        while (n > 0){
            result += ("" + chars[i]);
            n--;
        }
        return result;
    }
}
