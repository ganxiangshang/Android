package com.example.java_module.enum_test;

public class JudgeRole {

    public static String judge(String roleName){

        System.out.println("======RoleEnum.valueOf(roleName).op()==" + RoleEnum.valueOf(roleName).op());

        return RoleEnum.valueOf(roleName).op();
    }

    public static void main(String[] args) {

        System.out.println("======RoleEnum.ROLE_NORMAL.name()==" + RoleEnum.ROLE_NORMAL.name());

        judge(RoleEnum.ROLE_NORMAL.name());

    }


}
