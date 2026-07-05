/* Package Specification */

CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_employeeId NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2,
        p_hireDate DATE
    );

    PROCEDURE UpdateEmployee(
        p_employeeId NUMBER,
        p_salary NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_employeeId NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/