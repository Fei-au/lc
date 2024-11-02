public class ez14LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        ez14LongestCommonPrefix test = new ez14LongestCommonPrefix();
        String s = test.longestCommonPrefix(strs);
        System.out.println(s);
    }


    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for(int i = 1; i < strs.length; i++){
            String str = strs[i];

            if(common.length() > str.length()){
                String temp = common;
                common = str;
                str = temp;
            }
            int j = 1;
            while(j <= common.length()){
                if(str.indexOf(common.substring(0, j)) != 0){
                    common = common.substring(0, j-1);
                    break;
                }
                j++;
            }
            if(j == 1){
                return "";
            }
        }

        return common;
    }

//    public String longestCommonPrefix(String[] strs) {
//        if(strs.length== 1){
//            return strs[0];
//        }
//        String str = strs[0];
//        for (int i = 1; i < strs.length; i++) {
//            String s = strs[i];
//            if(str.length() == 0){
//                break;
//            }
//            if(s.length() < str.length()){
//                str = str.substring(0,s.length());
//            }
//            for (int j = 0; j < str.length(); j++) {
//                if(str.charAt(j) != s.charAt(j)){
//                    str = str.substring(0,j);
//                    break;
//                }
//            }
//        }
//        return str;
//    }
}
