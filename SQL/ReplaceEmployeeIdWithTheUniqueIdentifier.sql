
SELECT b.unique_id, a.name 
FROM Employees a
LEFT JOIN EmployeeUNI b
on a.id = b.id