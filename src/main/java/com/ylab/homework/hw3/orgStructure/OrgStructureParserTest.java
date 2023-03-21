package com.ylab.homework.hw3.orgStructure;

import java.io.File;
import java.io.IOException;

public class OrgStructureParserTest {
    public static void main(String[] args) throws IOException {
        OrgStructureParser orgStructureParser = new OrgStructureParserImpl();
        Employee boss = orgStructureParser.parseStructure(new File("src/main/java/com/ylab/homework/hw3/orgStructure/employees.csv"));
        System.out.println(boss);
    }
}
