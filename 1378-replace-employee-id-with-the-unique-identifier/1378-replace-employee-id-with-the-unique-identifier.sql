# Write your MySQL query statement below
select unique_id,name
from employees e
left join employeeuni eu
on e.id=eu.id