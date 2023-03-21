package com.ylab.homework.hw3.orgStructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class OrgStructureParserImpl implements OrgStructureParser{
    @Override
    public Employee parseStructure(File csvFile) throws IOException {
        Map<Employee, List<Employee>> employeeMap;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
             employeeMap = mapEmployeesFromCsv(br, ";");
        }
        return null;
    }

    private Map<Employee, List<Employee>> mapEmployeesFromCsv(BufferedReader br, String COMMA_DELIMITER) {
        Map<Employee, List<Employee>> employeeMap = br.lines()
                .skip(1)
                .map(line -> line.split(COMMA_DELIMITER))
                .map(arr -> { //Stream of arrays, each array contains values from one line in .csv file
                    Employee employee = new Employee();
                    employee.setId(Long.valueOf(arr[0]));
                    if (arr[1] == ""){
                        employee.setBossId(null);
                    } else {
                        employee.setBossId(Long.valueOf(arr[1]));
                    }
                    employee.setName(arr[2]);
                    employee.setPosition(arr[3]);
                    return employee;})
                .collect(
                        groupingBy(
                                employee -> employee.getBoss() == null ? employee : employee.getBoss()
                        )
                );

        System.out.println(employeeMap);
        for (var entry : employeeMap.entrySet()) {

            entry.getValue();
        }

        return employeeMap;
    }
}
