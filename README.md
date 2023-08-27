# SBMS-REST-Producer-Client-Apps-2023
SBMS-REST-Producer-Client-Apps-2023

**************************************************
      Provider-PostMan-Request URL's:
**************************************************
POST REQ: To Save Employee
http://localhost:8081/api/employees
{
    "employeeName" : "Swamy",
    "employeeSalary" : 56000.00,
    "employeeAddress" : "KNR"
}
__________________________________________________
GET REQ FOR LIST OF EMPLOYEES:
http://localhost:8081/api/employees
__________________________________________________
GET REQ FOR EMPLOYEE BY ID:
http://localhost:8081/api/employees/10
__________________________________________________
DELETE REQ FOR EMPLOYEE BY ID:
http://localhost:8081/api/employees/10
__________________________________________________
PUT REQ: To Update Employee
http://localhost:8081/api/employees
{
    "employeeName" : "Swamy",
    "employeeSalary" : 56000.00,
    "employeeAddress" : "KNR"
}

**************************************************
      Client-PostMan-Request URL's:
**************************************************

POST REQ: To Save Employee
http://localhost:9090/api/employees
{
    "employeeName" : "Swamy",
    "employeeSalary" : 56000.00,
    "employeeAddress" : "KNR"
}
__________________________________________________

GET REQ FOR LIST OF EMPLOYEES:
http://localhost:9090/api/employees
__________________________________________________
GET REQ FOR EMPLOYEE BY ID:
http://localhost:9090/api/employees/10
__________________________________________________
DELETE REQ FOR EMPLOYEE BY ID:
http://localhost:9090/api/employees/10
__________________________________________________
PUT REQ: To Update Employee
http://localhost:9090/api/employees
{
    "employeeName" : "Swamy",
    "employeeSalary" : 56000.00,
    "employeeAddress" : "KNR"
}
