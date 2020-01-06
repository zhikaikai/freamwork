package com.hogae.cms.dao;

import java.sql.JDBCType;
import java.util.Date;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MenuDynamicSqlSupport {

public static final Menu menu = new Menu();


public static final SqlColumn
<String> id = menu.id;


    public static final SqlColumn
    <String> name = menu.name;


        public static final SqlColumn
        <String> url = menu.url;


            public static final SqlColumn
            <Integer> level = menu.level;


                public static final SqlColumn
                <String> memo = menu.memo;


                    public static final SqlColumn
                    <Date> createTime = menu.createTime;


                        public static final SqlColumn
                        <Date> updateTime = menu.updateTime;


                            public static final class Menu extends SqlTable {
                            public final SqlColumn
                            <String> id = column("_id", JDBCType.VARCHAR);

                                public final SqlColumn
                                <String> name = column("name", JDBCType.VARCHAR);

                                    public final SqlColumn
                                    <String> url = column("url", JDBCType.VARCHAR);

                                        public final SqlColumn
                                        <Integer> level = column("level", JDBCType.INTEGER);

                                            public final SqlColumn
                                            <String> memo = column("memo", JDBCType.VARCHAR);

                                                public final SqlColumn
                                                <Date> createTime = column("create_time", JDBCType.TIMESTAMP);

                                                    public final SqlColumn
                                                    <Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

                                                        public Menu() {
                                                        super("cms_menu");
                                                        }
                                                        }
                                                        }