package com.dyh.test.demo.thirdparty.jyw;

/**
 * description:
 * author: dyh
 * date: 2023/1/9 17:59
 */
public class JywDemo {

    public static void main(String[] args) {
        try {
            //菁优网注册
//            JSONObject jo = new JSONObject();
//
//            jo.put("ApiID", "630ea04a-5dc6-4dd0-9bb9-e9806255dda3");
//            jo.put("ApiPwd", "cd7cc8");
//            jo.put("School", "zhixue");
//            jo.put("UserID", "18600358957");
//            jo.put("UserPwd", "e86beb");
//            jo.put("UserName", "zkhy");
//            jo.put("UserRole", "1");
//            jo.put("UserSex", "1");
//            String json = jo.toString();
//            String eson = DES3.encrypt(json, "c6dcfd230231467b86fd8cd5e869a05e");
//            System.out.println("eson==" + eson);

            //菁优网登录
            String s = String.format("%s#@@#%s#@@#%s", "630ea04a-5dc6-4dd0-9bb9-e9806255dda3",
                    "18600358957", "e86beb");
            String v = DES3.encrypt(s, "c6dcfd230231467b86fd8cd5e869a05e");
            System.out.println("s==" + s );
            System.out.println("v==" + v);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
