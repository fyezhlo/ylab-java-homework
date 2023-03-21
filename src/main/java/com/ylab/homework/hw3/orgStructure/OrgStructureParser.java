package com.ylab.homework.hw3.orgStructure;

import java.io.File;
import java.io.IOException;

public interface OrgStructureParser {
    public Employee parseStructure(File csvFile) throws IOException;
}
