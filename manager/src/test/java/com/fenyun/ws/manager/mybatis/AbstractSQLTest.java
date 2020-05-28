package com.fenyun.ws.manager.mybatis;

import org.junit.Test;
import test.mapper.SysUserMapperTest;

import static org.junit.Assert.*;

public class AbstractSQLTest extends SysUserMapperTest {

    @Test
    public void getSelf() {
        System.out.println(example2("3","2","1"));
    }

    private static String example2(final String id, final String firstName, final String lastName) {
        return new SQL() {{
            SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
            FROM("PERSON P");
            if (id != null) {
                WHERE("P.ID like #id#");
            }
            if (firstName != null) {
                WHERE("P.FIRST_NAME like #firstName#");
            }
            if (lastName != null) {
                WHERE("P.LAST_NAME like #lastName#");
            }
            ORDER_BY("P.LAST_NAME");
        }}.toString();
    }
}