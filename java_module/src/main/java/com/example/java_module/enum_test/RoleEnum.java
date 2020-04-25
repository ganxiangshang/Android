package com.example.java_module.enum_test;

public enum RoleEnum implements RoleOperation {

    ROLE_ROOT_ADMIN{
        @Override
        public String op() {
            return "ROLE_ROOT_ADMIN";
        }
    },

    ROLE_ORDER_ADMIN{
        @Override
        public String op() {
            return "ROLE_ORDER_ADMIN";
        }
    },

    ROLE_NORMAL{
        @Override
        public String op() {
            return "ROLE_NORMAL";
        }
    }

}
