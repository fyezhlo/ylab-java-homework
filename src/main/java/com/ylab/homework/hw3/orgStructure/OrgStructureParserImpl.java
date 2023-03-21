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
        List<Employee> employees;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
             employees = getListOfEmployees(br, ";");
        }
        return employees.stream()
                .filter(e -> e.getBossId() == null)
                .findAny()
                .get();
    }

    private List<Employee> getListOfEmployees(BufferedReader br, String COMMA_DELIMITER) {
        List<Employee> employees = br.lines()
                .skip(1)
                .map(line -> line.split(COMMA_DELIMITER))
                .map(arr -> { //Stream of arrays, each array contains values from one line in .csv file
                    Employee e = new Employee();
                    e.setId(Long.valueOf(arr[0]));
                    if (arr[1] == ""){
                        e.setBossId(null);
                    } else {
                        e.setBossId(Long.valueOf(arr[1]));
                    }
                    e.setName(arr[2]);
                    e.setPosition(arr[3]);
                    return e;})
                .collect(toList());

        for (var employee : employees) {
            employee.setBoss(
                    employees.stream()
                            .filter(e -> e.getBossId() == employee.getBossId())
                            .findAny()
                            .get()
            );

            employee.getSubordinate().addAll(
                    employees.stream()
                            .filter(e -> e.getBossId() == employee.getId())
                            .collect(toList())
            );
        }

        return employees;
    }
}
