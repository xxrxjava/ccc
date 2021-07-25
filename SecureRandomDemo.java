public class SecureRandomDemo {
    private static final String lowStr = "abcdefghijklmnopqrstuvwxyz";
    private static final String specialStr = "~!@#$%^&*()_+/-=[]{};:'<>?.";
    private static final String numStr = "0123456789";

    // 随机获取字符串字符
    private static char getRandomChar(String str) {
        java.security.SecureRandom random = new java.security.SecureRandom();
        return str.charAt(random.nextInt(str.length()));
    }

    // 随机获取小写字符
    private static char getLowChar() {
        return getRandomChar(lowStr);
    }

    // 随机获取大写字符
    private static char getUpperChar() {
        return Character.toUpperCase(getLowChar());
    }

    // 随机获取数字字符
    private static char getNumChar() {
        return getRandomChar(numStr);
    }

    // 随机获取特殊字符
    private static char getSpecialChar() {
        return getRandomChar(specialStr);
    }

    //指定调用字符函数
    private static char getRandomChar(int funNum) {
        switch (funNum) {
            case 0:
                return getLowChar();
            case 1:
                return getUpperChar();
            case 2:
                return getNumChar();
            default:
                return getSpecialChar();
        }
    }

    // 指定长度，随机生成复杂密码
    private static String getRandomPwd(int num) {
        if (num > 20 || num < 8) {
            System.out.println("长度不满足要求");
            return "";
        }
        List<Character> list = new ArrayList<>(num);
        list.add(getLowChar());
        list.add(getUpperChar());
        list.add(getNumChar());
        list.add(getSpecialChar());

        for (int i = 4; i < num; i++) {
            java.security.SecureRandom random = new java.security.SecureRandom();
            int funNum = random.nextInt(4);
            list.add(getRandomChar(funNum));
        }

        Collections.shuffle(list);   // 打乱排序
        StringBuilder stringBuilder = new StringBuilder(list.size());
        for (Character c : list) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    // 测试函数入口
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int num = 10;
            System.out.println(getRandomPwd(num));
        }
    }

}
